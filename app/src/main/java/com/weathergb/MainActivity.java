package com.weathergb;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.weathergb.winfo.WeatherRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements Constants {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=moscow&units=celsius&appid=";
    private static final String WEATHER_API_KEY = " ";

    private static final String LOG = "Activity";
    private static final String TEMPS = "TEMP_S";
    private static final int REQ_CODE_99 = 99;
    // private int currTemp = 10;

    private TextView Temp;
    private TextView Pressure;
    private TextView Wind;
    private TextView Humidity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // appTemp();
        appData();
        DaysF();
        WeatherAnimation();
        Log.i(LOG,"onCreate");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        TextView currentCity = findViewById(R.id.currentCityV);

        if (requestCode == REQ_CODE_99) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Parcel parcel = (Parcel)data.getSerializableExtra(PARCEL);
                    if (parcel != null) {
                        currentCity.setText(parcel.currentCity);
                    } else {
                        currentCity.setText(R.string.Default);
                    }
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
        Log.i(LOG,"onActivityResult");
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //currTemp = savedInstanceState.getInt(TEMPS);

        Log.i(LOG,"RestoreInstance");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putInt(TEMPS, currTemp);

        Log.i(LOG,"SaveInstance");
    }


    private void appData() {
        Temp = findViewById(R.id.textWeather);
        Pressure = findViewById(R.id.PressureStat);
        Wind = findViewById(R.id.WindSpeed);
        Humidity = findViewById(R.id.HumidityStat);
        Button rfr = findViewById(R.id.BtnRefresh);
        rfr.setOnClickListener(click);
    }


    private View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            try {
                final URL uri = new URL(WEATHER_URL + WEATHER_API_KEY);
                final Handler handler = new Handler();
                new Thread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void run() {
                        HttpsURLConnection urlC = null;
                        try {
                            urlC = (HttpsURLConnection) uri.openConnection();
                            urlC.setRequestMethod("GET");
                            urlC.setReadTimeout(10000);
                            BufferedReader in = new BufferedReader(new InputStreamReader(urlC.getInputStream()));
                            String result = getLines(in);
                            Gson gson = new Gson();
                            final WeatherRequest wr = gson.fromJson(result, WeatherRequest.class);
                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    DisplayInfo(wr);
                                }
                            });
                        } catch (Exception e) {
                            Log.i(LOG,"Fail Connection", e);
                            e.printStackTrace();
                        }
                    }
                    @RequiresApi(api = Build.VERSION_CODES.N)
                    private String getLines (BufferedReader in) {
                        return in.lines().collect(Collectors.joining("\n"));
                    }
                }).start();
            } catch (Exception e) {
                Log.i(LOG,"Fail URL", e);
                e.printStackTrace();
            }
        }
        @SuppressLint("DefaultLocale")
        private void DisplayInfo (WeatherRequest wr) {
            // TextView currentCity = findViewById(R.id.currentCityV);
            // currentCity.setText(wr.getName());
            Temp.setText(String.format("%f2", wr.getMain().getTemp()));
            Pressure.setText(String.format("%d", wr.getMain().getPressure()));
            Wind.setText(String.format("%d", wr.getWind().getSpeed()));
            Humidity.setText(String.format("%d", wr.getMain().getHumidity()));
        }
    };


//    @SuppressLint("SetTextI18n")
//    protected void appTemp() {
//        // TextView cel = findViewById(R.id.textWeather);
//        TextView cel2 = findViewById(R.id.PresentTemp);
//
//        // cel.setText(currTemp + " C");
//        cel2.setText("+ " + currTemp + " C");
//
//        Log.i(LOG,"AppLogic");
//    }


    protected void WeatherAnimation() {
        Animation animation;
        animation = AnimationUtils.loadAnimation(this, R.anim.defaultanim);
        ImageView screen = findViewById(R.id.AnimView);
        screen.startAnimation(animation);
    }


    protected void DaysF() {
        DaysFragment days = new DaysFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.DaysFragment, days);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
        Log.i(LOG,"DaysFragment");
    }


    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivityForResult(intent, REQ_CODE_99);

        Log.i(LOG,"OpenSecondActivity");
    }
}

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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.weathergb.winfo.WeatherRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity implements Constants {


    private static final String LOG = "Activity";
    private static final String TEMPS = "TEMP_S";
    private static final int REQ_CODE_99 = 99;
    private int currTemp = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Thread();
        DaysF();
        WeatherAnimation();
        Log.i(LOG, "onCreate");
    }


    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currTemp = savedInstanceState.getInt(TEMPS);

        Log.i(LOG, "RestoreInstance");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TEMPS, currTemp);

        Log.i(LOG, "SaveInstance");
    }


    private void Thread() {
        try {
            final URL uri = getUrl("moscow");
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
                        Log.i(LOG, "Fail Connection", e);
                        e.printStackTrace();
                    }
                }

                @RequiresApi(api = Build.VERSION_CODES.N)
                private String getLines(BufferedReader in) {
                    return in.lines().collect(Collectors.joining("\n"));
                }
            }).start();

        } catch (Exception e) {
            Log.i(LOG, "Fail URL", e);
            e.printStackTrace();
        }
    }


    private URL getUrl(String city) throws MalformedURLException {
        return new URL("https://api.openweathermap.org/data/2.5/weather?q="
                + city + "&units=metric&appid=" + BuildConfig.WEATHER_API_KEY);
    }


    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    private void DisplayInfo(WeatherRequest wr) {
        TextView Temp = findViewById(R.id.textWeather);
        TextView Pressure = findViewById(R.id.PressureStat);
        TextView Wind = findViewById(R.id.WindSpeed);

        TextView currentCity = findViewById(R.id.currentCityV);
        String temp = currentCity.getText().toString();

        if (!wr.getName().equals(temp)) {
            Toast.makeText(getApplicationContext(), "Неверный город", Toast.LENGTH_SHORT).show();
        }

        Temp.setText(String.format("%f2", wr.getMain().getTemp()));
        Pressure.setText(String.format("%d", wr.getMain().getPressure()));
        Wind.setText(String.format("%d", wr.getWind().getSpeed()) + " M");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        TextView currentCity = findViewById(R.id.currentCityV);

        if (requestCode == REQ_CODE_99) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    Parcel parcel = (Parcel) data.getSerializableExtra(PARCEL);
                    if (parcel != null) {
                            currentCity.setText(parcel.currentCity);
                            try {
                                getUrl(String.valueOf(parcel));
                            } catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                    } else {
                        currentCity.setText(R.string.Default);
                    }
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
        Log.i(LOG, "onActivityResult");
    }


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
        Log.i(LOG, "DaysFragment");
    }


    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivityForResult(intent, REQ_CODE_99);
        Log.i(LOG, "OpenSecondActivity");
    }


    public void onRefresh(View v) {
        Thread();
        Log.i(LOG, "Thread Launch");
    }
}

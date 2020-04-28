package com.weathergb;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Constants {

    // Добавить RecycleView
    // Исправил парсель

    private static final String LOG = "Activity";
    private static final String TEMPS = "TEMP_S";
    private static final int REQ_CODE_99 = 99;
    private int currTemp = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appTemp();
        DaysF();
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
                        String City = "Paris";
                        currentCity.setText(City);
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
        currTemp = savedInstanceState.getInt(TEMPS);

        Log.i(LOG,"RestoreInstance");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TEMPS, currTemp);

        Log.i(LOG,"SaveInstance");
    }


    @SuppressLint("SetTextI18n")
    protected void appTemp() {
        TextView cel = findViewById(R.id.textWeather);
        TextView cel2 = findViewById(R.id.PresentTemp);

        cel.setText(currTemp + " C");
        cel2.setText("+ " + currTemp + "C");

        Log.i(LOG,"AppLogic");
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

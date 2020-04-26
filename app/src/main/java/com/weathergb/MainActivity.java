package com.weathergb;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

// Добавил SecondActivity с адекватным парселем 


public class MainActivity extends AppCompatActivity implements Constants {

    // Констната Лога
    private static final String LOG = "Activity";
    private static final String TEMPS = "TEMP_S";
    // Температура на данный момент
    // Вынес в класс по примеру из урока
    private int currTemp = 10;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView currentCity = findViewById(R.id.currentCityV);
        Parcel parcel = (Parcel) getIntent().getSerializableExtra(PARCEL);

        if (parcel == null) {
            currentCity.setText("Default");
        } else {
            currentCity.setText(parcel.currentCity);
        }

        pLogick();
        Log.i(LOG,"onCreate");
    }


    @Override
    protected void onStart() {
        super.onStart();
    }


    // Возвращаемся
    @Override
    protected void onResume() {
        super.onResume();
    }


    // Пауза
    @Override
    protected void onPause() {
        super.onPause();
    }


    // Перезапуск
    @Override
    protected void onRestart() {
        super.onRestart();
    }


    // Восстановление
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        currTemp = savedInstanceState.getInt(TEMPS);

        Log.i(LOG,"RestoreInstance");
    }


    // Сохранение данных
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TEMPS, currTemp);

        Log.i(LOG,"SaveInstance");
    }


    // Остановка
    @Override
    protected void onStop() {
        super.onStop();
    }


    // Смэрть
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    // Логика установки температуры
    @SuppressLint("SetTextI18n")
    protected void pLogick() {
        TextView cel = findViewById(R.id.textWeather);
        TextView cel2 = findViewById(R.id.PresentTemp);

        cel.setText(currTemp + "C");
        cel2.setText(String.valueOf(currTemp));

        Log.i(LOG,"AppLogic");
    }


    // Кнопка открытия второго Активити
    public void onClick(View v) {
        // Переход на SecondActivity
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);

        // Toast.makeText(getApplicationContext(), "Фрагмент", Toast.LENGTH_SHORT).show();
        Log.i(LOG,"OpenSecondActivity");
    }


    // Кнопка добавления фрагмента списка городов
    public void openList(View view) {
        ChoseCity cityFragment = new ChoseCity();
        Button open = findViewById(R.id.buttonQuestion);
        open.setOnClickListener(new ListenerOnAdd(cityFragment));
        Log.i(LOG,"openList");
    }


    // Конструктор из урока
    class ListenerOnAdd implements View.OnClickListener {

        Fragment fragment;

        ListenerOnAdd(Fragment fragment) {
            this.fragment = fragment;
        }

        @Override
        public void onClick(View v) {
            addFragment();
        }

        private void addFragment() {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.ChoseCity, fragment);
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.commit();
            Log.i(LOG,"addCityList");
        }
    }
}

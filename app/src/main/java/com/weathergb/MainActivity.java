package com.weathergb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

        pLogick();

        // Прницип работы кнопки перехода на второе активити из урока
        Button startAct = findViewById(R.id.buttonAdd);
        startAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
                // Стираем из поля название города чтобы перезаписать новое
                TextView city = findViewById(R.id.textCity);
                city.setText("");
                // Запускаем метод возврата нового города
                returnCity();
            }
        });

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


    // Логика
    @SuppressLint("SetTextI18n")
    protected void pLogick() {
        TextView cel = findViewById(R.id.textWeather);
        TextView cel2 = findViewById(R.id.PresentTemp);

        cel.setText(currTemp + "C");
        cel2.setText(String.valueOf(currTemp));

        Log.i(LOG,"AppLogic");
    }


    // Логика замены названия города
    protected void returnCity() {
        Intent intent = getIntent();
        Middle mCity = intent.getParcelableExtra("CITY");
        // Предложение от IDE
        String ParCity = null;
        // Условие и выполнение получения нового города
        // Такое условие предложил сам IDE
        if (mCity != null) {
            ParCity = mCity.getCityP();
        }
        TextView city = findViewById(R.id.textCity);
        city.setText(ParCity);

        Log.i(LOG,"returnCity");
    }


    // Тестирую Toast
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Работает", Toast.LENGTH_SHORT).show();

        Log.i(LOG,"ToastButton");
    }

}

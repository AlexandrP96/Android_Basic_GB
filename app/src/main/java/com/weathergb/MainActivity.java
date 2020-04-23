package com.weathergb;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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


        Toast.makeText(getApplicationContext(), "Replaced", Toast.LENGTH_SHORT).show();
        Log.i(LOG,"returnCity");
    }


    // Тестирую Toast
    public void onClick(View v) {
        Toast.makeText(getApplicationContext(), "Фрагмент", Toast.LENGTH_SHORT).show();
        Log.i(LOG,"ToastButton");
    }

}

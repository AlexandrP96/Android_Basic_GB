/*
* 1 Исправил работоспособность программы (manifest - android backup)
* 2 Перевёл данные из кода в values по замечанию из прошлого ДЗ
* 3 Убрал тосты из всех этапов работы MainActivity
* 4 Метод pLogick() был упрощен
* 5
* 6
 */
package com.weathergb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LIFECYCLE = "LIFE_CYCLE";
    private static final String TEMPS = "TEMP_S";
    // Температура на данный момент
    // Вынес в класс по примеру из урока
    private int currTemp = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pLogick();
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
    }

    // Сохранение данных
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(TEMPS, currTemp);
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

    // Кнокпа перехода на второй активити
    public void open(View view) {
        Intent intent = new Intent("com.weathergb.SecondActivity");
        startActivity(intent);
    }

    // Логика
    @SuppressLint("SetTextI18n")
    protected void pLogick() {
        TextView cel = findViewById(R.id.textWeather);
        TextView cel2 = findViewById(R.id.PresentTemp);
        cel.setText(String.valueOf(currTemp));
        cel2.setText(String.valueOf(currTemp));
    }

    // Тестирую Toast
    public void onClick(View v) {
        Toaster("Тост");
    }

    // Метод создания тостов и логов
    private void Toaster(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        Log.d(LIFECYCLE, msg);
    }
}

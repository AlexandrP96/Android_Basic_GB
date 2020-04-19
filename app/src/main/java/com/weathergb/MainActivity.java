/*
* 1 Исправил работоспособность программы (manifest - android backup)
* 2 Перевёл данные из кода в values по замечанию из прошлого ДЗ
* 3 Убрал тосты из всех этапов работы MainActivity
* 4 Метод pLogick() был упрощен
* 5 Поменял способ создания второго активити на тот что был в уроке
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
import android.widget.Button;
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

        // Прницип работы кнопки перехода на второе активити из урока
        Button startAct = findViewById(R.id.buttonAdd);
        startAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

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

    // Логика
    @SuppressLint("SetTextI18n")
    protected void pLogick() {
        TextView cel = findViewById(R.id.textWeather);
        TextView cel2 = findViewById(R.id.PresentTemp);

        cel.setText(currTemp + "C");
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

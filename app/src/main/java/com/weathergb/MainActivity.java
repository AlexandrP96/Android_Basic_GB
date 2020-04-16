/*
* 1 Перенёс типы данных внутрь метода
* 2 Перенёс логику в отдельный метод
* 3 Добавил этапы работы activity из урока
* 4 Исправил переход на другой экран активити в приложении
* 5 Добавил Логер из урока во все этапы работы по ДЗ
* 6 Добавил функционал сохранения данных из урока для currTemp (Температура на данный момент)
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
        Toaster("onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toaster("onStart");
    }

    // Возвращаемся
    @Override
    protected void onResume() {
        super.onResume();
        Toaster("onResume");
    }

    // Пауза
    @Override
    protected void onPause() {
        super.onPause();
        Toaster("onPause");
    }

    // Перезапуск
    @Override
    protected void onRestart() {
        super.onRestart();
        Toaster("onRestart");
    }

    // Восстановление
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toaster("onRestoreInstanceState");
        currTemp = savedInstanceState.getInt(TEMPS);
    }

    // Сохранение данных
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Toaster("onSaveInstanceState");
        outState.putInt(TEMPS, currTemp);
    }

    // Остановка
    @Override
    protected void onStop() {
        super.onStop();
        Toaster("onStop");
    }

    // Смэрть
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toaster("onDestroy");
    }

    // Кнокпа перехода на второй активити
    public void open(View view) {
        Intent intent = new Intent("com.weathergb.SecondActivity");
        startActivity(intent);
    }

    // Логика
    @SuppressLint("SetTextI18n")
    public void pLogick() {
        // Выбранная страна в данный момент
        String currCountry;
        // Выбранный город
        String cityS;
        char stateP = '+';
        char stateM = '-';
        // Тип температуры, значение будет меняться в настройках
        char TempType = 'C';
        // Три дня вперёд
        String FirstD, SecondD, ThirdD;
        // Температура на дни
        int FirstN, SecondN, ThridN;

        TextView cel = findViewById(R.id.textWeather);
        TextView city = findViewById(R.id.textCity);
        TextView greeting = findViewById(R.id.textStatus);
        TextView country = findViewById(R.id.textCountry);
        TextView past = findViewById(R.id.textPast);
        TextView present = findViewById(R.id.textPresent);
        TextView future = findViewById(R.id.textFuture);
        TextView type = findViewById(R.id.textType);
        TextView dayOne = findViewById(R.id.dayOne);
        TextView dayTwo = findViewById(R.id.dayTwo);
        TextView dayThree = findViewById(R.id.dayThree);
        TextView d1 = findViewById(R.id.d1);
        TextView d2 = findViewById(R.id.d2);
        TextView d3 = findViewById(R.id.d3);

        cityS = "Москва";
        currCountry = "Россия";
        FirstD = "Суббота";
        SecondD = "Воскресенье";
        ThirdD = "Понедельник";
        FirstN = 8;
        SecondN = 10;
        ThridN = 12;
        int pTemp = 10, fTemp = 10, paTemp = 8;

        cel.setText(stateP + " " + currTemp + TempType);
        city.setText(cityS);
        country.setText(currCountry);
        greeting.setText("Доброе утро!");
        past.setText(stateP + " " + paTemp + " " + TempType + "\n" + "8:00");
        present.setText(stateP + " " + pTemp + " " + TempType + "\n" + "9:00");
        future.setText(stateP + " " + fTemp + " " + TempType + "\n" + "10:00");
        type.setText("Ясно");
        dayOne.setText(FirstD);
        d1.setText(stateP + " " + FirstN + " " + TempType);
        dayTwo.setText(SecondD);
        d2.setText(stateP + " " + SecondN + " " + TempType);
        dayThree.setText(ThirdD);
        d3.setText(stateP + " " +ThridN + " " + TempType);
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

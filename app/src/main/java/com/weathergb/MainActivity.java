package com.weathergb;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

// Добавил SecondActivity с адекватным парселем
// Убрал из приложения неиспользуемые этапы Activity (onRestart и тд)
// Добавил в activity_main фрагмент со списком темературы на неделю - DaysF()
// Добавил в values два списка eng/ru дней недели
// Убрал элемент интерфейса main_activity FutureDays
// Изменил дизайн программы, заменил шрифты, цвет слов

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
        // Объект City (Дефолтный город для отображения при запуске)
        String City = "London";
        // Условие при запуске приложения для parcel
        if (parcel == null) {
            currentCity.setText(City);
        } else {
            currentCity.setText(parcel.currentCity);
        }

        appTemp();
        DaysF();
        Log.i(LOG,"onCreate");
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


    // Логика установки температуры
    @SuppressLint("SetTextI18n")
    protected void appTemp() {
        TextView cel = findViewById(R.id.textWeather);
        TextView cel2 = findViewById(R.id.PresentTemp);

        cel.setText(currTemp + " C");
        cel2.setText(String.valueOf(currTemp));

        Log.i(LOG,"AppLogic");
    }


    // Фрагмент с температурой по дням
    protected void DaysF() {
        DaysFragment days = new DaysFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.DaysFragment, days);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
        Log.i(LOG,"DaysFragment");
    }


    // Кнопка открытия второго Активити
    public void onClick(View v) {
        // Переход на SecondActivity
        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(intent);

        // Toast.makeText(getApplicationContext(), "Фрагмент", Toast.LENGTH_SHORT).show();
        Log.i(LOG,"OpenSecondActivity");
    }
}

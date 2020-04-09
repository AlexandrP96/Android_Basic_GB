package com.weathergb;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Кнопка тест
    @SuppressLint({"SetTextI18n", "ResourceType"})
    public void btnRandom(View V) {
        TextView greeting = findViewById(R.id.textStatus);
        TextView cel = findViewById(R.id.textWeather);
        TextView country = findViewById(R.id.textCountry);
        TextView city = findViewById(R.id.textCity);
        TextView past = findViewById(R.id.textPast);
        TextView present = findViewById(R.id.textPresent);
        TextView future = findViewById(R.id.textFuture);
        TextView type = findViewById(R.id.textType);
        TextView dayOne = findViewById(R.id.dayOne);
        TextView dayTwo = findViewById(R.id.dayTwo);
        TextView dayThree = findViewById(R.id.dayThree);
        int a = (int) (Math.random() * 5);

        if (a == 0) {
            cel.setText("+ 9");
            city.setText("Москва");
            country.setText("Россия");
            greeting.setText("Доброе утро!");
            past.setText("+ 8C" + "\n" + "8:00");
            present.setText("+ 9C" + "\n" + "9:00");
            future.setText("+ 10C" + "\n" + "10:00");
            type.setText("Ясно");
            dayOne.setText("Суббота +8 -2");
            dayTwo.setText("Воскресенье +10  0");
            dayThree.setText("Понедельник +11 -1");
        } if (a == 1) {
            cel.setText("- 15");
            city.setText("Осло");
            country.setText("Норвегия");
            greeting.setText("Добрый вечер!");
            past.setText("- 13C" + "\n" + "19:00");
            present.setText("- 15C" + "\n" + "20:00");
            future.setText("- 16C" + "\n" + "21:00");
            type.setText("Туман");
            dayOne.setText("Суббота -12 -18");
            dayTwo.setText("Воскресенье -10 -15");
            dayThree.setText("Понедельник -20 -25");
        } if (a == 2) {
            cel.setText("  0");
            city.setText("Берлин");
            country.setText("Германия");
            greeting.setText("Доброй ночи!");
            past.setText("  0C" + "\n" + "00:00");
            present.setText("  0C" + "\n" + "01:00");
            future.setText("+ 1C" + "\n" + "02:00");
            type.setText("Облака");
            dayOne.setText("Суббота +2 -1");
            dayTwo.setText("Воскресенье +5  0");
            dayThree.setText("Понедельник +3 -2");
        } if (a == 3) {
            cel.setText("+ 20");
            city.setText("Кемер");
            country.setText("Турция");
            greeting.setText("Доброе утро!");
            past.setText("+ 18C" + "\n" + "9:00");
            present.setText("+ 20C" + "\n" + "10:00");
            future.setText("+ 21C" + "\n" + "11:00");
            type.setText("Ясно");
            dayOne.setText("Суббота +25 +12");
            dayTwo.setText("Воскресенье +30 +15");
            dayThree.setText("Понедельник +32 +15");
        } if (a == 4) {
            cel.setText(" - 3");
            city.setText("Лондон");
            country.setText("Англия");
            greeting.setText("Доброго дня!");
            past.setText("- 3C" + "\n" + "12:00");
            present.setText("- 3C" + "\n" + "12:00");
            future.setText("- 2C" + "\n" + "13:00");
            type.setText("Пасмурно");
            dayOne.setText("Суббота -2 -1");
            dayTwo.setText("Воскресенье -1  0");
            dayThree.setText("Понедельник -4 -6");
        }
    }
}

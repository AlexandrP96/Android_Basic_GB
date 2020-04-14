package com.weathergb;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Температура на данный момент
    private int currTemp;
    // Выбранная страна в данный момент
    private String currCountry;
    // Выбранный город
    private String cityS;
    private char stateP = '+';
    private char stateM = '-';
    // Тип температуры, значение будет меняться в настройках
    private char TempType = 'C';
    // Три дня вперёд
    private String FirstD, SecondD, ThirdD;
    // Температура на дни
    private int FirstN, SecondN, ThridN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Тестирую Toast
    public void onClick(View v) {
        Toast.makeText(this, "Пашет!", Toast.LENGTH_SHORT).show();
    }

    // Кнокпа создания второго активити
    public void open(View view) {
        setContentView(R.layout.activity_chose);
    }

    // Кнопка тест
    @SuppressLint({"SetTextI18n", "ResourceType"})
    public void btnRandom(View V) {
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

        int a = (int) (Math.random() * 3);
        if (a == 0) {
            cityS = "Москва";
            currCountry = "Россия";
            FirstD = "Суббота";
            SecondD = "Воскресенье";
            ThirdD = "Понедельник";
            FirstN = 8;
            SecondN = 10;
            ThridN = 12;
            int pTemp = 10, fTemp = 10, paTemp = 8;
            currTemp = pTemp;
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
        } if (a == 1) {
            cityS = "Осло";
            currCountry = "Норвегия";
            FirstD = "Понедельник";
            SecondD = "Вторник";
            ThirdD = "Среда";
            FirstN = 2;
            SecondN = 5;
            ThridN = 3;
            int pTemp = 4, fTemp = 3, paTemp = 2;
            currTemp = pTemp;
            cel.setText(stateM + " " + currTemp + TempType);
            city.setText(cityS);
            country.setText(currCountry);
            greeting.setText("Добрый вечер!");
            past.setText(stateM + " " + paTemp + " " + TempType + "\n" + "8:00");
            present.setText(stateM + " " + pTemp + " " + TempType + "\n" + "9:00");
            future.setText(stateM + " " + fTemp + " " + TempType + "\n" + "10:00");
            type.setText("Туман");
            d1.setText(stateM + " " + FirstN + " " + TempType);
            dayTwo.setText(SecondD);
            d2.setText(stateM + " " + SecondN + " " + TempType);
            dayThree.setText(ThirdD);
            d3.setText(stateM + " " +ThridN + " " + TempType);
        } if (a == 2) {
            cityS = "Берлин";
            currCountry = "Германия";
            FirstD = "Понедельник";
            SecondD = "Вторник";
            ThirdD = "Среда";
            FirstN = 1;
            SecondN = 2;
            ThridN = 1;
            int pTemp = 3, fTemp = 4, paTemp = 1;
            currTemp = pTemp;
            cel.setText(stateP + " " + currTemp + TempType);
            city.setText(cityS);
            country.setText(currCountry);
            greeting.setText("Доброй ночи!");
            past.setText(stateP + " " + paTemp + " " + TempType + "\n" + "8:00");
            present.setText(stateP + " " + pTemp + " " + TempType + "\n" + "9:00");
            future.setText(stateP + " " + fTemp + " " + TempType + "\n" + "10:00");
            type.setText("Облака");
            d1.setText(stateM + " " + FirstN + " " + TempType);
            dayTwo.setText(SecondD);
            d2.setText(stateM + " " + SecondN + " " + TempType);
            dayThree.setText(ThirdD);
            d3.setText(stateM + " " +ThridN + " " + TempType);
        }
    }
}

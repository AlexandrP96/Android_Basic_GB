package com.weathergb;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

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

        // Устанавливаем дефолтный фрагмент (Временное)
        DefaultFragment fragmentD = new DefaultFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.FragmentContainer, fragmentD);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();

        Log.i(LOG,"DefaultCity");
        Log.i(LOG,"AppLogic");
    }


    // Кнопка замены фрагмента
    public void onClick(View v) {
        TestFragment fragmentT = new TestFragment();
        // new ListenerOnReplace(fragmentT);
        // Логика из урока
        Button add1 = findViewById(R.id.buttonAdd);
        add1.setOnClickListener(new ListenerOnReplace(fragmentT));
        Toast.makeText(getApplicationContext(), "Фрагмент", Toast.LENGTH_SHORT).show();
        Log.i(LOG,"onClick");
    }


    // Кнопка добавления фрагмента списка городов
    public void openList(View view) {
        ChoseCity cityFragment = new ChoseCity();
        Button open = findViewById(R.id.buttonQuestion);
        open.setOnClickListener(new ListenerOnAdd(cityFragment));
        Log.i(LOG,"openList");
    }


    // Конструктор из программы первого урока
    class ListenerOnReplace implements View.OnClickListener {

         Fragment fragment;

        ListenerOnReplace(Fragment fragment) {
           this.fragment = fragment;
        }

        @Override
        public void onClick(View v) {
            replaceFragment();
        }

        // Заменить фрагмент
        private void replaceFragment() {
            TestFragment fragmentT = new TestFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.FragmentContainer, fragmentT);
            fragmentTransaction.addToBackStack("");
            fragmentTransaction.commit();

            Log.i(LOG,"replaceCity");
        }
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

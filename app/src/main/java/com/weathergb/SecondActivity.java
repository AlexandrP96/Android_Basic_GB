package com.weathergb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

@SuppressLint("Registered")
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose);
    }

    // Тост
    // выбивает ошибку
    public void add(View view) {
        Toast.makeText(this, "Добавлено", Toast.LENGTH_SHORT).show();
    }

    // Возвращаем главное activity
    // Выбивает ошибку
    public void back(View view) {
        setContentView(R.layout.activity_main);
    }
}

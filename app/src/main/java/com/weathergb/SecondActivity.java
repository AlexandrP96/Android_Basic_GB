package com.weathergb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements Constants {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Тестовый кусок кода, при нажатии на название города парсится его название в main
        // Пока работает только переход (сам парсель тупо переносит пустое поле)
        TextView textView = findViewById(R.id.CityFive);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra(PARCEL,createParcel());
                startActivity(intent);
            }
        });
    }


    public void AddButton(View view) {
            CreateIntent();
    }


    private void CreateIntent() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra(PARCEL,createParcel());
        startActivity(intent);
    }


    private Parcel createParcel() {
        EditText SecondView = findViewById(R.id.UserText);
        Parcel parcel = new Parcel();
        parcel.currentCity = SecondView.getText().toString();
        return parcel;
    }
}

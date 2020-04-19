package com.weathergb;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("Registered")
public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chose);


        Button returnB = findViewById(R.id.AddB);
        returnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView CityText = findViewById(R.id.editText);
                String sCity = CityText.getText().toString();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                // Указываем данные которые нужно сохранить в Parse (Middle)
                intent.putExtra("CITY", sCity);
                startActivity(intent);

                Toast.makeText(getApplicationContext(), "Добавлено", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

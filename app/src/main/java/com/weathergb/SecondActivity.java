package com.weathergb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class SecondActivity extends AppCompatActivity implements Constants {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }


    public void AddButton(View view) {
            CreateIntent();
    }


    private void CreateIntent() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra(PARCEL, createParcel());
        setResult(RESULT_OK, intent);
        finish();
    }


    private Parcel createParcel() {
        EditText SecondView = findViewById(R.id.UserText);
        Parcel parcel = new Parcel();
        parcel.currentCity = SecondView.getText().toString();
        return parcel;
    }
}

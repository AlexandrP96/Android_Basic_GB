package com.weathergb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class SecondActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String[] data = getResources().getStringArray(R.array.cities);
        initList(data);
    }


    private void initList(String[] data) {
        final RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        LayoutManager(recyclerView);

        final Recycler adapter = new Recycler(data);
        recyclerView.setAdapter(adapter);

        onRecyclerClick(adapter);
    }


    private void LayoutManager(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
    }


    private void onRecyclerClick(Recycler adapter) {
        adapter.SetOnItemClickListener(new Recycler.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                EditText SecondView = findViewById(R.id.UserText);
                if (position == 0) {
                    SecondView.setText(R.string.Tokyo);
                    CreateIntent();
                }
                if (position == 1) {
                    SecondView.setText(R.string.New_York);
                    CreateIntent();
                }
            }
        });
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

        if (parcel.currentCity.equals("")) {
            SecondView.setText(R.string.Default);
            parcel.currentCity = SecondView.getText().toString();
        }
        return parcel;
    }
}

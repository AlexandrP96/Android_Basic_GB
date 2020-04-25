package com.weathergb;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ChoseCity extends Fragment {

    public ChoseCity() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chose_city, container, false);
    }

    public void ChoseButton(View view) {
        Toast.makeText(getContext(), "Не пашет", Toast.LENGTH_SHORT).show();
    }
}

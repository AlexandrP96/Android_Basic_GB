package com.weathergb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainRecycler extends Fragment implements MainFragment {

    private ListAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_days, container, false);
        iniList(root);
        ((MainActivity)requireActivity()).setFragmentList(this);
        setHasOptionsMenu(true);
        return root;
    }


    private void iniList(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.RecyclerView);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new ListAdapter(initData(), this);
        recyclerView.setAdapter(adapter);
    }


    private List<String> initData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(String.valueOf(i));
        }
        return list;
    }


    @Override
    public void addCity(String str) {
        adapter.addItem(str);
    }
}

package com.weathergb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<String> data;
    private Fragment fragment;
    private int menuPosition;

    public ListAdapter(List<String> data, Fragment fragment){
        this.data = data;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        TextView textElement = holder.getTextElement();
        textElement.setText(data.get(position));

        textElement.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                menuPosition = position;
                return false;
            }
        });

        if (fragment != null){
            fragment.registerForContextMenu(textElement);
        }
    }

    public void addItem(String element){
        data.add(element);
        notifyItemInserted(data.size()-1);
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public int getMenuPosition() {
        return menuPosition;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textElement;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textElement = itemView.findViewById(R.id.textElement);
        }

        public TextView getTextElement() {
            return textElement;
        }
    }
}

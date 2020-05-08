package com.weathergb;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class SocAdapter extends RecyclerView.Adapter<SocAdapter.ViewHolder> {

    private String[] dataSource;
    private OnItemClickListener onItemClickListener;


    SocAdapter(String[] dataSource) {
        this.dataSource = dataSource;
    }


    @NonNull
    @Override
    public SocAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SocAdapter.ViewHolder holder, int position) {
        holder.getTextView().setText(dataSource[position]);
    }

    @Override
    public int getItemCount() {
        return dataSource.length;
    }


    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }


    void SetOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView;


            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            });
        }


        TextView getTextView() {
            return textView;
        }
    }
}

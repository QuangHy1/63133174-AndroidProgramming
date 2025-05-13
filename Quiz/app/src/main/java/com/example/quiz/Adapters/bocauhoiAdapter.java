package com.example.quiz.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.Models.bocauhoiModel;

import java.util.ArrayList;

public class bocauhoiAdapter extends RecyclerView.Adapter<bocauhoiAdapter.viewHolder>{

    Context context;
    ArrayList<bocauhoiModel> list;

    public bocauhoiAdapter(Context context, ArrayList<bocauhoiModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        public viewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

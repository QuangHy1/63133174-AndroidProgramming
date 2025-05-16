package com.example.quiz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quiz.Activities.CauHoiActivity;
import com.example.quiz.Models.bocauhoiModel;
import com.example.quiz.R;
import com.example.quiz.databinding.ItemBocauhoiBinding;

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
        View view = LayoutInflater.from(context).inflate(R.layout.item_bocauhoi,parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final bocauhoiModel model = list.get(position);
        holder.binding.tenBoCauHoi.setText(model.getTenBoCauHoi());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CauHoiActivity.class);
                intent.putExtra("BỘ", model.getTenBoCauHoi());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ItemBocauhoiBinding binding;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemBocauhoiBinding.bind(itemView);
        }
    }
}

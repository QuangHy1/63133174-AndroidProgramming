package com.example.quiz.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.quiz.Adapters.bocauhoiAdapter;
import com.example.quiz.Models.bocauhoiModel;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityBoCauHoiBinding;

import java.util.ArrayList;

public class BoCauHoiActivity extends AppCompatActivity {

    ActivityBoCauHoiBinding binding;
    ArrayList<bocauhoiModel> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBoCauHoiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Đóng activity và quay lại activity trước
            }
        });

        ActionBar actionBar = getSupportActionBar(); // Lấy đối tượng ActionBar
        if (actionBar != null) {
            actionBar.hide(); // Chỉ ẩn nếu ActionBar tồn tại
        }


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.bocauhoiRecy.setLayoutManager(linearLayoutManager);

        list = new ArrayList<>();
        list.add(new bocauhoiModel("BỘ-1"));
        list.add(new bocauhoiModel("BỘ-2"));
        list.add(new bocauhoiModel("BỘ-3"));
        list.add(new bocauhoiModel("BỘ-4"));
        list.add(new bocauhoiModel("BỘ-5"));
        list.add(new bocauhoiModel("BỘ-6"));
        list.add(new bocauhoiModel("BỘ-7"));
        list.add(new bocauhoiModel("BỘ-8"));
        list.add(new bocauhoiModel("BỘ-9"));
        list.add(new bocauhoiModel("BỘ-10"));

        bocauhoiAdapter adapter = new bocauhoiAdapter(this,list);
        binding.bocauhoiRecy.setAdapter(adapter);


    }
}
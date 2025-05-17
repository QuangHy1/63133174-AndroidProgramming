package com.example.quiz.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quiz.R;
import com.example.quiz.databinding.ActivitySoDiemBinding;

public class SoDiemActivity extends AppCompatActivity {

    ActivitySoDiemBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySoDiemBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Xử lý các sự kiện nút quay lại (back)
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

        int tongDiem = getIntent().getIntExtra("tongDiem", 0);
        int dapAnChinhXac = getIntent().getIntExtra("dapAnChinhXac", 0);

        int dapAnKhongChinhXac = tongDiem - dapAnChinhXac; // Tính số câu sai bằng công thức tongDiem - dapAnChinhXac

        // Hiển thị các kết quả này lên các TextView tương ứng thông qua binding:
        binding.soCauHoi.setText(String.valueOf(tongDiem));
        binding.dapAnDung.setText(String.valueOf(dapAnChinhXac));
        binding.dapAnSai.setText(String.valueOf(dapAnKhongChinhXac));

        // Xử lý các sự kiện nút "Thử lại" (btnThulai)
        binding.btnThulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SoDiemActivity.this, BoCauHoiActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // Xử lý các sự kiện nút "Thoát" (btnThoat)
        binding.btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
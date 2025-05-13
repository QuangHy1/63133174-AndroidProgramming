package com.example.quiz;

import androidx.appcompat.app.ActionBar;
import  androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.quiz.Activities.BoCauHoiActivity;

public class MainActivity extends AppCompatActivity {

    CardView lichsu, khoahoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar(); // Lấy đối tượng ActionBar
        if (actionBar != null) {
            actionBar.hide(); // Chỉ ẩn nếu ActionBar tồn tại
        }

        lichsu = findViewById(R.id.lichsu);
        khoahoc = findViewById(R.id.khoahoc);

        lichsu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BoCauHoiActivity.class);
                startActivity(intent);
            }
        });

    }
}
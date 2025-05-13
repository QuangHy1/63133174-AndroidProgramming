package com.example.quiz.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.quiz.MainActivity;
import com.example.quiz.R;

public class ChaoMungActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chao_mung);

        ActionBar actionBar = getSupportActionBar(); // Lấy đối tượng ActionBar
        if (actionBar != null) {
            actionBar.hide(); // Chỉ ẩn nếu ActionBar tồn tại
        }

        // tạo đối tượng Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ChaoMungActivity.this, MainActivity.class); // chuyển từ ChaoMungActivity sang MainActivity
                startActivity(intent);
            }
        },2000);// hiện layout activity_chao_mung.xml trong 2s, sau đó sang MainActivity

    }
}
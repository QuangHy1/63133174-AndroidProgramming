package vn.lequanghuy;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button bntCau1;
    Button bntCau2;
    Button bntCau3;
    Button bntCau4;
    Button bntCau5;

    void TimDieuKhien(){
        bntCau1 = (Button) findViewById(R.id.btnCau1);
        bntCau2 = (Button) findViewById(R.id.btnCau2);
        bntCau3 = (Button) findViewById(R.id.btnCau3);
        bntCau4 = (Button) findViewById(R.id.btnCau4);
        bntCau5 = (Button) findViewById(R.id.btnCau5);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Tìm điều khiển nút bấm
        TimDieuKhien();

        //Gán bộ lắng nghe sự kiện
        bntCau1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xử lý chuyển màn hình
                //B1. Tạo bộ Itent 2 tham số:
                // 1) Màn hình hiện tại .this
                // 2) Màn hình chuyển tới .class
                Intent intentBtnCau1 = new Intent(MainActivity.this, ActivityCau1.class);

                //B2. Gửi
                startActivity(intentBtnCau1);
            }
        });

        bntCau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xử lý chuyển màn hình
                //B1. Tạo bộ Itent 2 tham số:
                // 1) Màn hình hiện tại .this
                // 2) Màn hình chuyển tới .class
                Intent intentBtnCau2 = new Intent(MainActivity.this, ActivityCau2.class);

                //B2. Gửi
                startActivity(intentBtnCau2);
            }
        });
        bntCau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xử lý chuyển màn hình
                //B1. Tạo bộ Itent 2 tham số:
                // 1) Màn hình hiện tại .this
                // 2) Màn hình chuyển tới .class
                Intent intentBtnCau3 = new Intent(MainActivity.this, ActivityCau3.class);

                //B2. Gửi
                startActivity(intentBtnCau3);
            }
        });
        bntCau4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xử lý chuyển màn hình
                //B1. Tạo bộ Itent 2 tham số:
                // 1) Màn hình hiện tại .this
                // 2) Màn hình chuyển tới .class
                Intent intentBtnCau4 = new Intent(MainActivity.this, ActivityCau4.class);

                //B2. Gửi
                startActivity(intentBtnCau4);
            }
        });
        bntCau5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Xử lý chuyển màn hình
                //B1. Tạo bộ Itent 2 tham số:
                // 1) Màn hình hiện tại .this
                // 2) Màn hình chuyển tới .class
                Intent intentBtnCau5 = new Intent(MainActivity.this, ActivityCau5.class);

                //B2. Gửi
                startActivity(intentBtnCau5);
            }
        });

            // Hoặc có thể làm
//        // Khai báo và ánh xạ các nút
//        Button btnCau1 = findViewById(R.id.btnCau1);
//        Button btnCau2 = findViewById(R.id.btnCau2);
//        Button btnCau3 = findViewById(R.id.btnCau3);
//        Button btnCau4 = findViewById(R.id.btnCau4);
//        Button btnCau5 = findViewById(R.id.btnCau5);

//        // Xử lý sự kiện nhấn nút
//        btnCau1.setOnClickListener(v -> openActivity(ActivityCau1.class));
//        btnCau2.setOnClickListener(v -> openActivity(ActivityCau2.class));
//        btnCau3.setOnClickListener(v -> openActivity(ActivityCau3.class));
//        btnCau4.setOnClickListener(v -> openActivity(ActivityCau4.class));
//        btnCau5.setOnClickListener(v -> openActivity(ActivityCau5.class));
    }
//    public void openActivity(Class<?> activityClass) {
//        Intent intent = new Intent(MainActivity.this, activityClass);
//        startActivity(intent);
//    }
}
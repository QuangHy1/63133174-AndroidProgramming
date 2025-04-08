package vn.lequanghuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bntCau1;
    Button bntCau2;
    Button bntCau3;
    Button bntCau4;


    void TimDieuKhien(){
        bntCau1 = (Button) findViewById(R.id.btnCau1);
        bntCau2 = (Button) findViewById(R.id.btnCau2);
        bntCau3 = (Button) findViewById(R.id.btnCau3);
        bntCau4 = (Button) findViewById(R.id.btnCau4);

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
                Intent intentBtnCau1 = new Intent(MainActivity.this, ActivityChucNang2.class);

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
                Intent intentBtnCau2 = new Intent(MainActivity.this, ActivityChucNang3.class);

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
                Intent intentBtnCau3 = new Intent(MainActivity.this, ActivityChucNang4.class);

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
                Intent intentBtnCau4 = new Intent(MainActivity.this, ActivityAboutMe.class);

                //B2. Gửi
                startActivity(intentBtnCau4);
            }
        });
    }
}
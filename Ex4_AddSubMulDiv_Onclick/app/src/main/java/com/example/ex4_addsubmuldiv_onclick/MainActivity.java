package com.example.ex4_addsubmuldiv_onclick;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Khai bao cac doi tuong gan voi dieu khien tuong ung o day
    EditText editTextSo1;
    EditText editTextSo2;
    EditText editTextKQ;
    Button nutCong, nutTru, nutNhan, nutChia;

     void TimDieuKhien(){
         editTextSo1 = (EditText)findViewById(R.id.edtSo1);
         editTextSo2 = (EditText)findViewById(R.id.edtSo2);
         editTextKQ = (EditText)findViewById(R.id.edtKetQua);
         nutCong = (Button) findViewById(R.id.btnCong);
         nutTru = (Button) findViewById(R.id.btnTru);
         nutNhan = (Button) findViewById(R.id.btnNhan);
         nutChia = (Button) findViewById(R.id.btnChia);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimDieuKhien();
        //Gan bo lang nghe su kien va code xu ly cho tung nut

        nutCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLy_Cong();
            }
        });
        nutTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLy_Tru();

            }
        });
        nutNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLy_Nhan();
            }
        });
        nutChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XuLy_Chia();
            }
        });
    }

    void XuLy_Cong(){
         //lay du lieu
        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float Tong = num1 + num2;

        String chuoiKQ = String.valueOf(Tong);
        editTextKQ.setText(chuoiKQ);
    }
    void XuLy_Tru(){
        //lay du lieu
        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float Hieu = num1 - num2;

        String chuoiKQ = String.valueOf(Hieu);
        editTextKQ.setText(chuoiKQ);
    }
    void XuLy_Nhan(){
        //lay du lieu
        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float Tich = num1 * num2;

        String chuoiKQ = String.valueOf(Tich);
        editTextKQ.setText(chuoiKQ);
    }
    void XuLy_Chia(){
        //lay du lieu
        String so1 = editTextSo1.getText().toString();
        String so2 = editTextSo2.getText().toString();
        float num1 = Float.parseFloat(so1);
        float num2 = Float.parseFloat(so2);
        float Thuong = num1 / num2;

        String chuoiKQ = String.valueOf(Thuong);
        editTextKQ.setText(chuoiKQ);
    }
    //Xu ly cong

}
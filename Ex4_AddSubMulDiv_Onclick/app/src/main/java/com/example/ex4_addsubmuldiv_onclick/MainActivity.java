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
    }

    //Xu ly cong
    public void XuLyCong(View v){
        //Code xu ly cong o day
        //b1: lay du lieu ve 2 so
        //b1.1: tim EditText so 1 va so 2

        //b1.2: lay du lieu tu 2 dieu khien do
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3: chuyen du lieu tu chuoi sang con so
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //b2: Tinh toan
        float Tong = soA + soB;
        //b3: Hien ket qua
        //b3.1:

        //b3.2: Chuan bi du lieu xuat, bien thanh dang chuoi
        String chuoiKQ = String.valueOf(Tong);
        //b3.3: Gan ket qua len dieu khien
        editTextKQ.setText(chuoiKQ);
    }
    public void XuLyTru(View v){
        //Code xu ly tru o day
        //b1: lay du lieu ve 2 so
        //b1.1: tim EditText so 1 va so 2

        //b1.2: lay du lieu tu 2 dieu khien do
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3: chuyen du lieu tu chuoi sang con so
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //b2: Tinh toan
        float Hieu = soA - soB;
        //b3: Hien ket qua
        //b3.1:

        //b3.2: Chuan bi du lieu xuat, bien thanh dang chuoi
        String chuoiKQ = String.valueOf(Hieu);
        //b3.3: Gan ket qua len dieu khien
        editTextKQ.setText(chuoiKQ);

    }
    public void XuLyNhan(View v){
        //Code xu ly nhan o day
        //b1: lay du lieu ve 2 so
        //b1.1: tim EditText so 1 va so 2

        //b1.2: lay du lieu tu 2 dieu khien do
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3: chuyen du lieu tu chuoi sang con so
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //b2: Tinh toan
        float Tich = soA * soB;
        //b3: Hien ket qua
        //b3.1:

        //b3.2: Chuan bi du lieu xuat, bien thanh dang chuoi
        String chuoiKQ = String.valueOf(Tich);
        //b3.3: Gan ket qua len dieu khien
        editTextKQ.setText(chuoiKQ);

    }
    public void XuLyChia(View v){
        //Code xu ly chia o day
        //b1: lay du lieu ve 2 so
        //b1.1: tim EditText so 1 va so 2

        //b1.2: lay du lieu tu 2 dieu khien do
        String soThu1 = editTextSo1.getText().toString();
        String soThu2 = editTextSo2.getText().toString();
        //b1.3: chuyen du lieu tu chuoi sang con so
        float soA = Float.parseFloat(soThu1);
        float soB = Float.parseFloat(soThu2);
        //b2: Tinh toan
        float Thuong = soA / soB;
        //b3: Hien ket qua
        //b3.1:

        //b3.2: Chuan bi du lieu xuat, bien thanh dang chuoi
        String chuoiKQ = String.valueOf(Thuong);
        //b3.3: Gan ket qua len dieu khien
        editTextKQ.setText(chuoiKQ);
    }
}
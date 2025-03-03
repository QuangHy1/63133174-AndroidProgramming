package com.example.ex3_simplesum_linearlayoutapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Đây là bộ lắng nghe và xử lý sự kiện click lên nút tính tổng, mapping sang Java file
    public void XuLyCong(View view){
        // Tìm, tham chiếu đến điều khiển trên tệp XML
        EditText editTextSoA = findViewById(R.id.edtA);
        EditText editTextSoB = findViewById(R.id.edtB);
        EditText editTextKetQua = findViewById(R.id.edtKQ);
        // Lấy dữ liệu về ở điều khiển số a
        String strA = editTextSoA.getText().toString();
        // Lấy dữ liệu về ở điều khiển số a
        String strB = editTextSoB.getText().toString();

        // Chuyển dữ liệu sang dạng số
        int so_A = Integer.parseInt(strA);
        int so_B = Integer.parseInt(strB);

        // Tính toán theo yêu cầu
        int tong = so_A + so_B;
        String strTong = String.valueOf(tong);

        // Hiện ra màn hình
        editTextKetQua.setText(strTong);
    }
}
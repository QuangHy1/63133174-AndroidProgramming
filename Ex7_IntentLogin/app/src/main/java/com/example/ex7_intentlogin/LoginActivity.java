package com.example.ex7_intentlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        Button btnXacNhan = (Button) findViewById(R.id.btnOK);

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xử lý đăng nhập
                // Lấy dữ liệu
                // B1. Tìm tham chiếu đến điều kiện
                EditText edTenDN = (EditText) findViewById(R.id.edtUsername);
                EditText edPass = (EditText) findViewById(R.id.edtPass);
                // B2. Lấy dữ liệu
                String tenDangNhap = edTenDN.getText().toString();
                String mk = edPass.getText().toString();
                // Kiểm tra mật khẩu

                if(tenDangNhap.equals("lequanghuy") && mk.equals("123")) // MK Đúng
                {
                    // Chuyển sang màn hình home
                    Intent iQuiz = new Intent(LoginActivity.this, HomeActivity.class);
                    // Gọi dữ liệu vào iQuiz, dạng key value, key được dùng để bên kia lọc ra dữ liệu
                    iQuiz.putExtra("ten_dang_nhap",tenDangNhap);
                    iQuiz.putExtra("mk-dang_nhap",mk);
                    // Gửi đi
                    startActivity(iQuiz);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Bạn đăng nhập sai", Toast.LENGTH_LONG);
                }
            }
        });
    }
}
package vn.lequanghuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCau1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Gắn layout tương ứng với file này
        setContentView(R.layout.activity_cau1);

        // Truyền vào nút btnBack và xử lý sự kiện click
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc ActivityCau1 và quay lại Activity trước đó
            }
        });
    }

    // Bộ lắng nghe và xử lý sự kiện click trên nút Tính Tổng
    public void XuLyCong(View view){
        // Tìm, tham chiếu đến điều khiển trên tệp XML
        EditText editTextSo1 =  findViewById(R.id.edtSo1);
        EditText editTextSo2 =  findViewById(R.id.edtSo2);
        EditText editTextKQ =  findViewById(R.id.edtKQ);

        // Lấy dữ liệu về
        String strSo1 = editTextSo1.getText().toString();
        String strSo2 = editTextSo2.getText().toString();

        // Chuyển dữ liêu sang dạng số
        int so1 = Integer.parseInt(strSo1);
        int so2 = Integer.parseInt(strSo2);

        // Tính toán theo yêu cầu
        int tong = so1 + so2;
        String strTong = String.valueOf(tong); // Chuyển sang dạng chuỗi

        // Hiện ra màn hình
        editTextKQ.setText(strTong);
    }
}
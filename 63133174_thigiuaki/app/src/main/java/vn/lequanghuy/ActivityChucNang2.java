package vn.lequanghuy;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityChucNang2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Gắn layout tương ứng với file này
        setContentView(R.layout.activity_chuc_nang2);

        // Truyền vào nút btnBack và xử lý sự kiện click
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc ActivityChucNang2 và quay lại Activity trước đó
            }
        });
    }

    // Bộ lắng nghe và xử lý sự kiện click trên nút Tính Điểm TB
    public void XuLyTBC(View view) {
        // Tìm, tham chiếu đến điều khiển trên tệp XML
        EditText editTextSo1 = findViewById(R.id.edtSo1);
        EditText editTextSo2 = findViewById(R.id.edtSo2);
        EditText editTextSo3 = findViewById(R.id.edtSo3);
        EditText editTextKQ = findViewById(R.id.edtKQ);

        // Lấy dữ liệu về
        String strSo1 = editTextSo1.getText().toString();
        String strSo2 = editTextSo2.getText().toString();
        String strSo3 = editTextSo3.getText().toString();

        // Kiểm tra nếu có ô nào chưa nhập
        if (strSo1.isEmpty() || strSo2.isEmpty() || strSo3.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ điểm", Toast.LENGTH_SHORT).show();
            return;
        }

        // Chuyển dữ liệu sang dạng số thực
        float diemQT = Float.parseFloat(strSo1);
        float diemGK = Float.parseFloat(strSo2);
        float diemCK = Float.parseFloat(strSo3);

        // Tính toán điểm trung bình theo trọng số
        float diemTB = (diemQT * 0.2f) + (diemGK * 0.3f) + (diemCK * 0.5f);
        String strDiemTB = String.format("%.2f", diemTB); // Chuyển sang dạng chuỗi với 2 chữ số thập phân

        // Hiện kết quả ra màn hình
        editTextKQ.setText(strDiemTB);
    }
}

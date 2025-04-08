package vn.lequanghuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class ActivityCau5 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau5);

        // Truyền vào các thành phần và xử lý sự kiện click
        Button btnBack = findViewById(R.id.btnBack);
        // Xử lý sự kiện khi nhấn nút "Trở về"
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng Activity hiện tại
            }
        });


    }

    public void tinhBMI(View view){
        // // Tìm, tham chiếu đến điều khiển trên tệp XML
        EditText editTextCanNang = findViewById(R.id.edtCanNang);
        EditText editTextChieuCao = findViewById(R.id.edtChieuCao);
        EditText editTextKQ = findViewById(R.id.edtKQ);


        // Lấy dữ liệu về
        String strCanNang = editTextCanNang.getText().toString();
        String strChieuCao = editTextChieuCao.getText().toString();

        // Kiểm tra nếu dữ liệu nhập vào bị trống
        if (strCanNang.isEmpty()) {
            editTextCanNang.setError("Vui lòng nhập cân nặng!");
            return;
        }

        if (strChieuCao.isEmpty()) {
            editTextChieuCao.setError("Vui lòng nhập chiều cao!");
            return;
        }

        // Chuyển đổi dữ liệu từ String sang số thực
        float canNang = Float.parseFloat(strCanNang);
        float chieuCao = Float.parseFloat(strChieuCao) / 100; // Chuyển cm -> m

        // Kiểm tra giá trị nhập vào có hợp lệ không
        if (canNang <= 0 || chieuCao <= 0) {
            editTextKQ.setText("Lỗi!");
            return;
        }

        // Tính toán BMI
        float bmi = canNang / (chieuCao * chieuCao);
        String strBMI = String.valueOf(bmi); // Chuyển sang dạng chuỗi
        // Hiển thị kết quả BMI
        editTextKQ.setText(String.format("%.2f", bmi));

        // Ẩn bàn phím sau khi tính toán
        View currentFocus = getCurrentFocus();
        if (currentFocus != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(currentFocus.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

}

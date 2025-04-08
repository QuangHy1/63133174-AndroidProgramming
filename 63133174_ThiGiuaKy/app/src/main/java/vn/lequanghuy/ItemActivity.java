package vn.lequanghuy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ItemActivity extends AppCompatActivity {
    TextView txtMovieDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        // Truyền vào nút btnBack và xử lý sự kiện click
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc ActivityCau2 và quay lại Activity trước đó
            }
        });

        // Lấy dữ liệu phim từ Intent
        txtMovieDetails = findViewById(R.id.tvMovieDetails);
        String movieName = getIntent().getStringExtra("MOVIE_NAME");
        txtMovieDetails.setText(movieName);
    }
}
package vn.lequanghuy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivityCau2 extends AppCompatActivity {
    ListView lvMovies;
    ArrayList<String> moviesList;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);

        // Truyền vào nút btnBack và xử lý sự kiện click
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc ActivityCau2 và quay lại Activity trước đó
            }
        });

        // Tham chiếu ListView
        lvMovies = findViewById(R.id.lvPhim);

        // Danh sách phim tự tạo
        moviesList = new ArrayList<>();
        moviesList.add("Inception (2010) - Khoa học viễn tưởng");
        moviesList.add("Interstellar (2014) - Phiêu lưu");
        moviesList.add("The Dark Knight (2008) - Hành động");
        moviesList.add("Forrest Gump (1994) - Chính kịch");
        moviesList.add("The Shawshank Redemption (1994) - Hình sự");

        // Tạo Adapter để hiển thị dữ liệu trên ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, moviesList);
        lvMovies.setAdapter(adapter);

        // Xử lý sự kiện khi click vào item trong ListView
        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy tên bộ phim được chọn
                String selectedMovie = moviesList.get(position);
                // Hiển thị Toast thông báo phim đã chọn
                Toast.makeText(ActivityCau2.this, "Bạn đã chọn phim: " + selectedMovie, Toast.LENGTH_SHORT).show();
                // Chuyển sang ItemActivity thay vì Toast (yêu cầu đề bài)
                Intent intent = new Intent(ActivityCau2.this, ItemActivity.class);
                intent.putExtra("MOVIE_NAME", selectedMovie);
                startActivity(intent);
            }
        });

    }
}
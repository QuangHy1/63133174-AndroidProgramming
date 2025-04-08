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

public class ActivityChucNang3 extends AppCompatActivity {
    ListView lvSubjects;
    ArrayList<String> subjectList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuc_nang3);

        // Nút quay lại
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(v -> finish());

        // Tham chiếu ListView
        lvSubjects = findViewById(R.id.listViewMon);

        // Danh sách môn học
        subjectList = new ArrayList<>();
        subjectList.add("Lập trình C");
        subjectList.add("Lập trình Java");
        subjectList.add("Phát triển Ứng dụng Web");
        subjectList.add("Khai phá dữ liệu lớn");
        subjectList.add("Internet vạn vật kết nối");

        // Tạo Adapter để hiển thị dữ liệu trên ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjectList);
        lvSubjects.setAdapter(adapter);

        // Xử lý sự kiện click vào item trong ListView
        lvSubjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Lấy môn học được chọn
                String selectedSubject = subjectList.get(position);
                // Hiển thị Toast thông báo
                Toast.makeText(ActivityChucNang3.this, "Bạn đã chọn: " + selectedSubject, Toast.LENGTH_SHORT).show();
// Chuyển sang ItemActivity thay vì Toast (yêu cầu đề bài)
                Intent intent = new Intent(ActivityChucNang3.this, ItemActivity.class);
                intent.putExtra("Subject_NAME", selectedSubject);
                startActivity(intent);
            }
        });
    }
}

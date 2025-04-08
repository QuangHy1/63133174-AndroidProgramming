package vn.lequanghuy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ActivityCau3 extends AppCompatActivity {
    MovieAdapter movieAdapter;
    ArrayList <FavouriteMovies> recyclerViewDatas;
    RecyclerView recyclerViewMovies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau3);

        // Truyền vào nút btnBack và xử lý sự kiện click
        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Kết thúc ActivityCau2 và quay lại Activity trước đó
            }
        });

        //3
        recyclerViewDatas = getRecyclerViewDatas();
        //4
        recyclerViewMovies = findViewById(R.id.RecyclerMovie);
        //5
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewMovies.setLayoutManager(layoutLinear);
        //5 list theo chiều Dọc
//        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
//        recyclerViewMovies.setLayoutManager(layoutLinear);

//        //5 list theo chiều Ngang
//        RecyclerView.LayoutManager layoutLinearHorizontal = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewMovies.setLayoutManager(layoutLinearHorizontal);

//        //5 list theo Lưới GRID
//        RecyclerView.LayoutManager layoutGrid = new GridLayoutManager(this,2);
//        recyclerViewMovies.setLayoutManager(layoutGrid);

        //6
        movieAdapter = new MovieAdapter(this, recyclerViewDatas);
        //
        recyclerViewMovies.setAdapter(movieAdapter);
    }

    ArrayList<FavouriteMovies> getRecyclerViewDatas(){
        ArrayList<FavouriteMovies> dsDuLieu = new ArrayList<FavouriteMovies>();
        FavouriteMovies movies1 = new FavouriteMovies("inception", "Inception (2010) - Khoa học viễn tưởng");
        dsDuLieu.add(movies1);
        dsDuLieu.add(new FavouriteMovies("interstellar", "Interstellar (2014) - Phiêu lưu"));
        dsDuLieu.add(new FavouriteMovies("thedarkknight", "The Dark Knight (2008) - Hành động"));
        dsDuLieu.add(new FavouriteMovies("forrestgump", "Forrest Gump (1994) - Chính kịch"));
        dsDuLieu.add(new FavouriteMovies("shawshank", "The Shawshank Redemption (1994) - Hình sự"));
        return dsDuLieu;

    }
}
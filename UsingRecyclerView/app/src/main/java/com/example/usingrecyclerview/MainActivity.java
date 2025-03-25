package com.example.usingrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewDatas;
    RecyclerView recyclerViewLandscape;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3
        recyclerViewDatas = getDataForRecyclerView();
        //4
        recyclerViewLandscape = findViewById(R.id.recyclerland);
        //5 list theo chiều Dọc
//        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
//        recyclerViewLandscape.setLayoutManager(layoutLinear);

        //5 list theo chiều Ngang
//        RecyclerView.LayoutManager layoutLinearHorizontal = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewLandscape.setLayoutManager(layoutLinearHorizontal);

        //5 list theo Lưới GRID
        RecyclerView.LayoutManager layoutGrid = new GridLayoutManager(this,2);
        recyclerViewLandscape.setLayoutManager(layoutGrid);
        //6
        landScapeAdapter = new LandScapeAdapter(this, recyclerViewDatas);
        //7
        recyclerViewLandscape.setAdapter(landScapeAdapter);
    }
    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landScape1 = new LandScape("jack", "Anh jay 97");
        dsDuLieu.add(landScape1);
        dsDuLieu.add(new LandScape("sendaruby", "Sen da Ruby"));
        dsDuLieu.add(new LandScape("senduhong", "Sen da Du Hong"));
        dsDuLieu.add(new LandScape("thubongvang", "Con thu bong co mau vang"));
        return dsDuLieu;

    }
}
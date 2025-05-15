package com.example.quiz.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

import com.example.quiz.Models.cauhoiModel;
import com.example.quiz.R;
import com.example.quiz.databinding.ActivityBoCauHoiBinding;
import com.example.quiz.databinding.ActivityCauHoiBinding;

import java.util.ArrayList;

public class CauHoiActivity extends AppCompatActivity {

    ActivityCauHoiBinding binding;
    ArrayList<cauhoiModel> list = new ArrayList<>();
    private int count = 0;
    private int position = 0;
    private int scrore = 0;
    CountDownTimer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCauHoiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar(); // Lấy đối tượng ActionBar
        if (actionBar != null) {
            actionBar.hide(); // Chỉ ẩn nếu ActionBar tồn tại
        }

        String tenBoCauHoi = getIntent().getStringExtra("Bộ");

        assert tenBoCauHoi != null;
        if (tenBoCauHoi.equals("BỘ-1")){
            tenBo1();
        } else if (tenBoCauHoi.equals("Bộ-2")){

            tenBo2();
        }

        for(int i = 0; i < 4; i++){
            binding.dapanContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkDapAn((Button) view);
                }
            });
        }



    }

    private void checkDapAn(Button chonDapAn ) {
        binding.btnNext.setEnabled(true);
        binding.btnNext.setAlpha(1);

        if(chonDapAn.getText().toString().equals(list.get(position).getDapanDung())){
            scrore ++;
            chonDapAn.setBackgroundResource(R.drawable.right_answer);
        }
        else {
            chonDapAn.setBackgroundResource(R.drawable.wrong_answer);

            Button dapanDung = (Button) binding.dapanContainer.findViewWithTag(list.get(position).getDapanDung());
            dapanDung.setBackgroundResource(R.drawable.right_answer);
        }

        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.btnNext.setEnabled(false);
                binding.btnNext.setAlpha((float) 0.3);
                enableOption(true);
                position ++;

                if(position == list.size()){

                    Intent intent = new Intent(CauHoiActivity.this,);

                }


            }
        });


    }

    private void enableOption(boolean enable) {
        for (int i = 0; i < 4 ; i++){
            binding.dapanContainer.getChildAt(i).setEnabled(enable);
        }

        if(enable){
            binding.dapanContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_opt);
        }

    }

    private void tenBo2() {
        list.add(new cauhoiModel("Tình hình nước ta cuối thời Trần?",
                "Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ",
                "Vua quan chăm lo cho dân, kinh tế phát triển",
                "Quân Minh xâm lược và bóc lột nhân dân",
                "Cả 3 đáp án trên đều sai","Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ"));

        list.add(new cauhoiModel("Vị vua đầu tiên của nước ta là ai?",
                "An Dương Vương",
                "Vua Hùng Vương",
                "Bảo Đại",
                "Lê Lợi",
                "Vua Hùng Vương"));

        list.add(new cauhoiModel("Tình hình nước ta cuối thời Trần?",
                "Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ",
                "Vua quan chăm lo cho dân, kinh tế phát triển",
                "Quân Minh xâm lược và bóc lột nhân dân",
                "Cả 3 đáp án trên đều sai","Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ"));

        list.add(new cauhoiModel("Vị vua đầu tiên của nước ta là ai?",
                "An Dương Vương",
                "Vua Hùng Vương",
                "Bảo Đại",
                "Lê Lợi",
                "Vua Hùng Vương"));

        list.add(new cauhoiModel("Tình hình nước ta cuối thời Trần?",
                "Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ",
                "Vua quan chăm lo cho dân, kinh tế phát triển",
                "Quân Minh xâm lược và bóc lột nhân dân",
                "Cả 3 đáp án trên đều sai","Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ"));


    }

    private void tenBo1() {
        list.add(new cauhoiModel("Vị vua đầu tiên của nước ta là ai?",
                "An Dương Vương",
                "Vua Hùng Vương",
                "Bảo Đại",
                "Lê Lợi",
                "Vua Hùng Vương"));

        list.add(new cauhoiModel("Tình hình nước ta cuối thời Trần?",
                "Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ",
                "Vua quan chăm lo cho dân, kinh tế phát triển",
                "Quân Minh xâm lược và bóc lột nhân dân",
                "Cả 3 đáp án trên đều sai","Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ"));

        list.add(new cauhoiModel("Vị vua đầu tiên của nước ta là ai?",
                "An Dương Vương",
                "Vua Hùng Vương",
                "Bảo Đại",
                "Lê Lợi",
                "Vua Hùng Vương"));

        list.add(new cauhoiModel("Tình hình nước ta cuối thời Trần?",
                "Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ",
                "Vua quan chăm lo cho dân, kinh tế phát triển",
                "Quân Minh xâm lược và bóc lột nhân dân",
                "Cả 3 đáp án trên đều sai","Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ"));


    }
}
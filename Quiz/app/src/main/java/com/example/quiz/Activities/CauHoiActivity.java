package com.example.quiz.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

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

        String tenBoCauHoi = getIntent().getStringExtra("BỘ");

        assert tenBoCauHoi != null;
        if (tenBoCauHoi.equals("BỘ-1")){
            tenBo1();
        } else if (tenBoCauHoi.equals("BỘ-2")){

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


        hieuUng(binding.cauhoi,0,list.get(position).getCauhoi());

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

                    Intent intent = new Intent(CauHoiActivity.this, SoDiemActivity.class);
                    intent.putExtra("score", scrore);
                    intent.putExtra("total", list.size());
                    startActivity(intent);
                    finish();
                    return;

                }

                count = 0;
                hieuUng(binding.cauhoi,0,list.get(position).getCauhoi());


            }
        });


    }

    private void hieuUng(View view, int value, String data) {

        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(500).setStartDelay(100)
                .setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(@NonNull Animator animation) {
                        if(value ==0 && count <4){
                            String option = "";

                            if(count ==0){
                                option = list.get(position).getDapan1();
                            }else if (count ==1){
                                option = list.get(position).getDapan2();
                            }else if (count ==2){
                                option = list.get(position).getDapan3();
                            }else if (count ==3){
                                option = list.get(position).getDapan4();
                            }

                            hieuUng(binding.dapanContainer.getChildAt(count), 0, option);
                            count++;

                        }
                    }

                    @Override
                    public void onAnimationEnd(@NonNull Animator animation) {
                        if (value == 0) {
                            if (view instanceof TextView) {
                                ((TextView) view).setText(data);
                            } else if (view instanceof Button) {
                                ((Button) view).setText(data);
                            }

                            view.setTag(data);
                            hieuUng(view, 1, data);
                        }
                    }

                    @Override
                    public void onAnimationCancel(@NonNull Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(@NonNull Animator animation) {

                    }
                });
    }

    private void enableOption(boolean enable) {
        for (int i = 0; i < 4 ; i++){
            binding.dapanContainer.getChildAt(i).setEnabled(enable);

            if(enable){
                binding.dapanContainer.getChildAt(i).setBackgroundResource(R.drawable.btn_opt);
            }
        }



    }

    private void tenBo2() {
        list.add(new cauhoiModel("1. Nhà Nguyễn trải qua bao nhiêu đời vua?",
                "A. 2",
                "B. 3",
                "C. 4",
                "D. 5",
                "C. 4"));

        list.add(new cauhoiModel("2. Nhà nguyễn ra đời trong hoàn cảnh nào?",
                "A. Vua Quang trung nhường ngôi cho Nguyễn Bính",
                "B. Nguyễn Ánh lật đổ triều Tây Sơn",
                "C. Nguyễn Ánh đánh bại quân Thanh",
                "D. Vua Quang trung nhường ngôi cho Nguyễn Ánh",
                "B. Nguyễn Ánh lật đổ triều Tây Sơn"));

        list.add(new cauhoiModel("3. Nội dung học tập và thi cử ở thời hậu lê là gì?",
                "A. Nho giáo",
                "B. Phật giáo",
                "C. Thiên Chúa giáo",
                "D. Kito giáo",
                "A. Nho giáo"));

        list.add(new cauhoiModel("4. Sau khi lên ngôi vua thì Nguyễn Ánh chọn kinh đô ở đâu?",
                "A. Huế",
                "B. Thăng Long",
                "C. Hoa Lư",
                "D. Cổ Loa",
                "A. Huế"));

        list.add(new cauhoiModel("5. Bản đồ đầu tiên của nước ta có tên là gì?",
                "A. Bản đồ Việt Nam",
                "B. Bản đồ Hồng Đức",
                "C. Bản đồ Đại Việt",
                "D. Bản đồ Văn Lang",
                "B. Bản đồ Hồng Đức"));


    }

    private void tenBo1() {
        list.add(new cauhoiModel("1. Vị vua đầu tiên của nước ta là ai?",
                "A. An Dương Vương",
                "B. Vua Hùng Vương",
                "C. Bảo Đại",
                "D. Lê Lợi",
                "B. Vua Hùng Vương"));

        list.add(new cauhoiModel("2. Tình hình nước ta cuối thời Trần?",
                "A. Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ",
                "B. Vua quan chăm lo cho dân, kinh tế phát triển",
                "C. Quân Minh xâm lược và bóc lột nhân dân",
                "D. Cả 3 đáp án trên đều sai",
                "A. Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ"));

        list.add(new cauhoiModel("3. Triệu Đà đã dùng mưu gì để thắng An Dương Vương?",
                "A. Hoãn binh giảng hòa",
                "B. Chia rẽ nội bộ",
                "C. Cả hai đáp án trên đều sai",
                "D. Cả hai đáp án trên đều đúng",
                "D. Cả hai đáp án trên đều đúng"));

        list.add(new cauhoiModel("4. Lê Hoàn lên ngôi vua lấy tên gọi là gì?",
                "A. Lê Đại Hành",
                "B. Lê Long Đĩnh",
                "C. Lê Thánh Tông",
                "D. Lê Thánh Tôn",
                "A. Lê Đại Hành"));

        list.add(new cauhoiModel("5. Ai là người lãnh đạo nghĩa quân Tây sơn?",
                "A. Nguyễn Nhạc",
                "B. Nguyễn Huệ",
                "C. Nguyễn Lữ",
                "D. Nguyễn Trãi",
                "B. Nguyễn Huệ"));

    }


}
package com.example.quiz.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
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

        binding.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish(); // Đóng activity và quay lại activity trước
            }
        });

        ActionBar actionBar = getSupportActionBar(); // Lấy đối tượng ActionBar
        if (actionBar != null) {
            actionBar.hide(); // Chỉ ẩn nếu ActionBar tồn tại
        }

        resetThoigian();
        timer.start();

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

    private void resetThoigian() {
        timer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                binding.thoigian.setText(String.valueOf(l/1000));

            }

            @Override
            public void onFinish() {

                Dialog dialog = new Dialog(CauHoiActivity.this);
                dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.noti_hetgio);
                dialog.findViewById(R.id.thuLai).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(CauHoiActivity.this, BoCauHoiActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

                dialog.show();
            }
        };
    }

    private void checkDapAn(Button chonDapAn ) {

        if(timer != null){
            timer.cancel();
        }


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

                if(timer != null){
                    timer.cancel();
                }
                timer.start();

                binding.btnNext.setEnabled(false);
                binding.btnNext.setAlpha((float) 0.3);
                enableOption(true);
                position ++;

                if(position == list.size()){

                    Intent intent = new Intent(CauHoiActivity.this, SoDiemActivity.class);
                    intent.putExtra("dapAnChinhXac", scrore);
                    intent.putExtra("tongDiem", list.size());
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
//                        if (value == 0) {
//                            if (view instanceof TextView) {
//                                ((TextView) view).setText(data);
//                            } else if (view instanceof Button) {
//                                ((Button) view).setText(data);
//                            }
//
//                            view.setTag(data);
//                            hieuUng(view, 1, data);
//                        }

                        if(value == 0){


                            try {
                                ((TextView)view).setText(data);
                                binding.socauhoi.setText(position+1+"/"+list.size());
                            } catch (Exception e) {

                                ((Button)view).setText(data);
                            }

                            view.setTag(data);
                            hieuUng(view,1,data);

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
                "2",
                "3",
                "4",
                "5",
                "4"));

        list.add(new cauhoiModel("2. Nhà nguyễn ra đời trong hoàn cảnh nào?",
                "Vua Quang trung nhường ngôi cho Nguyễn Bính",
                "Nguyễn Ánh lật đổ triều Tây Sơn",
                "Nguyễn Ánh đánh bại quân Thanh",
                "Vua Quang trung nhường ngôi cho Nguyễn Ánh",
                "Nguyễn Ánh lật đổ triều Tây Sơn"));

        list.add(new cauhoiModel("3. Nội dung học tập và thi cử ở thời hậu lê là gì?",
                "Nho giáo",
                "Phật giáo",
                "Thiên Chúa giáo",
                "Kito giáo",
                "Nho giáo"));

        list.add(new cauhoiModel("4. Sau khi lên ngôi vua thì Nguyễn Ánh chọn kinh đô ở đâu?",
                "Huế",
                "Thăng Long",
                "Hoa Lư",
                "Cổ Loa",
                "Huế"));

        list.add(new cauhoiModel("5. Bản đồ đầu tiên của nước ta có tên là gì?",
                "Bản đồ Việt Nam",
                "Bản đồ Hồng Đức",
                "Bản đồ Đại Việt",
                "Bản đồ Văn Lang",
                "Bản đồ Hồng Đức"));


    }

    private void tenBo1() {
        list.add(new cauhoiModel("1. Vị vua đầu tiên của nước ta là ai?",
                "An Dương Vương",
                "Vua Hùng Vương",
                "Bảo Đại",
                "Lê Lợi",
                "Vua Hùng Vương"));

        list.add(new cauhoiModel("2. Tình hình nước ta cuối thời Trần?",
                "Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ",
                "Vua quan chăm lo cho dân, kinh tế phát triển",
                "Quân Minh xâm lược và bóc lột nhân dân",
                "Cả 3 đáp án trên đều sai",
                "Vua quan ăn chơi sa đọa, nhân dân bị bóc lột tàn tệ"));

        list.add(new cauhoiModel("3. Triệu Đà đã dùng mưu gì để thắng An Dương Vương?",
                "Hoãn binh giảng hòa",
                "Chia rẽ nội bộ",
                "Cả hai đáp án trên đều sai",
                "Cả hai đáp án trên đều đúng",
                "Cả hai đáp án trên đều đúng"));

        list.add(new cauhoiModel("4. Lê Hoàn lên ngôi vua lấy tên gọi là gì?",
                "Lê Đại Hành",
                "Lê Long Đĩnh",
                "Lê Thánh Tông",
                "Lê Thánh Tôn",
                "Lê Đại Hành"));

        list.add(new cauhoiModel("5. Ai là người lãnh đạo nghĩa quân Tây sơn?",
                "Nguyễn Nhạc",
                "Nguyễn Huệ",
                "Nguyễn Lữ",
                "Nguyễn Trãi",
                "Nguyễn Huệ"));

    }


}
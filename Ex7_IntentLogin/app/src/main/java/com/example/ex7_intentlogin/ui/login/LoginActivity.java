package com.example.ex7_intentlogin.ui.login;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.ex7_intentlogin.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}

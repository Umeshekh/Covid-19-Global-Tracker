package com.example.globcovidtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.globcovidtracker.databinding.ActivityMainBinding;
import com.example.globcovidtracker.databinding.ActivitySplashScreenBinding;

public class Splash_Screen extends AppCompatActivity {

    private ActivitySplashScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashScreenBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Splash_Screen.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
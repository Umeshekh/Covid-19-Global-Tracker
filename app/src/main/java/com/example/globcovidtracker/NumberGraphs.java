package com.example.globcovidtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.globcovidtracker.AllFragments.GlobDataFrag;
import com.example.globcovidtracker.AllFragments.TodayDataFrag;
import com.example.globcovidtracker.databinding.ActivityMainBinding;
import com.example.globcovidtracker.databinding.ActivityNumberGraphsBinding;

public class NumberGraphs extends AppCompatActivity {


    private ActivityNumberGraphsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNumberGraphsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        Fragment frag1=new TodayDataFrag();
        Fragment frag2=new GlobDataFrag();
      //  getSupportActionBar().hide();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.vertical_layout, frag1)
                .commit();

        binding.button1.setBackgroundColor(Color.BLUE);
        binding.button1.setTextColor(Color.WHITE);
        binding.button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.button2.setBackgroundColor(Color.WHITE);
                binding.button1.setBackgroundColor(Color.BLUE);
                 binding.button1.setTextColor(Color.WHITE);
                 binding.button2.setTextColor(Color.BLACK);
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.vertical_layout,frag1);
                fragmentTransaction.commit();
            }
        });

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 binding.button1.setBackgroundColor(Color.WHITE);
                 binding.button2.setBackgroundColor(Color.BLUE);
                binding.button1.setTextColor(Color.BLACK);
                binding.button2.setTextColor(Color.WHITE);
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.vertical_layout,frag2);
                fragmentTransaction.commit();

            }
        });
    }
}
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

public class NumberGraphs extends AppCompatActivity {

    Button blue,yellow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_graphs);

        blue=findViewById(R.id.button1);
        yellow=findViewById(R.id.button2);
        Fragment frag1=new TodayDataFrag();
        Fragment frag2=new GlobDataFrag();
      //  getSupportActionBar().hide();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.vertical_layout, frag1)
                .commit();

        blue.setBackgroundColor(Color.BLUE);
        blue.setTextColor(Color.WHITE);
        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yellow.setBackgroundColor(Color.WHITE);
                blue.setBackgroundColor(Color.BLUE);
                 blue.setTextColor(Color.WHITE);
                 yellow.setTextColor(Color.BLACK);
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.vertical_layout,frag1);
                fragmentTransaction.commit();
            }
        });

        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 blue.setBackgroundColor(Color.WHITE);
                 yellow.setBackgroundColor(Color.BLUE);
                blue.setTextColor(Color.BLACK);
                yellow.setTextColor(Color.WHITE);
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.vertical_layout,frag2);
                fragmentTransaction.commit();

            }
        });
    }
}
package com.example.globcovidtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.globcovidtracker.Adapters.PrecautionsAdapter;
import com.example.globcovidtracker.Model.model;
import com.example.globcovidtracker.databinding.ActivityMainBinding;
import com.example.globcovidtracker.databinding.ActivityPrecautionsBinding;

import java.util.ArrayList;
import java.util.List;

public class activity_precautions extends AppCompatActivity {

    private ActivityPrecautionsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrecautionsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        List<model> list1=new ArrayList<>();
        list1=getData();
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        PrecautionsAdapter precautionsAdapter = new PrecautionsAdapter(list1,getApplication());
        recyclerView.setAdapter(precautionsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false  ));
    }

    private List<model> getData() {
        List<model> myList = new ArrayList<>();
        myList.add(new model(  R.drawable.vaccine,
                "Get Vaccinated",
                "Get vaccinated and protect yourself and others from corona"));
       myList.add(new model( R.drawable.handwash,
                "Hand Wash",
                " Wash your hands well and often. Use hand sanitizer when you’re not near soap and water."));
        myList.add(new model(  R.drawable.mask,
                "Wear Mask",
                "Masks are a key measure to suppress transmission and save lives."));
        myList.add(new model(  R.drawable.home,
                "Stay at Home",
                "When you stay home, you help stop the spread to others, too."));
        myList.add(new model(   R.drawable.socialdistance,
                "Social Distance",
                "When going out in public, maintain distance from other people ."));
        return myList;

    }
}
package com.example.globcovidtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.globcovidtracker.Adapters.PrecautionsAdapter;
import com.example.globcovidtracker.Adapters.SymtomsAdapter;
import com.example.globcovidtracker.Model.model;
import com.example.globcovidtracker.databinding.ActivityPrecautionsBinding;
import com.example.globcovidtracker.databinding.ActivitySymtomsBinding;

import java.util.ArrayList;
import java.util.List;

public class activity_symtoms extends AppCompatActivity {

    private ActivitySymtomsBinding binding;
    private List<model> list1;
    private RecyclerView recyclerView;
    private SymtomsAdapter symtomsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySymtomsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        list1 = getData();
        recyclerView=findViewById(R.id.recyclerView);
        symtomsAdapter = new SymtomsAdapter(list1,getApplication());
        recyclerView.setAdapter(symtomsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false  ));
    }

    private List<model> getData() {
        List<model> myList = new ArrayList<>();
        myList.add(new model( R.drawable.cough,
                "Dry Cough",
                "A dry cough is one that does not produce phlegm or mucus."));
        myList.add(new model(
                        R.drawable.fever,
                        "Fever",
                        "A fever is a temporary increase in your body temperature."
        )
        );
        myList.add(new model(
                        R.drawable.headache,
                        "Head Ache",
                        "A painful sensation in any part of the head, ranging from sharp to dull, that may occur with other symptoms."
        )
        );

        myList.add(new model(
                R.drawable.sore_throat,
                "Sore Throat",
                "Pain or irritation in the throat that can occur with or without swallowing, often accompanies infections."
                )
        );

        myList.add(new model(
                R.drawable.fatigue,
                "Tiredness",
                "Feeling overtired, with low energy and a strong desire to sleep that interferes with normal daily activities."
                )
        );

        myList.add(new model(
                R.drawable.loss,
                "Loss of taste or smell",
                "Partial or complete loss of the sense of smell."
                )
        );

        myList.add(new model(
                R.drawable.difficulty_breath,
                "Difficulty breathing or shortness of breath",
                "Shortness of breath, is an uncomfortable condition that makes it difficult to fully get air into your lungs."
                )
        );
        return myList;

    }
}
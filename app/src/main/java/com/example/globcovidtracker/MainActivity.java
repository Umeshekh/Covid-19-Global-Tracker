package com.example.globcovidtracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.globcovidtracker.Adapters.ChartAdapter;
import com.example.globcovidtracker.Adapters.PrecautionsAdapter;
import com.example.globcovidtracker.Adapters.SymtomsAdapter;
import com.example.globcovidtracker.Model.model;
import com.example.globcovidtracker.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SymtomsAdapter symtomsAdapter;
    private WebView webView;
    private PrecautionsAdapter precautionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        webView = new WebView(getApplicationContext());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        binding.viewAll1.setOnClickListener(view14 -> {
            Intent intent = new Intent(MainActivity.this, NumberGraphs.class);
            startActivity(intent);
        });

        fetchData();

        binding.txtViewSymptoms.setOnClickListener(view13 -> {
            Intent i = new Intent(MainActivity.this, activity_symtoms.class);
            startActivity(i);
        });

        binding.txtViewPrecautions.setOnClickListener(view12 -> {
            Intent i = new Intent(MainActivity.this, activity_precautions.class);
            startActivity(i);
        });

        binding.btnKnowMore.setOnClickListener(view1 -> {
            loadURL("https://www.cowin.gov.in/");
        });

        binding.btnWebsite.setOnClickListener(view1 -> {
            loadURL("https://umeshekh.github.io/");
        });

        binding.btnGithub.setOnClickListener(view1 -> {
            loadURL("https://github.com/Umeshekh/");
        });

        binding.btnLinkedIn.setOnClickListener(view1 -> {
            loadURL("https://www.linkedin.com/in/umesh-ekhande-87535a191/");
        });


        List<model> symList = getSymList();
        RecyclerView recyclerView2 = findViewById(R.id.recyclerView2);
        symtomsAdapter = new SymtomsAdapter(symList, getApplication());
        recyclerView2.setAdapter(symtomsAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

        List<model> list2 = getData2();
        RecyclerView recyclerView3 = findViewById(R.id.recyclerViewPrecautions);
        precautionsAdapter = new PrecautionsAdapter(list2, getApplication());
        recyclerView3.setAdapter(precautionsAdapter);
        recyclerView3.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false));

    }


    private List<model> getSymList() {
        List<model> symList = new ArrayList<>();
        symList.add(new model(
                R.drawable.cough,
                "Dry Cough",
                "A dry cough is one that does not produce phlegm or mucus."
        ));
        symList.add(new model(
                R.drawable.fever,
                "Fever",
                "A fever is a temporary increase in your body temperature."
        ));
        symList.add(new model(
                R.drawable.headache,
                "Head Ache",
                "A painful sensation in any part of the head, ranging from sharp to dull, that may occur with other symptoms."
        ));
        return symList;

    }

    private List<model> getData2() {
        List<model> myList = new ArrayList<>();
        myList.add(new model(R.drawable.vaccine,
                "Get Vaccinated",
                "Get vaccinated and protect yourself and others from corona"));
        myList.add(new model(R.drawable.handwash,
                "Hand Wash",
                " Wash your hands well and often. Use hand sanitizer when you’re not near soap and water."));
        myList.add(new model(R.drawable.mask,
                "Wear Mask",
                "Masks are a key measure to suppress transmission and save lives."));
        return myList;

    }

    private void fetchData() {

        String url = "https://corona.lmao.ninja/v2/all/";

        StringRequest request
                = new StringRequest(
                Request.Method.GET,
                url,
                response -> {
                    try {

                        // Creating object of JSONObject
                        JSONObject jsonObject
                                = new JSONObject(
                                response.toString());
                        binding.confirmedCasesId.setText(jsonObject.getString("cases"));
                        binding.RecoveredCasesId.setText(jsonObject.getString("recovered"));
                        binding.ActiveCasesId.setText(jsonObject.getString("active"));
                        binding.DeathCasesId.setText(jsonObject.getString("deaths"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                error -> Toast.makeText(
                        MainActivity.this,
                        error.getMessage(),
                        Toast.LENGTH_SHORT)
                        .show());

        RequestQueue requestQueue
                = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }


    private void loadURL(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}

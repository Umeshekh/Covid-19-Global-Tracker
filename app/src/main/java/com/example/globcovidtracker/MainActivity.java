package com.example.globcovidtracker;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
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
import com.android.volley.VolleyError;
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
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    TextView tvCases, tvRecovered,
            tvCritical, tvActive,
            tvTodayCases, tvTotalDeaths,
            tvTodayDeaths,
            tvAffectedCountries;
    TextView tvConfirmed,tvActive1,tvRecovered1,tvDeath1,tvViewAll1;
    ChartAdapter ad1;
    RecyclerView recyclerView1;
    TextView connum , symName,symDes;
    ImageView sysImg;
    SymtomsAdapter symtomsAdapter;
    Button knowMore;
    private WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvAffectedCountries = findViewById(R.id.tvAffectedCountries);
        tvConfirmed= findViewById(R.id.confirmed_cases_id);
        tvActive1=findViewById(R.id.Active_cases_id);
        tvRecovered1=findViewById(R.id.Recovered_cases_id);
        tvDeath1=findViewById(R.id.Death_cases_id);
        symName=findViewById(R.id.txtSymptoms);
        symDes=findViewById(R.id.SymDetail);
        sysImg=findViewById(R.id.sys_image);
        knowMore=findViewById(R.id.btnKnowMore);

        webView = new WebView(getApplicationContext());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());

        binding.btnKnowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // webView.loadUrl("https://www.ssaurel.com/blog");
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cowin.gov.in/"));
                startActivity(intent);
              //  setContentView(webView);


            }


        });






         featchData();


        List<model> list1=new ArrayList<>();
        list1=getData();
       RecyclerView recyclerView2=findViewById(R.id.recyclerView2);
       symtomsAdapter = new SymtomsAdapter(list1,getApplication());
       recyclerView2.setAdapter(symtomsAdapter);
       recyclerView2.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));

       List<model> list2 = new ArrayList<>();
       list2 = getData();
       RecyclerView recyclerView3=findViewById(R.id.recyclerViewPrecautions);
        PrecautionsAdapter precautionsAdapter = new PrecautionsAdapter(list2,getApplication());
        recyclerView3.setAdapter(precautionsAdapter);
        recyclerView3.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false  ));



         binding.viewAll1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(MainActivity.this,NumberGraphs.class);
                 startActivity(intent);
             }
         });


    }





    private List<model> getData() {
        List<model> myList = new ArrayList<>();
        myList.add(new model( R.drawable.cough,"Dry Cough","I have Dry Cough"));
        myList.add(new model( R.drawable.cough,"Dry Cough1","I have Dry Cough"));
        myList.add(new model( R.drawable.cough,"Dry Cough2","I have Dry Cough"));
        return myList;

    }

    private void featchData() {

        String url = "https://corona.lmao.ninja/v2/all/";

        StringRequest request
                = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        // Handle the JSON object and
                        // handle it inside try and catch
                        try {

                            // Creating object of JSONObject
                            JSONObject jsonObject
                                    = new JSONObject(
                                    response.toString());


                            tvCases.setText(jsonObject.getString("cases"));
                            tvConfirmed.setText(jsonObject.getString("cases"));

                            tvRecovered.setText(jsonObject.getString("recovered"));
                            tvRecovered1.setText(jsonObject.getString("recovered"));


                            tvActive.setText(jsonObject.getString("active"));
                            tvActive1.setText(jsonObject.getString("active"));

                            tvDeath1.setText(jsonObject.getString("deaths"));


                            tvTodayCases.setText(
                                    jsonObject.getString(
                                            "todayCases"));
                            tvTotalDeaths.setText(
                                    jsonObject.getString(
                                            "deaths"));
                            tvTodayDeaths.setText(
                                    jsonObject.getString(
                                            "todayDeaths"));
                            tvAffectedCountries.setText(
                                    jsonObject.getString(
                                            "affectedCountries"));
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        Toast.makeText(
                                MainActivity.this,
                                error.getMessage(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        RequestQueue requestQueue
                = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}
package com.example.globcovidtracker.AllFragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.globcovidtracker.MainActivity;
import com.example.globcovidtracker.R;
import com.example.globcovidtracker.databinding.FragmentTodayDataBinding;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;


public class TodayDataFrag extends Fragment {

    TextView tvR, tvPython, tvCPP;
    PieChart pieChart;
    private FragmentTodayDataBinding binding;


    public TodayDataFrag() {
        // Required empty public constructor
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tvR = getView().findViewById(R.id.tvTodayCases);
        tvPython = getView().findViewById(R.id.tvTodayDeathsCases);
        tvCPP = getView().findViewById(R.id.tvTodayRecoveredCases);

        pieChart = getView().findViewById(R.id.PiechartToday);
        setData();

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentTodayDataBinding binding = FragmentTodayDataBinding.inflate(inflater, container, false);
        return binding.getRoot();


    }

    private void setData() {





        String url = "https://corona.lmao.ninja/v2/all/";

        StringRequest request
                = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response)
                    {

                        try {

                            // Creating object of JSONObject
                            JSONObject jsonObject
                                    = new JSONObject(
                                    response.toString());

                            tvR.setText(jsonObject.getString("todayCases"));
                          // tvPython.setText(jsonObject.getString("todayDeaths"));
                            tvPython.setText("12345");
                          tvCPP.setText(jsonObject.getString("todayRecovered"));


                            pieChart.addPieSlice(
                                    new PieModel(
                                            "R",
                                            Integer.parseInt(tvR.getText().toString()),
                                            Color.parseColor("#FFA726")));
                            pieChart.addPieSlice(
                                    new PieModel(
                                            "Python",
                                            Integer.parseInt(tvPython.getText().toString()),
                                            Color.parseColor("#66BB6A")));
                            pieChart.addPieSlice(
                                    new PieModel(
                                            "C++",
                                            Integer.parseInt(tvCPP.getText().toString()),
                                            Color.parseColor("#EF5350")));




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
                        Toast.makeText(getActivity(),error.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                });

        RequestQueue requestQueue
                = Volley.newRequestQueue(getContext());
        requestQueue.add(request);

        // To animate the pie chart
        pieChart.startAnimation();

    }
}
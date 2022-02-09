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

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;


public class TodayDataFrag extends Fragment {

    TextView tvR, tvPython, tvCPP, tvJava;
    PieChart pieChart;


    public TodayDataFrag() {
        // Required empty public constructor
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        tvR = getView().findViewById(R.id.tvR);
        tvPython = getView().findViewById(R.id.tvPython);
        tvCPP = getView().findViewById(R.id.tvCPP);
        tvJava = getView().findViewById(R.id.tvJava);
        pieChart = getView().findViewById(R.id.piechart);

        setData();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_today_data, container, false);

    }

    private void setData() {

        // Set the percentage of language used
      //  tvR.setText(Integer.toString(40));
//        tvPython.setText(Integer.toString(30));
//        tvCPP.setText(Integer.toString(5));
//        tvJava.setText(Integer.toString(25));

        // Set the data and color to the pie chart




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

                            // Set the data in text view
                            // which are available in JSON format
                            // Note that the parameter inside
                            // the getString() must match
                            // with the name given in JSON format
                            tvR.setText(jsonObject.getString("cases"));
                            tvCPP.setText(jsonObject.getString("cases"));

                            tvJava.setText(jsonObject.getString("recovered"));
                            tvPython.setText(jsonObject.getString("recovered"));

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
                            pieChart.addPieSlice(
                                    new PieModel(
                                            "Java",
                                            Integer.parseInt(tvJava.getText().toString()),
                                            Color.parseColor("#29B6F6")));



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
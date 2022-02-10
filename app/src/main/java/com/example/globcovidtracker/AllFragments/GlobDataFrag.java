package com.example.globcovidtracker.AllFragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.globcovidtracker.R;
import com.example.globcovidtracker.databinding.FragmentGlobDataBinding;
import com.example.globcovidtracker.databinding.FragmentTodayDataBinding;

import org.eazegraph.lib.models.PieModel;
import org.json.JSONException;
import org.json.JSONObject;


public class GlobDataFrag extends Fragment {
    private FragmentGlobDataBinding binding;


    public GlobDataFrag() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentGlobDataBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        setData();

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

                            binding.tvConfirmed.setText(jsonObject.getString("cases"));
                         binding.tvActiveCases.setText(jsonObject.getString("active"));
                         binding.tvDeaths.setText(jsonObject.getString("deaths"));
                         binding.tvRecoveredCases.setText(jsonObject.getString("recovered"));




                            binding.pieChartGlobal.addPieSlice(
                                    new PieModel(
                                            "R",
                                            Integer.parseInt(binding.tvConfirmed.getText().toString()),
                                            Color.parseColor("#FFA726")));
                            binding.pieChartGlobal.addPieSlice(
                                    new PieModel(
                                            "Python",
                                            Integer.parseInt(binding.tvActiveCases.getText().toString()),
                                            Color.parseColor("#66BB6A")));
                            binding.pieChartGlobal.addPieSlice(
                                    new PieModel(
                                            "C++",
                                            Integer.parseInt(binding.tvDeaths.getText().toString()),
                                            Color.parseColor("#EF5350")));

                            binding.pieChartGlobal.addPieSlice(
                                    new PieModel(
                                            "Python",
                                            Integer.parseInt(binding.tvRecoveredCases.getText().toString()),
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
        binding.pieChartGlobal.startAnimation();
    }

}
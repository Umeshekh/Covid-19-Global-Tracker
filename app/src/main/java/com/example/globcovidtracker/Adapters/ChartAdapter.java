package com.example.globcovidtracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.globcovidtracker.Model.model;
import com.example.globcovidtracker.R;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ChartAdapter extends RecyclerView.Adapter<ChartAdapter.ViewHolder> {

    List<model>  list= Collections.emptyList();
    Context context;
    public ChartAdapter(List<model> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.item_numbers,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.numTitle.setText(list.get(position).getNumTitle());
        holder.number.setText(list.get(position).getNum());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView numTitle;
        TextView number;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            numTitle=itemView.findViewById(R.id.numtitle);
            number=itemView.findViewById(R.id.num);

        }
    }
}

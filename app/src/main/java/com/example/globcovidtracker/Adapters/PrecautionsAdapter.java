package com.example.globcovidtracker.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.globcovidtracker.Model.model;
import com.example.globcovidtracker.R;

import java.util.ArrayList;
import java.util.List;

public class PrecautionsAdapter extends RecyclerView.Adapter<PrecautionsAdapter.ViewHolder2> {

    List<model> mylist= new ArrayList<>();
    Context context;
    public PrecautionsAdapter(List<model> mylist, Context context) {
        this.mylist = mylist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.item_symtoms,parent,false);
        PrecautionsAdapter.ViewHolder2 viewHolder2=new PrecautionsAdapter.ViewHolder2(view);
         return viewHolder2;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder2 holder, int position) {
        holder.pre_img.setImageResource(mylist.get(position).getProfile());
        holder.pre_name.setText(mylist.get(position).getSym_name());
        holder.pre_des.setText(mylist.get(position).getSym_des());
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder{

        ImageView pre_img;
        TextView pre_name;
        TextView pre_des;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            pre_img=itemView.findViewById(R.id.sys_image);
            pre_name=itemView.findViewById(R.id.txtSymptoms);
            pre_des=itemView.findViewById(R.id.SymDetail);
        }
    }



}
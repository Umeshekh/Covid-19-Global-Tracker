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

public class SymtomsAdapter extends RecyclerView.Adapter<SymtomsAdapter.ViewHolder> {


    List<model> mylist= new ArrayList<>();
    Context context;

    public SymtomsAdapter(List<model> mylist,Context context) {
        this.mylist = mylist;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.item_symtoms,parent,false);
        SymtomsAdapter.ViewHolder viewHolder=new SymtomsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.sym_img.setImageResource(mylist.get(position).getProfile());
            holder.sym_name.setText(mylist.get(position).getSym_name());
            holder.sym_des.setText(mylist.get(position).getSym_des());
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView sym_img;
        TextView sym_name;
        TextView sym_des;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            sym_img=itemView.findViewById(R.id.sys_image);
            sym_name=itemView.findViewById(R.id.txtSymptoms);
            sym_des=itemView.findViewById(R.id.SymDetail);
        }
    }
}

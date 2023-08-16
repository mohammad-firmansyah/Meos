package com.example.jmp1.adapter;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jmp1.R;

import java.util.ArrayList;

public class LonglistAdapter extends RecyclerView.Adapter<LonglistAdapter.ViewHolder> {

    ArrayList<String> list = new ArrayList<String>();
    Context context;
    public LonglistAdapter(ArrayList<String> mhsList, Application application){
            this.list =mhsList;
            this.context = application;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mhs_item,parent,false);
        LonglistAdapter.ViewHolder viewHolder = new LonglistAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nama.setText(list.get(position));
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView nama;

    public ViewHolder(@NonNull View v) {
        super(v);
        nama= v.findViewById(R.id.nama);
    }
}
}

package com.example.interndemostorage;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interndemostorage.databinding.ShowDetialBinding;

import java.util.ArrayList;

public class RecyclerAdapters extends RecyclerView.Adapter<RecyclerAdapters.recyclerviewHolder> {

    Context context;
    ArrayList<String> list,images;

    public RecyclerAdapters(Context context, ArrayList<String> list,ArrayList<String> images) {
        this.context = context;
        this.list = list;
        this.images = images;
    }

    @NonNull
    @Override
    public recyclerviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.show_detial,parent,false);
        return new recyclerviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerAdapters.recyclerviewHolder holder, int position) {
        holder.binding.textView.setText(list.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,showResultActivity.class);
                intent.putExtra("image",images.get(position));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class recyclerviewHolder extends RecyclerView.ViewHolder{

        ShowDetialBinding binding;
        public recyclerviewHolder(@NonNull View itemView) {
            super(itemView);

            binding = ShowDetialBinding.bind(itemView);
        }
    }
}

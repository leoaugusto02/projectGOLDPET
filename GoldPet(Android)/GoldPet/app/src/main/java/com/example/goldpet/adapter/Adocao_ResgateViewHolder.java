package com.example.goldpet.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.levirs.example.goldpet.R;

public class Adocao_ResgateViewHolder extends RecyclerView.ViewHolder {
    ImageView imgAnimal;
    TextView infoAnimal;
    public Adocao_ResgateViewHolder(View itemView) {
        super(itemView);

        imgAnimal = itemView.findViewById(R.id.imgAnimal);
        infoAnimal = itemView.findViewById(R.id.infoAnimal);
    }
}

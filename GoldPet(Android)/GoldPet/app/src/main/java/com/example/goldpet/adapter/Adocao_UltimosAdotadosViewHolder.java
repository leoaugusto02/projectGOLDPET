package com.example.goldpet.adapter;

import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.levirs.example.goldpet.R;

public class Adocao_UltimosAdotadosViewHolder extends RecyclerView.ViewHolder {
    ImageView adImgAnimal;

    public Adocao_UltimosAdotadosViewHolder(View v){
        super(v);
        adImgAnimal = v.findViewById(R.id.adImgAnimal);
    }

}

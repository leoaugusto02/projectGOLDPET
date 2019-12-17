package com.example.goldpet.adapter;


import android.content.Context;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.goldpet.PerfilAnimal;
import com.example.goldpet.model.vo.Animais;
import com.example.goldpet.model.vo.Resgate;
import com.levirs.example.goldpet.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ResgateAdapter extends RecyclerView.Adapter<Adocao_ResgateViewHolder>{
    private Context context;
    private List<Resgate> lstResgate;

    public ResgateAdapter(Context context, List<Resgate> lstResgate){
        this.context = context;
        this.lstResgate = lstResgate;
    }

    @Override
    public Adocao_ResgateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_adocao_resgate,parent,false);

        Adocao_ResgateViewHolder adocaoResgateViewHolder = new Adocao_ResgateViewHolder(view);

        return adocaoResgateViewHolder;
    }

    @Override
    public void onBindViewHolder(Adocao_ResgateViewHolder holder, int position) {
        final Resgate resgate = lstResgate.get(position);


        holder.infoAnimal.setText("Nível : " + resgate.getNivelUrgencia() + "\r\n" + "Status: " + resgate.getStatus());
        Picasso.with(context).load("http://192.168.1.7:8080/goldpetFrontEnd/imgAnimalResgate/" + resgate.getDogeImagem()).into(holder.imgAnimal);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    @Override
    public int getItemCount() {return lstResgate != null ? lstResgate.size() : 0;}
}

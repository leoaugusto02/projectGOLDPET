package com.example.goldpet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.goldpet.model.vo.Animais;
import com.levirs.example.goldpet.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adocao_UltimosAdotadosAdapter extends RecyclerView.Adapter<Adocao_UltimosAdotadosViewHolder> {
    private Context context;
    private List<Animais> lstAnimais;

    public Adocao_UltimosAdotadosAdapter(Context context, List<Animais> lstAnimais){
        this.context = context;
        this.lstAnimais = lstAnimais;
    }

    @Override
    public Adocao_UltimosAdotadosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_adocao_ultimosadotados,parent,false);

        Adocao_UltimosAdotadosViewHolder adocao_ultimosAdotadosViewHolder = new Adocao_UltimosAdotadosViewHolder(view);

        return adocao_ultimosAdotadosViewHolder;
    }

    @Override
    public void onBindViewHolder(Adocao_UltimosAdotadosViewHolder holder, int position) {
        final Animais animais = lstAnimais.get(position);

        Picasso.with(context).load("http://192.168.1.7:8080/goldpetFrontEnd/imgAnimalAdocao/" + animais.getImgAnimal()).into(holder.adImgAnimal);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {return lstAnimais != null ? lstAnimais.size() : 0;}
}

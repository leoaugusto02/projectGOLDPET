package com.example.goldpet.adapter;


import android.content.Context;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.goldpet.PerfilAnimal;
import com.example.goldpet.model.vo.Animais;
import com.levirs.example.goldpet.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdocaoAdapter extends RecyclerView.Adapter<Adocao_ResgateViewHolder>{
    private Context context;
    private List<Animais> lstAnimais;

    public AdocaoAdapter(Context context, List<Animais> lstAnimais){
        this.context = context;
        this.lstAnimais = lstAnimais;
    }


    @Override
    public Adocao_ResgateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_adocao_resgate,parent,false);

        Adocao_ResgateViewHolder adocaoResgateViewHolder = new Adocao_ResgateViewHolder(view);

        return adocaoResgateViewHolder;
    }

    @Override
    public void onBindViewHolder(Adocao_ResgateViewHolder holder, int position) {
        final Animais animais = lstAnimais.get(position);

        holder.infoAnimal.setText("Nome do pet: " + animais.getNome() + "\r\n" + "Status: " + animais.getStatus() + "\r\n" + "Raça: " + animais.getRaca() + "\r\n"+ "Espécie: " + animais.getEspecie());
        Picasso.with(context).load("http://192.168.0.110:8080/goldpetFrontEnd/imgAnimalAdocao/" + animais.getImgAnimal()).into(holder.imgAnimal);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context, PerfilAnimal.class);
                it.putExtra("codeAnimal", animais.getCodAnimal());
                context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {return lstAnimais != null ? lstAnimais.size() : 0;}
}

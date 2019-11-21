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

import java.util.List;

public class AdocaoAdapter extends RecyclerView.Adapter<AdocaoViewHolder>{
    private Context context;
    private List<Animais> lstAnimais;

    public AdocaoAdapter(Context context, List<Animais> lstAnimais){
        this.context = context;
        this.lstAnimais = lstAnimais;
    }


    @Override
    public AdocaoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_adocao,parent,false);

        AdocaoViewHolder adocaoViewHolder = new AdocaoViewHolder(view);

        return adocaoViewHolder;
    }

    @Override
    public void onBindViewHolder(AdocaoViewHolder holder, int position) {
        final Animais animais = lstAnimais.get(position);

        holder.infoAnimal.setText(animais.getNome() + "" + animais.getStatus() + "" + animais.getRaca() + "" + animais.getEspecie());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.imgAnimal:
                        Intent it = new Intent(context, PerfilAnimal.class);
                        it.putExtra("codeAnimal", animais.getCodAnimal());
                        context.startActivity(it);
                    break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {return lstAnimais != null ? lstAnimais.size() : 0;}
}

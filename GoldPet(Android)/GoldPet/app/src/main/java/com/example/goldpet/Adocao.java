package com.example.goldpet;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goldpet.adapter.AdocaoAdapter;
import com.example.goldpet.model.ConsumirWebService;
import com.example.goldpet.model.vo.Animais;
import com.levirs.example.goldpet.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Adocao extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvAnimais;
    private AdocaoAdapter adocaoAdapter;
    private Handler handler;
    private List<Animais> animaisList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adocao);

        rvAnimais = findViewById(R.id.rvAdocao);

        handler = new Handler();

        listarAnimaisAdocao();

        animaisList = new ArrayList<>();

        adocaoAdapter = new AdocaoAdapter(this, animaisList);

        rvAnimais.setLayoutManager(new LinearLayoutManager(this));

        rvAnimais.setAdapter(adocaoAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgAnimal:
                finish();
            break;
        }
    }

    private void listarAnimaisAdocao() {
        new Thread(){
            public void run(){
                String acao = "listaAdocao";
                final JSONArray jsonAnimais = ConsumirWebService.listarAnimaisAdocao(acao);

                if(jsonAnimais == null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Adocao.this, "Não existe animais para adotar no momento", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            exibirAnimais(jsonAnimais);
                        }
                    });
                }


            }
        }.start();
    }


    private void exibirAnimais (JSONArray jsonAnimais){
        try {
            for (int i = 0; i < jsonAnimais.length(); i++) {
                JSONObject jsonAnimal = jsonAnimais.getJSONObject(i);

                Animais animais = new Animais();

                animais.setCodAnimal(jsonAnimal.getInt("codAnimal"));
                animais.setNome(jsonAnimal.getString("nome"));
                animais.setStatus(jsonAnimal.getString("status"));
                animais.setRaca(jsonAnimal.getString("raca"));
                animais.setEspecie(jsonAnimal.getString("especie"));
                animaisList.add(animais);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        adocaoAdapter.notifyDataSetChanged();
    }

<<<<<<< HEAD
}

=======
}
>>>>>>> ccec72d1b205f232a92219e300d75b2e06b5a20f

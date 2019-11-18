<<<<<<< HEAD
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
                final JSONObject jsonAnimais = ConsumirWebService.listarAnimaisAdocao(acao);

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

    private void exibirAnimais(JSONObject jsonAnimais){
        Animais animais = new Animais();
    }

}
=======
package com.example.goldpet;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

public class Adocao extends AppCompatActivity implements View.OnClickListener {

    ImageView imgAnimal;
    TextView infoAnimal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adocao);

        imgAnimal = findViewById(R.id.imgAnimal);
        infoAnimal = findViewById(R.id.infoAnimal);

        imgAnimal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgAnimal:
                finish();
            break;
        }
    }
}
>>>>>>> 300e5da72eb8685329594e1a1201da49f6224530

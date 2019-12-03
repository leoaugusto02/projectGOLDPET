package com.example.goldpet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.goldpet.adapter.AdocaoAdapter;
import com.example.goldpet.adapter.ResgateAdapter;
import com.example.goldpet.model.ConsumirWebService;
import com.example.goldpet.model.vo.Animais;
import com.example.goldpet.model.vo.Resgate;
import com.levirs.example.goldpet.MainActivity;
import com.levirs.example.goldpet.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Resgatar extends AppCompatActivity implements View.OnClickListener {


    private RecyclerView rvResgate;
    private ResgateAdapter resgateAdapter;
    private Handler handler;
    private List<Resgate> resgateList;
    private TextView txtAddMais;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resgatar);

        rvResgate = findViewById(R.id.rvResgate);
        txtAddMais = findViewById(R.id.txtAdicionarMais);

        txtAddMais.setOnClickListener(this);

        handler = new Handler();

        listarAnimaisResgate();

        resgateList = new ArrayList<>();

        resgateAdapter = new ResgateAdapter(this, resgateList);

        rvResgate.setLayoutManager(new LinearLayoutManager(this));

        rvResgate.setAdapter(resgateAdapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txtAdicionarMais:
                Intent it = new Intent(getApplicationContext(), InserirPetResgate.class);
                startActivity(it);
                break;

            case R.id.btnVoltar:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adocao,menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void listarAnimaisResgate() {
        new Thread(){
            public void run(){
                final JSONArray jsonResgates = ConsumirWebService.listarAnimaisResgate();

                if(jsonResgates == null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Resgatar.this, "Não existe animais para resgate no momento", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            exibirAnimaisResgate(jsonResgates);
                        }
                    });
                }


            }
        }.start();
    }

    private void exibirAnimaisResgate (JSONArray jsonResgates){
        try {
            for (int i = 0; i < jsonResgates.length(); i++) {
                JSONObject jsonResgate = jsonResgates.getJSONObject(i);

                Resgate resgate = new Resgate();

                resgate.setCodResgate(jsonResgate.getInt("codeResgate"));
                resgate.setStatus(jsonResgate.getString("status"));
                resgate.setNivelUrgencia(jsonResgate.getInt("nivelUrgencia"));
                resgate.setStatus(jsonResgate.getString("status"));
                resgateList.add(resgate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        resgateAdapter.notifyDataSetChanged();
    }
}

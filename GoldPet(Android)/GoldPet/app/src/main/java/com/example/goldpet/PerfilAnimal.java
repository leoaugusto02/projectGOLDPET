package com.example.goldpet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goldpet.model.ConsumirWebService;
import com.levirs.example.goldpet.R;

import org.json.JSONObject;

public class PerfilAnimal extends AppCompatActivity implements View.OnClickListener {

    TextView txtNomePet, txtEspecie, txtRaca, txtStatus, txtGenero, txtIdade, txtPorte, txtNomeVet, txtDataDiagnostico, txtBreveDiagnostico, txtDiagnosticoCompleto;
    Button btnAdotar, btnLaudo;
    ImageView ivAnimal;
    Integer codeAnimal;
    private Handler handler;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_animal);

        handler = new Handler();

        txtNomePet = findViewById(R.id.txtNomePet);
        txtEspecie = findViewById(R.id.txtEspecie);
        txtRaca = findViewById(R.id.txtRaca);
        txtStatus = findViewById(R.id.txtStatus);
        txtGenero = findViewById(R.id.txtGenero);
        txtIdade = findViewById(R.id.txtIdade);
        txtPorte = findViewById(R.id.txtPorte);
        txtNomeVet = findViewById(R.id.txtNomeVet);
        txtDataDiagnostico = findViewById(R.id.txtDataDiagnostico);
        txtBreveDiagnostico = findViewById(R.id.txtBreveDiagnostico);
        txtDiagnosticoCompleto = findViewById(R.id.txtDiagnosticoCompleto);

        btnAdotar = findViewById(R.id.btnAdotar);
        btnLaudo = findViewById(R.id.btnLaudo);

        ivAnimal = findViewById(R.id.ivAnimal);

        btnLaudo.setOnClickListener(this);

        btnLaudo.setVisibility(View.GONE);
        perfilAnimal();
    }

    private void perfilAnimal() {
        new Thread(){
            public void run(){
                codeAnimal = getIntent().getIntExtra("codeAnimal" ,0);

                final JSONObject jsonPerfilAnimal = ConsumirWebService.perfilAnimal(codeAnimal);

                if(jsonPerfilAnimal == null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(PerfilAnimal.this, "Perfil inexistente", Toast.LENGTH_LONG).show();
                            finish();
                        }
                    });
                }else{
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            exibirpet(jsonPerfilAnimal);
                        }
                    });
                }
            }
        }.start();
    }

    private void exibirpet(JSONObject jsonObject) {
        try{
            btnLaudo.setVisibility(View.GONE);
            txtNomePet.setText("Nome do pet: " + jsonObject.getString("nome"));
            txtEspecie.setText("Espécie: " + jsonObject.getString("especie"));
            txtIdade.setText("Idade: " + jsonObject.getString("idade"));
            txtGenero.setText("Gênero: " + jsonObject.getString("sexo"));
            txtPorte.setText("Porte: " + jsonObject.getString("porte"));
            txtStatus.setText("Status: " + jsonObject.getString("status"));
            txtRaca.setText("Raça: " + jsonObject.getString("raca"));
            if(jsonObject.getString("mensagem").equals("semLaudo")){
                txtNomeVet.setVisibility(View.GONE);
                txtDataDiagnostico.setVisibility(View.GONE);
                txtBreveDiagnostico.setVisibility(View.GONE);
                txtDiagnosticoCompleto.setVisibility(View.GONE);
            }else{
                txtNomeVet.setText("Nome do Veterinario: " + jsonObject.getString("nomeVet"));
                txtDataDiagnostico.setText("Data do Diagnostico: " + jsonObject.getString("dataDiag"));
                txtBreveDiagnostico.setText("Breve Diagnostico: " + jsonObject.getString("diagnostico"));
                txtDiagnosticoCompleto.setVisibility(View.GONE);
                btnLaudo.setVisibility(View.GONE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLaudo:
                Intent it = new Intent(getApplicationContext(), RealizarLaudo.class);
                it.putExtra("codeAnimal", codeAnimal);
                startActivity(it);
            break;
        }
    }
}
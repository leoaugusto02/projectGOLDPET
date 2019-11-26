package com.example.goldpet;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goldpet.model.ConsumirWebService;
import com.example.goldpet.model.vo.Animais;
import com.levirs.example.goldpet.R;

import org.json.JSONObject;

public class PerfilAnimal extends AppCompatActivity {

    TextView txtNomePet, txtEspecie, txtRaca, txtStatus, txtGenero, txtIdade, txtNomeVet, txtDataDiagnostico, txtBreveDiagnostico, txtDiagnosticoCompleto;
    Button btnAdotar, btnLaudo;
    ImageView ivAnimal;
    private Handler handler;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_animal);

        handler = new Handler();

        perfilAnimal();
    }

    private void perfilAnimal() {
        new Thread(){
            public void run(){
                int codeAnimal = getIntent().getIntExtra("codeAnimal" ,0);

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
            txtNomePet.setText("ufs");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

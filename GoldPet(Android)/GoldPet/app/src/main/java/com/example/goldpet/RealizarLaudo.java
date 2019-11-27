package com.example.goldpet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goldpet.model.ConsumirWebService;
import com.levirs.example.goldpet.R;

import xdroid.toaster.Toaster;

public class RealizarLaudo extends AppCompatActivity implements View.OnClickListener {

    EditText edtNomeVet, edtDataDiagnostico, edtBreveDiagnostico, edtDiagnosticoCompleto;
    Button btnEnviar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.laudo);

        edtNomeVet = findViewById(R.id.edtNomeVet);
        edtDataDiagnostico = findViewById(R.id.edtDataDiagnostico);
        edtBreveDiagnostico = findViewById(R.id.edtBreveDiagnostico);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEnviar:
                realizarLaudo();
            break;
        }
    }

    private void realizarLaudo() {
        new Thread() {
            @Override
            public void run() {
                int codeAnimal = getIntent().getIntExtra("codeAnimal" ,0);

                final String l = ConsumirWebService.inserirLaudo(codeAnimal, edtNomeVet.getText().toString(),
                        edtDataDiagnostico.getText().toString(), edtBreveDiagnostico.getText().toString(), "imagem");

                if(l != null){
                    Toast.makeText(RealizarLaudo.this, "" + l, Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Toast.makeText(RealizarLaudo.this, "Algo deu errado" + l, Toast.LENGTH_SHORT).show();
                }
            }
        }.start();
    }
}

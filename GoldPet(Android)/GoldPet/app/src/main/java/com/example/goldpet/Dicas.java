package com.example.goldpet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.MainActivity;
import com.levirs.example.goldpet.R;

public class Dicas extends AppCompatActivity implements View.OnClickListener {

    Button btnAlimentacao, btnHigiene, btnPasseio, btnVeterinario, btnOlfato,btnDormir, btnCachorroFaz,btnBeijam, btnSuam,btnTruques;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dicas);

        btnAlimentacao = findViewById(R.id.btnAlimentacao);
        btnHigiene = findViewById(R.id.btnHigiene);
        btnPasseio = findViewById(R.id.btnPasseio);
        btnVeterinario = findViewById(R.id.btnVeterinario);
        btnOlfato = findViewById(R.id.btnOlfato);
        btnDormir = findViewById(R.id.btnDormir);
        btnCachorroFaz = findViewById(R.id.btnCachorroFaz);
        btnBeijam = findViewById(R.id.btnBeijam);
        btnSuam = findViewById(R.id.btnSuam);
        btnTruques = findViewById(R.id.btnTruques);

        btnAlimentacao.setOnClickListener(this);
        btnHigiene.setOnClickListener(this);
        btnPasseio.setOnClickListener(this);
        btnVeterinario.setOnClickListener(this);
        btnOlfato.setOnClickListener(this);
        btnDormir.setOnClickListener(this);
        btnCachorroFaz.setOnClickListener(this);
        btnBeijam.setOnClickListener(this);
        btnSuam.setOnClickListener(this);
        btnTruques.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnAlimentacao:
                setContentView(R.layout.alimentacao);
                break;
            case R.id.btnHigiene:
                setContentView(R.layout.higiene);
                break;
            case R.id.btnPasseio:
                setContentView(R.layout.passeio);
                break;
            case R.id.btnVeterinario:
                setContentView(R.layout.levaraoveterinario);
                break;
            case R.id.btnOlfato:
                setContentView(R.layout.olfato);
                break;
            case R.id.btnDormir:
                setContentView(R.layout.dormirpet);
                break;
            case R.id.btnCachorroFaz:
                setContentView(R.layout.cachorrofazem);
                break;
            case R.id.btnBeijam:
                setContentView(R.layout.adorambeijar);
                break;
            case R.id.btnSuam:
                setContentView(R.layout.suam);
                break;
            case R.id.btnTruques:
                setContentView(R.layout.truques);
                break;
        }
    }
}

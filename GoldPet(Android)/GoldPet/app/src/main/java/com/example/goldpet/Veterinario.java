package com.example.goldpet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

public class Veterinario extends AppCompatActivity implements View.OnClickListener {

    Button btVoltar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levaraoveterinario);

        btVoltar = findViewById(R.id.btVoltar);
        btVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btVoltar:
                setContentView(R.layout.dicas);
                break;
        }
    }
}
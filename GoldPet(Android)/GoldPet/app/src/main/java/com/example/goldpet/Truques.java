package com.example.goldpet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

public class Truques extends AppCompatActivity implements View.OnClickListener {

    Button btnVoltar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.truques);

        btnVoltar = findViewById(R.id.btVoltar);
        btnVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnVoltar:
                Intent it = new Intent(getApplicationContext(), Dicas.class);
                startActivity(it);
                break;
        }
    }
}

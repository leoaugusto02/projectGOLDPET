package com.example.goldpet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

public class Higiene extends AppCompatActivity implements View.OnClickListener {

    Button btnVoltar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.higiene);

        btnVoltar = findViewById(R.id.btVoltar);
        btnVoltar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btVoltar:
                setContentView(R.layout.dicas);
                break;
        }
    }
}

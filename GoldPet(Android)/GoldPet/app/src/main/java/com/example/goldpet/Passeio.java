package com.example.goldpet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

public class Passeio extends AppCompatActivity implements View.OnClickListener {

    Button btVoltar7;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passeio);

        btVoltar7 = findViewById(R.id.btVoltar7);
        btVoltar7.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btVoltar7:
            Intent it = new Intent(getApplicationContext(), Dicas.class);
            startActivity(it);
            break;
        }
    }
}

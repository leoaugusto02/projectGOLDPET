package com.example.goldpet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

public class Adoram extends AppCompatActivity implements View.OnClickListener {

    Button btVoltar1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adorambeijar);

        btVoltar1 = findViewById(R.id.btVoltar1);
        btVoltar1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btVoltar1:
                Intent it = new Intent(getApplicationContext(), Dicas.class);
                startActivity(it);
                break;
        }
    }
}

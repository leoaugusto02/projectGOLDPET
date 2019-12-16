package com.example.goldpet;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

public class Truques extends AppCompatActivity implements View.OnClickListener {

    Button btVoltar9;
    TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.truques);

        btVoltar9 = findViewById(R.id.btVoltar9);
        btVoltar9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btVoltar9:
                Intent it = new Intent(getApplicationContext(), Dicas.class);
                startActivity(it);
                break;
        }
    }

}

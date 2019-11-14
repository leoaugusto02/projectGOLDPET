package com.example.goldpet;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

public class Adocao extends AppCompatActivity implements View.OnClickListener {

    ImageView imgAnimal;
    TextView infoAnimal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adocao);

        imgAnimal = findViewById(R.id.imgAnimal);
        infoAnimal = findViewById(R.id.infoAnimal);

        imgAnimal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgAnimal:
                finish();
            break;
        }
    }
}

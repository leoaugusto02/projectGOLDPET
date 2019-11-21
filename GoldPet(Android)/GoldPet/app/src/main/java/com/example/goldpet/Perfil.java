package com.example.goldpet;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goldpet.model.ConsumirWebService;
import com.levirs.example.goldpet.R;

import org.json.JSONObject;

public class Perfil extends AppCompatActivity {

    LinearLayout lLaudo;
    TextView txtNomePet, txtEspecie, txtRaca, txtStatus, txtGenero, txtIdade;
    Button btnAdotar, btnLaudo;
    String MY_PREFS_NAME;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_animal);

        perfilAnimal();
    }

    private void perfilAnimal() {
        new Thread(){
            public void run(){
                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);


                JSONObject json;
            }
        }.start();
    }
}

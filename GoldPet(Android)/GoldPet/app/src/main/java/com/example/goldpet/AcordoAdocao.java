package com.example.goldpet;

import android.os.Bundle;

import com.levirs.example.goldpet.R;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;

public class AcordoAdocao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acordodeadocao);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adotar,menu);
        return super.onCreateOptionsMenu(menu);
    }
}

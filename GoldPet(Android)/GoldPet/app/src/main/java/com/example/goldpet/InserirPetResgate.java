package com.example.goldpet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

public class InserirPetResgate extends AppCompatActivity implements View.OnClickListener {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    EditText edtRaca, edtPorte, edtEspecie, edtStatus;
    RadioButton rdbFemea, rdbMacho;
    Button btnFoto, btnArquivo, btnClose, btnPostar;
    ImageView ivImagem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_pet);

        edtRaca = findViewById(R.id.edtRaca);
        edtPorte = findViewById(R.id.edtPorte);
        edtEspecie = findViewById(R.id.edtEspecie);
        edtStatus = findViewById(R.id.edtStatus);
        rdbFemea = findViewById(R.id.rdbFemea);
        rdbMacho = findViewById(R.id.rdbMacho);
        btnFoto = findViewById(R.id.btnFoto);
        btnArquivo = findViewById(R.id.btnArquivo);
        btnClose = findViewById(R.id.btnClose);
        btnPostar = findViewById(R.id.btnPostar);
        ivImagem = findViewById(R.id.ivImagem);


        rdbFemea.setOnClickListener(this);
        rdbMacho.setOnClickListener(this);
        btnFoto.setOnClickListener(this);
        btnArquivo.setOnClickListener(this);
        btnClose.setOnClickListener(this);
        btnPostar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnFoto:
                TirarFotoIntent();
            break;    
        }
    }

    private void TirarFotoIntent() {
        Intent tirarFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(tirarFoto.resolveActivity(getPackageManager()) != null){
            startActivityForResult(tirarFoto, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && requestCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            ivImagem.setImageBitmap(imageBitmap);
        }
    }
}

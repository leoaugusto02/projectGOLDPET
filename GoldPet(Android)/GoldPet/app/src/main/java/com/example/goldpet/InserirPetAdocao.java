package com.example.goldpet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goldpet.model.ConsumirWebService;
import com.levirs.example.goldpet.R;

public class InserirPetAdocao extends AppCompatActivity implements View.OnClickListener {

    static final int CAMERA = 1;

    Button btnImagem, btnFechar, btnPostar;
    ImageView ivImagem;
    EditText edtNome, edtIdade, edtRaca, edtPorte, edtEspecie, edtEstadoPet;
    RadioButton rbFemenino, rbMasculino;
    Bitmap imageBitmap;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionaradocao);

        btnImagem = findViewById(R.id.btnImagem);
        btnFechar = findViewById(R.id.btnFechar);
        btnPostar = findViewById(R.id.btnPostar);
        ivImagem = findViewById(R.id.ivImagem);
        edtNome = findViewById(R.id.edtNome);
        edtIdade = findViewById(R.id.edtIdade);
        edtRaca = findViewById(R.id.edtRaca);
        edtPorte = findViewById(R.id.edtPorte);
        edtEspecie = findViewById(R.id.edtEspecie);
        edtEstadoPet = findViewById(R.id.edtEstadoPet);
        rbFemenino = findViewById(R.id.rbFemenino);
        rbMasculino = findViewById(R.id.rbMasculino);

        handler = new Handler();

        btnImagem.setOnClickListener(this);
        btnPostar.setOnClickListener(this);
        btnFechar.setOnClickListener(this);
        rbMasculino.setOnClickListener(this);
        rbFemenino.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnImagem:
                tirarFoto();
            break;

            case R.id.btnFechar:
                finish();
            break;

            case R.id.btnPostar:
                postar();
            break;
        }
    }

    private void tirarFoto() {
        Intent tirarFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(tirarFoto, CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA && resultCode == RESULT_OK)  {
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");

            ivImagem.setImageBitmap(imageBitmap);
        }
    }

    private void postar() {
        new Thread(){
            @Override
            public void run() {
                String genero = "";
                if(rbFemenino.isChecked()){
                    genero = "F";
                }else if(rbMasculino.isChecked()){
                    genero = "M";
                }
                if(ConsumirWebService.inserirAdocao(edtNome.getText().toString(), Integer.valueOf(edtIdade.getText().toString()),
                        edtRaca.getText().toString(), edtPorte.getText().toString(), edtEspecie.getText().toString(), genero, edtEstadoPet.getText().toString(), imageBitmap) != null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(InserirPetAdocao.this, "Animal Adotado", Toast.LENGTH_SHORT).show();
                            Intent it = new Intent(InserirPetAdocao.this, InserirPetAdocao.class);
                            startActivity(it);
                            finish();
                        }
                    });
                }else{
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(InserirPetAdocao.this, "algo falhou", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        }.start();
    }


}

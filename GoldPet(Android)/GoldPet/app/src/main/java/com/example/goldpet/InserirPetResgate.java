package com.example.goldpet;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.goldpet.model.ConsumirWebService;
import com.levirs.example.goldpet.R;

import java.io.ByteArrayOutputStream;

public class InserirPetResgate extends AppCompatActivity implements View.OnClickListener {

    static final int CAMERA = 1;
    static final int GALERIA = 2;

    EditText edtRaca, edtPorte, edtEspecie, edtStatus;
    RadioButton rdbFemea, rdbMacho;
    Button btnFoto, btnArquivo, btnClose, btnPostar;
    ImageView ivImagem;
    Handler handler;
    String pathFile = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adicionar_pet);

        if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    0);
        }

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

        handler = new Handler();

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
            case R.id.btnArquivo:
                AcessarGaleria();
             break;

            case R.id.btnEnviar:
                postar();
            break;

            case R.id.btnClose:
                finish();
            break;
        }
    }



    private void TirarFotoIntent() {
        Intent tirarFoto = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(tirarFoto, CAMERA);
    }

    private void AcessarGaleria() {
        Intent acessarGaleria = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(Intent.createChooser(acessarGaleria, "Selecione uma imagem"), GALERIA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

            byte[] byteArray = stream.toByteArray();

            ConsumirWebService.soImagem(byteArray);

            ivImagem.setImageBitmap(imageBitmap);

            imageBitmap.recycle();

            Log.i("Pudim", extras.get("data").toString());
            pathFile = imageBitmap.toString();

        }else if(requestCode == GALERIA && resultCode == RESULT_OK){
            Uri img = data.getData();
            ivImagem.setImageURI(img);
            Log.i("Pudim", data.getData().toString());
        }
    }

    private void postar() {
        new Thread(){
            @Override
            public void run() {
                if(ConsumirWebService.inserirResgate(edtRaca.getText().toString(), edtPorte.getText().toString(), edtEspecie.getText().toString(),
                        edtStatus.getText().toString() , pathFile)){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(InserirPetResgate.this, "Espere o resgate", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(InserirPetResgate.this, "algo falhou", Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }
        }.start();
    }
}
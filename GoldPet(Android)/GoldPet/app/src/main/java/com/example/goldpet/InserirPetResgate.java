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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.goldpet.model.ConsumirWebService;
import com.levirs.example.goldpet.R;

import java.io.ByteArrayOutputStream;

public class InserirPetResgate extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    static final int CAMERA = 1;
    static final int GALERIA = 2;

    EditText edtDescricao, edtEndereco;
    Spinner spnNiverUrgencia;
    Button btnFoto, btnArquivo, btnClose, btnPostar;
    ImageView ivImagem;
    Handler handler;
    byte[] byteArray;
    ArrayAdapter<String> adtNivelUrgencia;
    LinearLayout layout;

    int nivel;

    private static final int[] lstNivelUrgencia = {
            -1,
            1,
            2,
            3,
            4,
            5
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resgate_pet);

        if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    0);
        }

        layout = findViewById(R.id.layout);
        spnNiverUrgencia = findViewById(R.id.spnNiverUrgencia);
        edtDescricao = findViewById(R.id.edtDescricao);
        edtEndereco = findViewById(R.id.edtEndereco);
        btnFoto = findViewById(R.id.btnFoto);
        btnArquivo = findViewById(R.id.btnArquivo);
        btnClose = findViewById(R.id.btnClose);
        btnPostar = findViewById(R.id.btnPostar);
        ivImagem = findViewById(R.id.ivImagem);

        adtNivelUrgencia = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.niveisUrgencia));

        spnNiverUrgencia.setAdapter(adtNivelUrgencia);

        handler = new Handler();

        spnNiverUrgencia.setOnItemSelectedListener(this);
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

            case R.id.btnPostar:
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

            ivImagem.setImageBitmap(imageBitmap);


            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);

            byteArray = stream.toByteArray();

        }else if(requestCode == GALERIA && resultCode == RESULT_OK){
            Uri img = data.getData();
            ivImagem.setImageURI(img);

        }
    }

    private void postar() {
        new Thread(){
            @Override
            public void run() {
                if(ConsumirWebService.inserirResgate(edtDescricao.getText().toString(), edtEndereco.getText().toString(), nivel, byteArray)){
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

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId()){
            case R.id.spnNiverUrgencia:
                if(position != 0){
                    if(position == 1){
                        nivel = lstNivelUrgencia[position];
                    }else if(position == 2){
                        nivel = lstNivelUrgencia[position];
                    }else if(position == 3){
                        nivel = lstNivelUrgencia[position];
                    }else if(position == 4){
                        nivel = lstNivelUrgencia[position];
                    }else if(position == 5){
                        nivel = lstNivelUrgencia[position];
                    }
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

}
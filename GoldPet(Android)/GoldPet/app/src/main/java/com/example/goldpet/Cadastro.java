package com.example.goldpet;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;


import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.webkit.HttpAuthHandler;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

public class Cadastro extends AppCompatActivity implements View.OnClickListener {

    EditText edtApelido, edtNome, edtSobrenome, edtCep, edtCpf, edtRg, edtTel1, edtTel2, edtEmail, edtDataNasc, edtSenha, edtConfSenha, edtReferencia;
    RadioButton rbMasculino, rbFemenino;
    Button btnCadastrar;
    Handler handler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        edtApelido = findViewById(R.id.edtApelido);
        edtNome = findViewById(R.id.edtNome);
        edtSobrenome = findViewById(R.id.edtSobrenome);
        edtCep = findViewById(R.id.edtCep);
        edtCpf = findViewById(R.id.edtCpf);
        edtRg = findViewById(R.id.edtRg);
        edtTel1 = findViewById(R.id.edtTel1);
        edtTel2 = findViewById(R.id.edtTel2);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        edtConfSenha = findViewById(R.id.edtConfSenha);
        edtReferencia = findViewById(R.id.edtReferencia);
        edtDataNasc = findViewById(R.id.edtDataNasc);
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        handler = new Handler();

        btnCadastrar.setOnClickListener(this);
        rbMasculino.setOnClickListener(this);
        rbFemenino.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnCadastrar:
                Cadastro();
            break;
        }
    }

    private String Cadastro() {
        new Thread() {
            public void run() {
                String rbValue = "";
                String acao = "cadastrar";
                String acaoConta = "Guardião";

                if (rbMasculino.isChecked()) {
                    rbValue = "M";
                } else if (rbFemenino.isChecked()) {
                    rbValue = "F";
                }

                final String c = ConsumirWebService.cadastrar(edtNome.getText().toString(), edtSobrenome.getText().toString(), edtApelido.getText().toString(), edtCep.getText().toString(), edtReferencia.getText().toString(), edtCpf.getText().toString(),
                        edtRg.getText().toString(), edtTel1.getText().toString(), edtTel2.getText().toString(), edtDataNasc.getText().toString(), edtEmail.getText().toString(), edtSenha.getText().toString(), edtConfSenha.getText().toString(),
                        rbValue, acao, acaoConta);
                if(c != null){
                    Toast.makeText(Cadastro.this, "" + c, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Cadastro.this, "Algo", Toast.LENGTH_SHORT).show();
                }
            }

        }.start();
        return null;
    }


}
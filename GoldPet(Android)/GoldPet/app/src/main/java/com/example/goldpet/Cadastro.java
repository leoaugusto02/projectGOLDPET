package com.example.goldpet;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goldpet.model.ConsumirWebService;
import com.github.rtoshiro.util.format.SimpleMaskFormatter;
import com.github.rtoshiro.util.format.text.MaskTextWatcher;
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


        //celular
        SimpleMaskFormatter smf =  new SimpleMaskFormatter("(NN)NNNNN-NNNN");
        MaskTextWatcher mtw = new MaskTextWatcher(edtTel1, smf);
        edtTel1.addTextChangedListener(mtw);

        //telefone
        SimpleMaskFormatter smft = new SimpleMaskFormatter("NNNN-NNNN");
        MaskTextWatcher mtwt = new MaskTextWatcher(edtTel2,smft);
        edtTel2.addTextChangedListener(mtwt);

        //Data
        SimpleMaskFormatter smfd = new SimpleMaskFormatter("NN-NN-NNNN");
        MaskTextWatcher mtwd = new MaskTextWatcher(edtDataNasc,smfd);
        edtDataNasc.addTextChangedListener(mtwd);

        //CEP
        SimpleMaskFormatter smfc = new SimpleMaskFormatter("NNNNN-NNN");
        MaskTextWatcher mtwc = new MaskTextWatcher(edtCep,smfc);
        edtCep.addTextChangedListener(mtwc);

        //CPF
        SimpleMaskFormatter smfcpf = new SimpleMaskFormatter("NNN.NNN.NNN-NN");
        MaskTextWatcher mtwcpf = new MaskTextWatcher(edtCpf,smfcpf);
        edtCpf.addTextChangedListener(mtwcpf);

        //RG
        SimpleMaskFormatter smfrg = new SimpleMaskFormatter("NN.NNN.NNN-NN");
        MaskTextWatcher mtwrg = new MaskTextWatcher(edtRg,smfrg);
        edtRg.addTextChangedListener(mtwrg);



        //fim da mascara

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnCadastrar:
                Cadastro();
            break;
        }
    }

    private void Cadastro() {
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

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if(c != null){
                            Toast.makeText(Cadastro.this, "" + c, Toast.LENGTH_SHORT).show();
                            Intent it = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(it);
                        }else{
                            Toast.makeText(Cadastro.this, "Cadastro Falhou", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }

        }.start();
    }
}
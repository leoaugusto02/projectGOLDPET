<<<<<<< HEAD
package com.example.goldpet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

public class Cadastro extends AppCompatActivity implements View.OnClickListener {

    EditText edtApelido, edtNome, edtSobrenome, edtCep, edtCpf, edtRg, edtTel1, edtTel2, edtEmail, edtSenha, edtConfSenha;
    RadioButton rbMasculino, rbFemenino;
    Button btnCadastrar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(this);
        rbMasculino.setOnClickListener(this);
        rbFemenino.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.rbMasculino:

            break;

            case R.id.rbFemenino:

            break;

            case R.id.btnCadastrar:

                String rbValue;

                if(rbMasculino.isChecked()){
                    rbValue = "M";
                }else if(rbFemenino.isChecked()){
                    rbValue = "F";
                }
                final String c = ConsumirWebService.cadastrar(edtNome, edtSobrenome, edtApelido,);

                Toast.makeText(this, c, Toast.LENGTH_SHORT).show();
            break;


        }
    }

=======
package com.example.goldpet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

public class Cadastro extends AppCompatActivity implements View.OnClickListener {

    EditText edtApelido, edtNome, edtSobrenome, edtCep, edtCpf, edtRg, edtTel1, edtTel2, edtEmail, edtSenha, edtConfSenha;
    RadioButton rbMasculino, rbFemenino;
    Button btnCadastrar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        rbMasculino = findViewById(R.id.rbMasculino);
        rbFemenino = findViewById(R.id.rbFemenino);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCadastrar:
            break;
        }
    }
>>>>>>> db103283e687123ca516a2930c47a9e13565384c
}
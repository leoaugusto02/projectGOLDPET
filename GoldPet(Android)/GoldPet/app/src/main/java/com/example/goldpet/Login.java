package com.example.goldpet;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.levirs.example.goldpet.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText edtEmail, edtSenha;
    TextView txtLink;
    Button btnLogin;
    Handler handler;
    public static final String MY_PREFS_NAME = "MyPrefsFile";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        txtLink = findViewById(R.id.txtLink);
        btnLogin = findViewById(R.id.btnLogin);

        handler = new Handler();

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                Login();
            break;
        }
    }

    private void Login(){
        new Thread(){
            public void run(){
                String acao = "login";
                JSONObject json = ConsumirWebService.login(edtEmail.getText().toString(), edtSenha.getText().toString(), acao);
                try {
                    if(json.getString("mensagem").equals("0")){
                        SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                        editor.putInt("name", json.getInt("codeUser"));
                        editor.apply();
                    }else{
                        Toast.makeText(Login.this, "Usuário não existe", Toast.LENGTH_SHORT).show();
                    }
                }catch (JSONException jse){
                    jse.printStackTrace();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

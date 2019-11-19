<<<<<<< HEAD

package com.example.goldpet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goldpet.model.ConsumirWebService;
import com.levirs.example.goldpet.R;

import org.json.JSONException;
import org.json.JSONObject;

import static xdroid.toaster.Toaster.toast;

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
                    SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                    int codigoUsuario = prefs.getInt("codigoUsuario", 0);
                    if(codigoUsuario == 0){
                        if(json.getString("mensagem").equals("0")){
                            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                            editor.putInt("codigoUsuario", json.getInt("codeUser"));
                            editor.apply();
                            toast("Bem Vindo!", this.getClass().getSimpleName(), this.hashCode());
                            Intent it = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(it);
                        }else{
                            toast("Usuário não existe", this.getClass().getSimpleName(), this.hashCode());
                        }
                    }else{
                        toast("Alguém já está logado", this.getClass().getSimpleName(), this.hashCode());
                        Intent it = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(it);
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
=======
package com.example.goldpet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.goldpet.model.ConsumirWebService;
import com.levirs.example.goldpet.R;

import org.json.JSONException;
import org.json.JSONObject;

import static xdroid.toaster.Toaster.toast;

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
                    SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                    int codigoUsuario = prefs.getInt("codigoUsuario", 0);
                    if(codigoUsuario == 0){
                        if(json.getString("mensagem").equals("0")){
                            SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                            editor.putInt("codigoUsuario", json.getInt("codeUser"));
                            editor.apply();
                            toast("Bem Vindo!", this.getClass().getSimpleName(), this.hashCode());
                            Intent it = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(it);
                        }else{
                            toast("Usuário não existe", this.getClass().getSimpleName(), this.hashCode());
                        }
                    }else{
                        toast("Alguém já está logado", this.getClass().getSimpleName(), this.hashCode());
                        Intent it = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(it);
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
>>>>>>> a1b88e85e9961c40e9717f07d33b7e7f07e604cd

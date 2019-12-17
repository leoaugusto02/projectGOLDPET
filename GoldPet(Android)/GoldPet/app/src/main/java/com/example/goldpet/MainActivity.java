package com.example.goldpet;

import android.content.Intent;
import android.os.Bundle;

import android.os.Handler;
import android.util.Log;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.example.goldpet.adapter.AdocaoAdapter;
import com.example.goldpet.adapter.Adocao_UltimosAdotadosAdapter;
import com.example.goldpet.model.ConsumirWebService;
import com.example.goldpet.model.vo.Animais;
import com.google.android.material.navigation.NavigationView;

import com.levirs.example.goldpet.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    DrawerLayout drawer;
    private RecyclerView rvAnimais;
    private Adocao_UltimosAdotadosAdapter adocaoUltimosAdotadosAdapter;
    private List<Animais> animaisList;
    private Handler handler;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    TextView verMais;

    private  int[] mImages = new int[]{
            R.drawable.golden, R.drawable.snow, R.drawable.peludinho
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        rvAnimais = findViewById(R.id.rvAdocaoUltimosResgates);
        drawer = findViewById(R.id.drawer_layout);
        handler = new Handler();
        
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        verMais = findViewById(R.id.verMais);

        verMais.setOnClickListener(this);
        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);

                setNavigationViewListener();
            }
        });
        verMais.setVisibility(View.GONE);

        listarAnimaisAdocao();
        animaisList = new ArrayList<>();
        adocaoUltimosAdotadosAdapter = new Adocao_UltimosAdotadosAdapter(this, animaisList);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        rvAnimais.setLayoutManager(layoutManager);
        rvAnimais.setAdapter(adocaoUltimosAdotadosAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    private void setNavigationViewListener() {
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        // Log.i("teste", id+"");
       // Log.i("teste", id+"");
        if (id == R.id.nav_home) {
            Toast.makeText(this, "This is home", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_login) {
            Intent it = new Intent(this, Login.class);
            startActivity(it);
        } else if (id == R.id.nav_forum) {

        }else if(id == R.id.nav_cadastro){
            Intent it = new Intent(getApplicationContext(), Cadastro.class);
            startActivity(it);
        }else if (id == R.id.nav_adocao) {
            Intent it = new Intent(getApplicationContext(), Adocao.class);
            startActivity(it);
        }else if (id == R.id.nav_resgate) {
            Intent it = new Intent(getApplicationContext(), Resgatar.class);
            startActivity(it);
        }else  if (id == R.id.nav_dicas){
            Intent it = new Intent(getApplicationContext(), Dicas.class);
            startActivity(it);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.verMais:
                Intent it = new Intent(getApplicationContext(), Adocao.class);
                startActivity(it);
                break;
        }
    }


    private void listarAnimaisAdocao() {
        new Thread(){
            public void run(){
                final JSONArray jsonAnimais = ConsumirWebService.listarUltimosAdotados();

                if(jsonAnimais == null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Não existe animais para adotar no momento", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            exibirAnimais(jsonAnimais);
                        }
                    });
                }
            }
        }.start();

    }

    private void exibirAnimais(JSONArray jsonAnimais) {
        try {
            for (int i = 0; i < jsonAnimais.length(); i++) {
                JSONObject jsonAnimal = jsonAnimais.getJSONObject(i);

                Animais animais = new Animais();

                animais.setImgAnimal(jsonAnimal.getString("imgAnimal"));
                animaisList.add(animais);
            }

        } catch (Exception e) {
            Log.e("Error", "ErrorJSONARR exibirAnimais MainAC -- " + e);
            e.printStackTrace();
        }
        adocaoUltimosAdotadosAdapter.notifyDataSetChanged();
    }

}

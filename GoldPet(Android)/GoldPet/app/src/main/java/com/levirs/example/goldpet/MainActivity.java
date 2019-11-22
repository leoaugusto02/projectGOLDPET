<<<<<<< HEAD
<<<<<<< HEAD
package com.levirs.example.goldpet;

import android.os.Bundle;

=======
package com.levirs.example.goldpet;

import android.content.Intent;
import android.os.Bundle;

import com.example.goldpet.Cadastro;

>>>>>>> 198291a942942e99b0f5979908b578ddd5f0969e
import android.util.Log;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageView;

<<<<<<< HEAD
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    private  int[] mImages = new int[]{
            R.drawable.golden,R.drawable.snow, R.drawable.peludinho
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        CarouselView carouselView = findViewById(R.id.carousel);
        carouselView.setPageCount(mImages.length);
        carouselView.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                imageView.setImageResource(mImages[position]);

                setNavigationViewListener();
            }
        });


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
        if (id == R
                .id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        Log.i("teste", id+"");
        if (id == R.id.nav_home) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_login) {

        }else if (id == R.id.nav_forum){

        }else if(id == R.id.nav_cadastro){

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
=======
package com.levirs.example.goldpet;

import android.content.Intent;
import android.os.Bundle;

import com.example.goldpet.Cadastro;

import android.util.Log;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.ImageView;

    public class MainActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {

        DrawerLayout drawer;
        NavigationView navigationView;
        ActionBarDrawerToggle toggle;

        private int[] mImages = new int[]{
                R.drawable.golden, R.drawable.snow, R.drawable.peludinho
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            drawer = findViewById(R.id.drawer_layout);
            navigationView = findViewById(R.id.nav_view);
            toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            navigationView.setNavigationItemSelectedListener(this);

            CarouselView carouselView = findViewById(R.id.carousel);
            carouselView.setPageCount(mImages.length);
            carouselView.setImageListener(new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    imageView.setImageResource(mImages[position]);

                    setNavigationViewListener();
                }
            });


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
            if (id == R
                    .id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }


        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();


            Log.i("teste", id + "");
            if (id == R.id.nav_home) {

            } else if (id == R.id.nav_gallery) {

            } else if (id == R.id.nav_login) {

            } else if (id == R.id.nav_forum) {

            } else if (id == R.id.nav_cadastro) {
                Intent it = new Intent(this, Cadastro.class);
                startActivity(it);
            }

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }
>>>>>>> a1b88e85e9961c40e9717f07d33b7e7f07e604cd
=======
    public class MainActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {

        DrawerLayout drawer;
        NavigationView navigationView;
        ActionBarDrawerToggle toggle;

        private int[] mImages = new int[]{
                R.drawable.golden, R.drawable.snow, R.drawable.peludinho
        };

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            drawer = findViewById(R.id.drawer_layout);
            navigationView = findViewById(R.id.nav_view);
            toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            navigationView.setNavigationItemSelectedListener(this);

            CarouselView carouselView = findViewById(R.id.carousel);
            carouselView.setPageCount(mImages.length);
            carouselView.setImageListener(new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    imageView.setImageResource(mImages[position]);

                    setNavigationViewListener();
                }
            });


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
            if (id == R
                    .id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }


        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();


            Log.i("teste", id + "");
            if (id == R.id.nav_home) {

            } else if (id == R.id.nav_gallery) {

            } else if (id == R.id.nav_login) {

            } else if (id == R.id.nav_forum) {

            } else if (id == R.id.nav_cadastro) {
                Intent it = new Intent(this, Cadastro.class);
                startActivity(it);
            }

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }
>>>>>>> 198291a942942e99b0f5979908b578ddd5f0969e

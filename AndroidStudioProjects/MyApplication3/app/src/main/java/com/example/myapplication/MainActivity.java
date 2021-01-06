package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

public class MainActivity {
    int SPLASH_TIME = 3000; //This is 3 seconds


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();

            }
        }, SPLASH_TIME);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings: {
                Intent intent = new Intent(this, nustatymai.class);
                startActivity(intent);
                break;
            }
            case R.id.about: {
                Intent intent = new Intent(this, apie.class);
                startActivity(intent);
                break;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void rasau(View view) {
        Intent intent = new Intent(this, notepad.class);
        startActivity(intent);
    }

    public void atidarytiLietuviu(View view) {
        Intent intent = new Intent(this, lietuviu.class);
        startActivity(intent);
    }

    public void atidarytiMatematika(View view) {
        Intent intent = new Intent(this, matematika.class);
        startActivity(intent);

    }

    public void atidarytiFizika(View view) {
        Intent intent = new Intent(this, fizika.class);
        startActivity(intent);

    }

    public void atidarytiChemija(View view) {
        Intent intent = new Intent(this, chemija.class);
        startActivity(intent);

    }

    public void atidarytiBiologija(View view) {
        Intent intent = new Intent(this, biologija.class);
        startActivity(intent);

    }

    public void atidarytiIstorija(View view) {
        Intent intent = new Intent(this, istorija.class);
        startActivity(intent);

    }

    public void atidarytiEgzam(View view) {
        Intent intent = new Intent(this, egzai.class);
        startActivity(intent);

    }
}

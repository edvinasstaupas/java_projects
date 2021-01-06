package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void atidarytiLietuviu(View view){
        Intent intent = new Intent (this, lietuviu.class);
        startActivity(intent);
    }
    public void atidarytiMatematika(View view){
        Intent intent = new Intent (this, matematika.class);
        startActivity(intent);
    }
    public void atidarytiFizika(View view){
        Intent intent = new Intent (this, fizika.class);
        startActivity(intent);
    }
    public void atidarytiChemija(View view){
        Intent intent = new Intent (this, chemija.class);
        startActivity(intent);
    }
    public void atidarytiBiologija(View view){
        Intent intent = new Intent (this, biologija.class);
        startActivity(intent);
    }
    public void atidarytiIstorija(View view){
        Intent intent = new Intent (this, istorija.class);
        startActivity(intent);
    }
    public void atidarytiGeografija(View view){
        Intent intent = new Intent (this, geografija.class);
        startActivity(intent);
    }


}

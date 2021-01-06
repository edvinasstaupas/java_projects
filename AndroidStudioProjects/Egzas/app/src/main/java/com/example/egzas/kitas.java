package com.example.egzas;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class kitas extends Activity {
    int esamasklausimas = 0;  //kintamasis skirtas paimti klasimams, atsakymams iš masyvo
    public int kiek = 0;  //teisingu atsakymu kiekio skaičiavimas
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitas);
        }  //įkelia naujus klausimus
    //@SuppressLint("ResourceType")
    }


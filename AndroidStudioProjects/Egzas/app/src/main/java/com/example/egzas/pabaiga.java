package com.example.egzas;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

class Pabaiga extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pabaiga);
        //i kintamaji teisingi paimama reikšmė su raktu Teisingi
        int teisingi = getIntent().getIntExtra("Teisingi", -1);
        TextView atsakymas = (TextView)  findViewById(R.id.kiek);
        atsakymas.setText("Teisingai atsakėte į " + teisingi + " klausimus");

    }/*
    public void baigti (View view)
    {

        Toast toast;
        Context context = getApplicationContext();
        switch (kiek) {
            case 0:
                CharSequence text = "NK nemoki";
                toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
                toast.show();
                break;
            case 1:
                text = "yra buve ir blogeu";
                toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
                toast.show();
                break;
            case 2:
                text = "close enough";
                toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
                toast.show();
                break;
            case 3:
                text = "durnas";
                toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 100);
                toast.show();
                break;
        }

    }*/
}


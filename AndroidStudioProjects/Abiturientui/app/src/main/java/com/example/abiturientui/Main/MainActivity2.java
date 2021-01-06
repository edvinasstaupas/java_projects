package com.example.abiturientui.Main;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.abiturientui.Kita.nustatymai;
import com.example.abiturientui.Mokslai.Fizika.fizika;
import com.example.abiturientui.Mokslai.Lietuviu.lietuviu;
import com.example.abiturientui.Mokslai.biologija;
import com.example.abiturientui.Mokslai.chemija;
import com.example.abiturientui.Mokslai.istorija;
import com.example.abiturientui.Mokslai.matematika;
import com.example.abiturientui.R;
import com.example.abiturientui.TicTacToe;
import com.example.abiturientui.egzai.egzai;


public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(getApplicationContext(), nustatymai.class));
                return true;
            case R.id.search:
                startActivity(new Intent(getApplicationContext(), nustatymai.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    public void atidarytiZaidimus(View view) {
        Intent intent = new Intent(this, TicTacToe.class);
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

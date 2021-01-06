package com.example.abiturientui.Mokslai;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.abiturientui.Kita.nustatymai;
import com.example.abiturientui.R;

public class istorija extends AppCompatActivity {

    TextView txt, txt2;
    String info = "Labas";
    String info2 = "Ką veiki?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.istorija);
        txt = findViewById(R.id.tekstas);
        txt.setText(info);
        txt2 = findViewById(R.id.tekstas2);
        txt2.setText(info2);
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


}

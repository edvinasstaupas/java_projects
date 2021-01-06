package com.example.abiturientui.Mokslai.Lietuviu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abiturientui.R;


public class klaidos extends AppCompatActivity {

    public int visi;
    public boolean[] teisingas = {false};
    public int[] skaicius = {0};
    int m = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.klaidos);
        visi = getIntent().getIntExtra("Kiekis", -1);
        teisingas = getIntent().getBooleanArrayExtra("Ar_Teisingas");
        skaicius = getIntent().getIntArrayExtra("Skaicius");
        atnaujintilaukus();
    }

    public void atnaujintilaukus() {
        if (m < visi) {
            if (teisingas[m]) {
                TextView AutoriausLaukas = findViewById(R.id.autorius);
                TextView ats = findViewById(R.id.ats);
                AutoriausLaukas.setText(Klausimai.autoriai[skaicius[m]]);
                ats.setText(Klausimai.teisingi[skaicius[m]]);
                ats.setTextColor(Color.GREEN);
                m++;
            } else if (!teisingas[m]) {
                TextView AutoriausLaukas = findViewById(R.id.autorius);
                TextView ats1 = findViewById(R.id.ats1);
                TextView ats2 = findViewById(R.id.ats2);
                AutoriausLaukas.setText(Klausimai.autoriai[skaicius[m]]);
                ats1.setText(Klausimai.teisingi[skaicius[m]]);
                ats1.setTextColor(Color.GREEN);
                ats2.setText(Klausimai.neteisingi[skaicius[m]]);
                ats2.setTextColor(Color.RED);
                m++;
            }
        } else {
            Toast.makeText(this, "Atsakymai pasibaigė", Toast.LENGTH_SHORT).show();
        }
    }

    public void pirmyn(View view) {

        atnaujintilaukus();
    }

    public void atgal(View view) {
        if (m > 1) {
            m--;
            m--;
            if (teisingas[m]) {
                TextView AutoriausLaukas = findViewById(R.id.autorius);
                TextView ats = findViewById(R.id.ats);
                AutoriausLaukas.setText(Klausimai.autoriai[skaicius[m]]);
                ats.setText(Klausimai.teisingi[skaicius[m]]);
                ats.setTextColor(Color.GREEN);
                m++;
            } else if (!teisingas[m]) {
                TextView AutoriausLaukas = findViewById(R.id.autorius);
                TextView ats1 = findViewById(R.id.ats1);
                TextView ats2 = findViewById(R.id.ats2);
                AutoriausLaukas.setText(Klausimai.autoriai[skaicius[m]]);
                ats1.setText(Klausimai.teisingi[skaicius[m]]);
                ats1.setTextColor(Color.GREEN);
                ats2.setText(Klausimai.neteisingi[skaicius[m]]);
                ats2.setTextColor(Color.RED);
                m++;
            }
        } else {
            Toast.makeText(this, "Priėjote atsakymų pradžią", Toast.LENGTH_SHORT).show();
        }
    }
}
//2020-01-02 nebereikia



package com.example.abiturientui.Mokslai.Lietuviu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abiturientui.R;

import java.util.Random;


public class zaidimas4 extends AppCompatActivity {
    public int[] skaicius;
    public int visi = 0;
    public int kiek = 0;
    public boolean[] buvo = {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
    public String pasirinktas;
    //public boolean teisingas[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zaidimas);
        atnaujintilaukus();
    }

    public void atnaujintilaukus() {
        Random rand = new Random();
        skaicius[visi] = rand.nextInt(36);
        if (!buvo[skaicius[visi]]) {
            TextView AutoriausLaukas = findViewById(R.id.autorius);
            RadioButton ats1 = findViewById(R.id.ats1);
            RadioButton ats2 = findViewById(R.id.ats2);
            AutoriausLaukas.setText(Klausimai.autoriai[skaicius[visi]]);
            ats1.setText(Klausimai.apibudinimai[skaicius[visi] * 2]);   //ikeliami atsakymai
            ats2.setText(Klausimai.apibudinimai[skaicius[visi] * 2 + 1]);
            buvo[skaicius[visi]] = true;
        } else {
            atnaujintilaukus();
        }
    }

    @SuppressLint("ResourceType")
    public void kitasklausimas(View view) {
        if (visi < 36) {
            Boolean galimaToliau = true;  //loginis kintamasis, nustatantis, ar galima tęsti
            RadioGroup atsakymai = findViewById(R.id.atsgrupe);
            if (atsakymai.getCheckedRadioButtonId() == R.id.ats1) {
                pasirinktas = Klausimai.apibudinimai[skaicius[visi] * 2];
            }
            if (atsakymai.getCheckedRadioButtonId() == R.id.ats2) {
                pasirinktas = Klausimai.apibudinimai[skaicius[visi] * 2 + 1];
            }
            if (pasirinktas == Klausimai.teisingi[skaicius[visi]]) {
                //teisingas[visi] = true;
                kiek++;
                visi++;
            } else {
                //teisingas[visi] = false;
                visi++;
            }

            if (atsakymai.getCheckedRadioButtonId() <= 0) galimaToliau = false;
            atsakymai.clearCheck(); // valomi laukai
            if (galimaToliau) {
                atnaujintilaukus();
            } else {
                Toast.makeText(this, "Jums reikia pasirinkti atsakymą!", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Atsakėte apie visus autorius!", Toast.LENGTH_SHORT).show();
        }
    }

    /*public void baigti(View view) {
        Intent intent = new Intent(this, zaidimo_pabaiga.class);
        intent.putExtra("Teisingi", kiek);
        intent.putExtra("Visi", visi);
        startActivity(intent);

    }*/

}

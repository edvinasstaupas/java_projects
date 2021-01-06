//2020-01-02 nebereikia



package com.example.abiturientui.Mokslai.Lietuviu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.abiturientui.Main.MainActivity;
import com.example.abiturientui.R;

public class zp3 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zaidimo_pabaiga);
        int teisingi = getIntent().getIntExtra("Teisingi", -1);
        int visi = getIntent().getIntExtra("Visi", -1);

        TextView atsakymas = findViewById(R.id.ats);
        String klausimai = "klausimas";
        if (teisingi == 0 || (teisingi >= 10 && teisingi <= 20) || teisingi == 30) {
            klausimai = "klausimų";
        } else if ((teisingi >= 2 && teisingi <= 9) || (teisingi >= 22 && teisingi <= 29) || (teisingi >= 32 && teisingi <= 36)) {
            klausimai = "klausimus";
        } else if (teisingi == 1 || teisingi == 21 || teisingi == 31) {
            klausimai = "klausimą";
        }
        atsakymas.setText("Teisingai atsakėte į " + teisingi + " " + klausimai + " iš " + visi);

    }

    public void grizti(View view){
        Intent intent = new Intent (this, MainActivity.class);
        startActivity(intent);
    }
    public void grizti2(View view){
        Intent intent2 = new Intent (this, lietuviu.class);
        startActivity(intent2);
    }
    public void perziureti(View view){
        Intent intent3 = new Intent (this, klaidos.class);
        //intent3.putExtra("Ar_Teisingas", teisingas);
        //intent3.putExtra("Kiekis", visi);
        //intent3.putExtra("Autoriaus_numeris", autoriaus_numeris);
        startActivity(intent3);
    }
}

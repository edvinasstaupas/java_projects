package com.lionroar.mokslobaze.ui.kita;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lionroar.mokslobaze.R;

public class skaiciuokle extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String rez;
    double m,
            k1 = 0.53333,
            k2 = 0.95238,
            k3 = 1.85185,
            k4 = 0.93333,
            k5 = 0;
    double c1 = 0,
            c2 = -12.74724,
            c3 = -58.321503,
            c4 = 13.32287,
            c5 = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skaiciuokle);
        /*Spinner spinner = findViewById(R.id.dalykas);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Pasirinkite, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemClickListener((AdapterView.OnItemClickListener) this);*/
        final EditText ivedimas = findViewById(R.id.ivedimas);
        final TextView rezultatas = findViewById(R.id.rezultatas);
        Button mygtukas = findViewById(R.id.mygtukas);

        mygtukas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rezultatas.setText("");
                if (!ivedimas.getText().toString().equals("")) {
                    String skaicius = ivedimas.getText().toString();
                    int sk = Integer.parseInt(skaicius);
                    if (sk >= 0 && sk < 30) {
                        m = k1 * sk + c1;
                        rez = Integer.toString((int) Math.round(m));
                        rezultatas.setText(rez);
                    } else if (sk >= 30 && sk < 51) {
                        m = k2 * sk + c2;
                        rez = Integer.toString((int) Math.round(m));
                        rezultatas.setText(rez);
                    } else if (sk >= 51 && sk < 78) {
                        m = k3 * sk + c3;
                        rez = Integer.toString((int) Math.round(m));
                        rezultatas.setText(rez);
                    } else if (sk >= 78 && sk < 93) {
                        m = k4 * sk + c4;
                        rez = Integer.toString((int) Math.round(m));
                        rezultatas.setText(rez);
                    } else if (sk >= 93 && sk <= 100) {
                        m = k5 * sk + c5;
                        rez = Integer.toString((int) Math.round(m));
                        rezultatas.setText(rez);
                    } else {
                        Toast.makeText(getApplicationContext(), "Įvestas neteisingas skaičius", Toast.LENGTH_LONG).show();
                    }
                    closeKeyboard();
                } else {
                    Toast.makeText(getApplicationContext(), "Neįvestas skaičius", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void closeKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this, "A", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
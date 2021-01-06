package com.lionroar.mokslobaze.Mokslai;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lionroar.mokslobaze.R;

public class fizika extends AppCompatActivity {

    public String[] dydis_array = new String[50];
    public String[] vienetas_array = new String[50];
    public String[] apibrezimas_array = new String[50];
    public String[] zymejimas_array = new String[50];
    public String[] si_array = new String[50];
    public String[] santrumpa2_array = new String[50];
    public String[] zymejimas2_array = new String[50];
    public String[] pavadinimas2_array = new String[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fizika);

        Resources res = getResources();
        dydis_array = res.getStringArray(R.array.dydis);
        vienetas_array = res.getStringArray(R.array.pavadinimas);
        apibrezimas_array = res.getStringArray(R.array.apibrezimas);
        zymejimas_array = res.getStringArray(R.array.zymejimas);
        si_array = res.getStringArray(R.array.si);
        santrumpa2_array = res.getStringArray(R.array.santrumpa2);
        zymejimas2_array = res.getStringArray(R.array.zymejimas2);
        pavadinimas2_array = res.getStringArray(R.array.pavadinimas2);


        /*for (int i = 0; i < 7; i++) {
            String dydisID = "a" + i;
            String siID = "b" + i;
            String vienetasID = "c" + i;
            String apibrezimasID = "d" + i;

            TextView dydis = findViewById(res.getIdentifier(dydisID, "id", getPackageName()));
            ImageView si = findViewById(res.getIdentifier(siID, "id", getPackageName()));
            TextView vienetas = findViewById(res.getIdentifier(vienetasID, "id", getPackageName()));
            TextView apibrezimas = findViewById(res.getIdentifier(apibrezimasID, "id", getPackageName()));

            dydis.setText(dydis_array[i]);
            si.setImageResource(R.mipmap.flask);
            vienetas.setText(vienetas_array[i]);
            apibrezimas.setText(apibrezimas_array[i]);
        }*/

        TableLayout tableLayout = findViewById(R.id.tablelayout);


        for (int i = 0; i < 31; i++) {

            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);
            row.setBackgroundResource(R.drawable.border);
            TextView zymejimas = new TextView(this, null, 0, R.style.lenteleText);
            TextView si = new TextView(this, null, 0, R.style.lenteleText);
            TextView dydis = new TextView(this, null, 0, R.style.lenteleText);
            TextView vienetas = new TextView(this, null, 0, R.style.lenteleText);
            TextView apibrezimas = new TextView(this, null, 0, R.style.lenteleTextapib);

            zymejimas.setText(zymejimas_array[i]);
            si.setText(si_array[i]);
            dydis.setText(dydis_array[i]);
            vienetas.setText(vienetas_array[i]);
            apibrezimas.setText(apibrezimas_array[i]);

            apibrezimas.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
            apibrezimas.setSingleLine(false);

            if (i == 0) {
                zymejimas.setTypeface(Typeface.DEFAULT_BOLD);
                dydis.setTypeface(Typeface.DEFAULT_BOLD);
                si.setTypeface(Typeface.DEFAULT_BOLD);
                vienetas.setTypeface(Typeface.DEFAULT_BOLD);
                apibrezimas.setTypeface(Typeface.DEFAULT_BOLD);
            }

            row.addView(zymejimas);
            row.addView(dydis);
            row.addView(si);
            row.addView(vienetas);
            row.addView(apibrezimas);
            tableLayout.addView(row, i);

        }

        TableLayout tableLayout2 = findViewById(R.id.tablelayout2);


        for (int i = 0; i < 17; i++) {

            TableRow row2 = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row2.setLayoutParams(lp);
            row2.setBackgroundResource(R.drawable.border);
            TextView zymejimas2 = new TextView(this, null, 0, R.style.lenteleText2);
            TextView pavadinimas2 = new TextView(this, null, 0, R.style.lenteleText2);
            TextView santrumpa2 = new TextView(this, null, 0, R.style.lenteleText2);

            zymejimas2.setText(zymejimas2_array[i]);
            pavadinimas2.setText(pavadinimas2_array[i]);
            santrumpa2.setText(santrumpa2_array[i]);

            if (i == 0) {
                zymejimas2.setTypeface(Typeface.DEFAULT_BOLD);
                pavadinimas2.setTypeface(Typeface.DEFAULT_BOLD);
                santrumpa2.setTypeface(Typeface.DEFAULT_BOLD);
            }

            row2.addView(zymejimas2);
            row2.addView(pavadinimas2);
            row2.addView(santrumpa2);
            tableLayout2.addView(row2, i);
        }
    }
}

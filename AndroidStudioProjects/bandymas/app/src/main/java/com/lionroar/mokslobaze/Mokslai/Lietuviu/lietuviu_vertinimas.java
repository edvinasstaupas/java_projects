package com.lionroar.mokslobaze.Mokslai.Lietuviu;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.lionroar.mokslobaze.R;
import com.pdfview.PDFView;

public class lietuviu_vertinimas extends AppCompatActivity {

    PDFView pdfview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lietuviu_vertinimas);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            pdfview = findViewById(R.id.pdfView);
            pdfview.fromAsset("LietuviuVertinimas.pdf").show();
        } else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            pdfview = findViewById(R.id.pdfView);
            pdfview.fromAsset("LietuviuVertinimas.pdf").show();
            Toast.makeText(this, "Didesniam vaizdui pasukite įrenginį", Toast.LENGTH_SHORT).show();
        }

        //pdfview = findViewById(R.id.pdfView);
        //pdfview.fromAsset("LietuviuVertinimas.pdf").show();

        //Toast.makeText(this, "Didesniam vaizdui pasukite įrenginį", Toast.LENGTH_LONG).show();
    }

}

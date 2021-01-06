package com.lionroar.mokslobaze;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.pdfview.PDFView;


public class Karantinas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.karantinas);

        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("KaVeiktiPaaugliams.pdf")
                //.spacing(20)
                .show();
    }
}

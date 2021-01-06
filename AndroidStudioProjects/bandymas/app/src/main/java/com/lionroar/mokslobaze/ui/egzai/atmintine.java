package com.lionroar.mokslobaze.ui.egzai;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.lionroar.mokslobaze.R;
import com.pdfview.PDFView;

public class atmintine extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.atmintine);

        PDFView pdfView = findViewById(R.id.pdfView);
        pdfView.fromAsset("atmintine.pdf")
                .show();

    }
}

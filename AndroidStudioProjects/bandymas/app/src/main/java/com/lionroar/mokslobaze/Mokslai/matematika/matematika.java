package com.lionroar.mokslobaze.Mokslai.matematika;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.lionroar.mokslobaze.R;


public class matematika extends AppCompatActivity {

    ImageView image1, image2, image3, image4, image5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matematika);
        image1 = findViewById(R.id.apib2);
        image2 = findViewById(R.id.reiksm2);
        image3 = findViewById(R.id.isvestines2);
        image4 = findViewById(R.id.pirmykstes2);
        image5 = findViewById(R.id.logaritmai2);
        image1.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.apib, null));
        image2.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.reiksm, null));
        image3.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.isvestines, null));
        image4.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.pirmykstes, null));
        image5.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.logaritmai, null));

    }
}

package com.lionroar.mokslobaze;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lionroar.mokslobaze.Mokslai.Lietuviu.lietuviu;
import com.lionroar.mokslobaze.Mokslai.biologija;
import com.lionroar.mokslobaze.Mokslai.chemija;
import com.lionroar.mokslobaze.Mokslai.fizika;
import com.lionroar.mokslobaze.Mokslai.istorija;
import com.lionroar.mokslobaze.Mokslai.matematika.matematika;
import com.lionroar.mokslobaze.ui.egzai.atmintine;
import com.lionroar.mokslobaze.ui.kita.nustatymai;
import com.lionroar.mokslobaze.ui.kita.skaiciuokle;
import com.lionroar.mokslobaze.zaidimai.TicTacToe;

public class MainActivity extends AppCompatActivity {
    SharedPref sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref = new SharedPref(this);
        if (sharedpref.loadNightModeState()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_egzai, R.id.navigation_kita)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(this, nustatymai.class));
                return true;
            /*case R.id.search:
                startActivity(new Intent(getApplicationContext(), nustatymai.class));
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void atidarytiZaidima(View view) {
        Intent intent = new Intent(this, TicTacToe.class);
        startActivity(intent);
    }

    public void atidarytiLietuviu(View view) {
        Intent intent = new Intent(this, lietuviu.class);
        startActivity(intent);
    }

    public void atidarytiMatematika(View view) {
        Intent intent = new Intent(this, matematika.class);
        startActivity(intent);

    }

    public void atidarytiFizika(View view) {
        Intent intent = new Intent(this, fizika.class);
        startActivity(intent);

    }

    public void atidarytiAtmintine(View view) {
        Intent intent = new Intent(this, atmintine.class);
        startActivity(intent);

    }

    public void atidarytiChemija(View view) {
        Intent intent = new Intent(this, chemija.class);
        startActivity(intent);

    }

    public void atidarytiBiologija(View view) {
        Intent intent = new Intent(this, biologija.class);
        startActivity(intent);

    }

    public void atidarytiIstorija(View view) {
        Intent intent = new Intent(this, istorija.class);
        startActivity(intent);

    }

    public void atidarytiKarantina(View view) {
        Intent intent = new Intent(this, Karantinas.class);
        startActivity(intent);

    }

    public void atidarytiNEC(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nec.lt"));
        startActivity(intent);
    }

    public void atidarytiMokslinciu(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://scholar.google.lt"));
        startActivity(intent);
    }

    public void atidarytiDUK(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/lietuvosmoksleiviusajunga/posts/10158301244356214"));
        startActivity(intent);
    }

    public void atidarytiAtmintine2(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://vilniausppt.lt/2020/04/15/kaip-pasiruosti-egzaminams-atmintine-moksleiviams-ir-ju-tevams/"));
        startActivity(intent);
    }

    public void atidarytiSkaiciuokle(View view) {
        Intent intent = new Intent(this, skaiciuokle.class);
        startActivity(intent);
    }

}

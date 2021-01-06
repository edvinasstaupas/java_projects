package com.lionroar.taxi;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final long default_price = 1;
    private static final long default_cons = 1;
    Button button_calc;
    EditText km;
    EditText price;
    EditText consumption;
    SwitchCompat mSwitch1;
    SwitchCompat mSwitch2;
    TextView sConsumption;
    TextView sPrice;
    TextView cost;
    double multiplier;
    double full_price;
    boolean checked = false;
    double mPrice;
    double mKm;
    double mConsumption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        km = findViewById(R.id.edit_text_km);

        mSwitch1 = findViewById(R.id.edit_text_taf);
        mSwitch2 = findViewById(R.id.edit_text_max);

        final LinearLayout linear_change = findViewById(R.id.linear4);
        final LinearLayout linear_show = findViewById(R.id.linear3);

        sConsumption = findViewById(R.id.text_view_cons);
        sPrice = findViewById(R.id.text_view_price);


        consumption = findViewById(R.id.edit_text_cons_change);
        price = findViewById(R.id.edit_text_price_change);

        cost = findViewById(R.id.text_view_cost);

        Button button_change = findViewById(R.id.button_change);
        button_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checked) {
                    linear_change.setVisibility(View.VISIBLE);
                    linear_show.setVisibility(View.INVISIBLE);
                    consumption.setHint(String.format(Double.toString(mConsumption)));
                    price.setHint(String.format(Double.toString(mPrice)));
                    checked = true;
                } else {
                    mConsumption = Double.parseDouble(consumption.getText().toString());
                    mPrice = Double.parseDouble(price.getText().toString());
                    sConsumption.setText(String.format(Double.toString(mConsumption)));
                    sPrice.setText(String.format(Double.toString(mPrice)));
                    linear_change.setVisibility(View.INVISIBLE);
                    linear_show.setVisibility(View.VISIBLE);
                    checked = false;
                    savePrefs();
                }
            }
        });
        Button button = findViewById(R.id.button_maps);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/maps"));
                startActivity(intent);
            }
        });
        button_calc = findViewById(R.id.button_calc);
        button_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplier = 1;
                boolean taf = mSwitch1.isChecked();
                boolean max = mSwitch2.isChecked();
                if (taf) {
                    multiplier = multiplier * 2;
                }
                if (max) {
                    multiplier = multiplier * 2.5;
                }
                if (km.getText().toString().equals("") || mPrice == 0 || mConsumption == 0) {
                    Toast.makeText(MainActivity.this, "Fill blank spaces", Toast.LENGTH_SHORT).show();
                } else {
                    mKm = Double.parseDouble(km.getText().toString());
                    full_price = multiplier * mPrice * mKm * mConsumption / 100;
                    cost.setText(String.valueOf(new BigDecimal(full_price).setScale(2, RoundingMode.HALF_UP).doubleValue()));
                }
                hideSoftKeyboard(Objects.requireNonNull(getCurrentFocus()));
            }
        });

    }

    public void hideSoftKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        assert imm != null;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void savePrefs() {
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("price", Double.doubleToRawLongBits(mPrice));
        editor.putLong("cons", Double.doubleToRawLongBits(mConsumption));

        editor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
        savePrefs();
    }

    public void loadPrefs() {
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        mPrice = Double.longBitsToDouble(prefs.getLong("price", default_price));
        mConsumption = Double.longBitsToDouble(prefs.getLong("cons", default_cons));

        sConsumption.setText(String.format(Double.toString(mConsumption)));
        sPrice.setText(String.format(Double.toString(mPrice)));
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadPrefs();
    }
}

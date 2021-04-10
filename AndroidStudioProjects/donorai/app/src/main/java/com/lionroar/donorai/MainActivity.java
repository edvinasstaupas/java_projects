package com.lionroar.donorai;

import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.awt.Button;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private boolean NumPickerOn;
    private long data;
    private static final int intervalas = 60;
    private int interval;
    private Calendar c = Calendar.getInstance();
    private Date future;
    private Button button2;
    private NumberPicker NumPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NumPickerOn = false;
        Button button = findViewById(R.id.button_set);
        button2 = findViewById(R.id.button_interval);
        NumPicker = findViewById(R.id.number_picker);
        NumPicker.setMinValue(60);
        NumPicker.setMaxValue(365);
        String a = String.valueOf(interval);
        Toast.makeText(MainActivity.this, a, Toast.LENGTH_SHORT).show();
        NumPicker.setValue(75);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInterval();
            }
        });
    }

    public void updateInterval() {
        if (!NumPickerOn) {
            c.add(Calendar.DATE, -interval);
            NumPickerOn = true;
            button2.setText("Patvirtinti");
            NumPicker.setVisibility(View.VISIBLE);
            NumPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                    interval = newVal;
                }
            });
        } else {
            NumPickerOn = false;
            NumPicker.setVisibility(View.INVISIBLE);
            button2.setText("Pakeiskite donacijų intervalą");
            c.add(Calendar.DATE, interval);

            future = c.getTime();

            Date today = Calendar.getInstance().getTime();

            long diff = future.getTime() - today.getTime();
            long difd = diff / 86400000;

            String difference = String.valueOf(difd);

            //String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(future);
            TextView textView = findViewById(R.id.text_view_date);
            if (difd < 100) {
                if (difd % 10 == 1) {
                    textView.setText("Liko " + difference + " diena iki kitos donacijos");
                } else if (difd % 10 >= 2 && difd % 10 <= 9) {
                    textView.setText("Liko " + difference + " dienos iki kitos donacijos");
                } else if (difd % 10 == 0) {
                    textView.setText("Liko " + difference + " dienų iki kitos donacijos");
                }
            } else if (difd < 1000){
                if (difd % 100 == 1) {
                    textView.setText("Liko " + difference + " diena iki kitos donacijos");
                } else if (difd % 100 >= 2 && difd % 10 <= 9) {
                    textView.setText("Liko " + difference + " dienos iki kitos donacijos");
                } else if (difd % 100 == 0) {
                    textView.setText("Liko " + difference + " dienų iki kitos donacijos");
                }
            }        }
    }

/*



    public void setDiffDate(View v) {
        Date date = c.getTime();

        //c.add(Calendar.DATE, mDiffDate);
        //c.add(Calendar.MONTH, 1);
        //c.add(Calendar.YEAR, 1);
        Date future = c.getTime();

        //textViewDate.setText("Today: " + today + "\n" + "Kitas apsilankymas: " + future);
    }

    public void setDate(View v) {
        Date today = c.getTime();

        c.add(Calendar.DATE, 60);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.YEAR, 1);
        Date future = c.getTime();

        textViewDate.setText("Today: " + today + "\n" + "Future: " + future);
    }
*/

    //public void setInterval() {


    //editInterval.setVisibility(View.VISIBLE);
    //String Inter = String.valueOf(TextViewInterval);
    //  }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        c.add(Calendar.DATE, interval);

        future = c.getTime();

        Date today = Calendar.getInstance().getTime();

        long diff = future.getTime() - today.getTime();
        long difd = diff / 86400000;

        String difference = String.valueOf(difd);

        //String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(future);
        TextView textView = findViewById(R.id.text_view_date);
        if (difd < 100) {
            if (difd % 10 == 1) {
                textView.setText("Liko " + difference + " diena iki kitos donacijos");
            } else if (difd % 10 >= 2 && difd % 10 <= 9) {
                textView.setText("Liko " + difference + " dienos iki kitos donacijos");
            } else if (difd % 10 == 0) {
                textView.setText("Liko " + difference + " dienų iki kitos donacijos");
            }
        } else if (difd < 1000){
            if (difd % 100 == 1) {
                textView.setText("Liko " + difference + " diena iki kitos donacijos");
            } else if (difd % 100 >= 2 && difd % 10 <= 9) {
                textView.setText("Liko " + difference + " dienos iki kitos donacijos");
            } else if (difd % 100 == 0) {
                textView.setText("Liko " + difference + " dienų iki kitos donacijos");
            }
        }    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        data = future.getTime();
        editor.putLong("data", data);
        editor.putInt("interval", interval);

        editor.apply();

        /*if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }*/
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);

        data = prefs.getLong("data", data);
        interval = prefs.getInt("interval", intervalas);
        future = new Date(data);

        Date today = Calendar.getInstance().getTime();

        long diff = future.getTime() - today.getTime();
        long difd = diff / 86400000;

        String difference = String.valueOf(difd);

        //String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(future);
        TextView textView = findViewById(R.id.text_view_date);
        if (difd < 100) {
            if (difd % 10 == 1) {
                textView.setText("Liko " + difference + " diena iki kitos donacijos");
            } else if (difd % 10 >= 2 && difd % 10 <= 9) {
                textView.setText("Liko " + difference + " dienos iki kitos donacijos");
            } else if (difd % 10 == 0) {
                textView.setText("Liko " + difference + " dienų iki kitos donacijos");
            }
        } else if (difd < 1000){
            if (difd % 100 == 1) {
                textView.setText("Liko " + difference + " diena iki kitos donacijos");
            } else if (difd % 100 >= 2 && difd % 10 <= 9) {
                textView.setText("Liko " + difference + " dienos iki kitos donacijos");
            } else if (difd % 100 == 0) {
                textView.setText("Liko " + difference + " dienų iki kitos donacijos");
            }
        }

       /* if (mTimerRunning) {
            mEndTime = prefs.getLong("endTime", 0);
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();
            if (mTimeLeftInMillis < 0) {
                mTimeLeftInMillis = 0;
                mTimerRunning = false;
                updateCountDownText();
            } else {
                startTimer();
            }
        }*/
    }
}
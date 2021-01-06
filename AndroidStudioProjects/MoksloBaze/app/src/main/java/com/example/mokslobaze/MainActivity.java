package com.example.mokslobaze;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    final RadioRealButton button1 = (RadioRealButton) findViewById(R.id.button1);
    final RadioRealButton button2 = (RadioRealButton) findViewById(R.id.button2);

    RadioRealButtonGroup group = (RadioRealButtonGroup) findViewById(R.id.group);

// onClickButton listener detects any click performed on buttons by touch
group.setOnClickedButtonListener(new RadioRealButtonGroup.OnClickedButtonListener() {
        @Override
        public void onClickedButton(RadioRealButton button, int position) {
            Toast.makeText(MainActivity.this, "Clicked! Position: " + position, Toast.LENGTH_SHORT).show();
        }
    });

// onPositionChanged listener detects if there is any change in position
group.setOnPositionChangedListener(new RadioRealButtonGroup.OnPositionChangedListener() {
        @Override
        public void onPositionChanged(RadioRealButton button, int position) {
            Toast.makeText(MainActivity.this, "Position Changed! Position: " + position, Toast.LENGTH_SHORT).show();
        }
    });

// onLongClickedButton detects long clicks which are made on any button in group.
// return true if you only want to detect long click, nothing else
// return false if you want to detect long click and change position when you release
group.setOnLongClickedButtonListener(new RadioRealButtonGroup.OnLongClickedButtonListener() {
        @Override
        public boolean onLongClickedButton(RadioRealButton button, int position) {
            Toast.makeText(MainActivity.this, "Long Clicked! Position: " + position, Toast.LENGTH_SHORT).show();
            return false;
        }
    });
}

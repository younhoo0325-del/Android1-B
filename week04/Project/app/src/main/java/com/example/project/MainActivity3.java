package com.example.project;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    SeekBar seekRed, seekGreen, seekBlue;
    TextView txtRed, txtGreen, txtBlue;
    TextView resultView, colorTable;

    int red = 0;
    int green = 0;
    int blue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        seekRed = findViewById(R.id.seekRed);
        seekGreen = findViewById(R.id.seekGreen);
        seekBlue = findViewById(R.id.seekBlue);
        txtRed = findViewById(R.id.txtRed);
        txtGreen = findViewById(R.id.txtGreen);
        txtBlue = findViewById(R.id.txtBlue);
        resultView = findViewById(R.id.resultView);
        colorTable = findViewById(R.id.colorTable);

        seekRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                red = progress;
                updateColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green = progress;
                updateColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        seekBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                blue = progress;
                updateColor();
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        updateColor();
    }

    private void updateColor() {

        txtRed.setText(red + "(" + String.format("%02X", red) + ")");
        txtGreen.setText(green + "(" + String.format("%02X", green) + ")");
        txtBlue.setText(blue + "(" + String.format("%02X", blue) + ")");

        String hexColor = String.format("%02X%02X%02X", red, green, blue);

        resultView.setText(hexColor);
        resultView.setBackgroundColor(Color.rgb(red, green, blue));

        colorTable.setBackgroundColor(Color.rgb(red, green, blue));
    }
}
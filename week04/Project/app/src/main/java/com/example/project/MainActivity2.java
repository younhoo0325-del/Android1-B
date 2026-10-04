package com.example.project;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    ProgressBar progressHorizontal;
    ProgressBar progressCircle;
    ProgressBar progressVertical;

    TextView txtPercent1;
    TextView txtPercent2;
    TextView txtPercent3;

    SeekBar seekBar;

    Button btnPlus;
    Button btnMinus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        progressHorizontal = findViewById(R.id.progressHorizontal);
        progressCircle = findViewById(R.id.progressCircle);
        progressVertical = findViewById(R.id.progressVertical);

        txtPercent1 = findViewById(R.id.txtPercent1);
        txtPercent2 = findViewById(R.id.txtPercent2);
        txtPercent3 = findViewById(R.id.txtPercent3);

        seekBar = findViewById(R.id.seekBar);

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnPlus.setOnClickListener(v -> {

            int progress = seekBar.getProgress() + 10;

            if (progress > 100) {
                progress = 100;
            }

            seekBar.setProgress(progress);
        });

        btnMinus.setOnClickListener(v -> {

            int progress = seekBar.getProgress() - 10;
            if (progress < 0) {
                progress = 0;
            }
            seekBar.setProgress(progress);
        });
    }

    private void updateProgress(int progress) {

        progressHorizontal.setProgress(progress);
        progressCircle.setProgress(progress);
        progressVertical.setProgress(progress);

        txtPercent1.setText(progress + " %");
        txtPercent2.setText(progress + " %");
        txtPercent3.setText(progress + " %");
    }
}
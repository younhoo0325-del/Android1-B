package com.example.report04;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity3 extends AppCompatActivity {

    SeekBar seekCelsius, seekFahrenheit;

    TextView txtCelsius, txtFahrenheit, txtResult;

    RadioGroup radioGroup;
    RadioButton radioCtoF, radioFtoC;

    Button btnConvert, btnReset;

    int celsius = 0;
    int fahrenheit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        seekCelsius = findViewById(R.id.seekCelsius);
        seekFahrenheit = findViewById(R.id.seekFahrenheit);

        txtCelsius = findViewById(R.id.txtCelsius);
        txtFahrenheit = findViewById(R.id.txtFahrenheit);
        txtResult = findViewById(R.id.txtResult);

        radioGroup = findViewById(R.id.radioGroup);
        radioCtoF = findViewById(R.id.radioCtoF);
        radioFtoC = findViewById(R.id.radioFtoC);

        btnConvert = findViewById(R.id.btnConvert);
        btnReset = findViewById(R.id.btnReset);

        seekCelsius.setEnabled(false);
        seekFahrenheit.setEnabled(false);

        radioGroup.setOnCheckedChangeListener(
                (group, checkedId) -> {

                    if (checkedId == R.id.radioCtoF) {
                        seekCelsius.setEnabled(true);
                        seekFahrenheit.setEnabled(false);

                    } else if (checkedId == R.id.radioFtoC) {
                        seekCelsius.setEnabled(false);
                        seekFahrenheit.setEnabled(true);

                    } else {

                        seekCelsius.setEnabled(false);
                        seekFahrenheit.setEnabled(false);
                    }

                    txtResult.setText("");
                });


        seekCelsius.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar,
                            int progress,
                            boolean fromUser) {

                        celsius = progress - 100;

                        txtCelsius.setText(
                                String.format(
                                        Locale.US,
                                        "섭씨온도(%.1f℃)",
                                        (double) celsius
                                )
                        );

                        if (fromUser) {
                            txtResult.setText("");
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(
                            SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(
                            SeekBar seekBar) {
                    }
                });


        seekFahrenheit.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar,
                            int progress,
                            boolean fromUser) {

                        fahrenheit = progress - 100;

                        txtFahrenheit.setText(
                                String.format(
                                        Locale.US,
                                        "화씨온도(%.1f℉)",
                                        (double) fahrenheit
                                )
                        );

                        if (fromUser) {
                            txtResult.setText("");
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(
                            SeekBar seekBar) {
                    }

                    @Override
                    public void onStopTrackingTouch(
                            SeekBar seekBar) {
                    }
                });


        btnConvert.setOnClickListener(v -> convertTemperature());

        btnReset.setOnClickListener(v -> resetTemperature());
    }

    private void convertTemperature() {

        int checkedId = radioGroup.getCheckedRadioButtonId();

        if (checkedId == -1) {

            Toast.makeText(
                    this,
                    "선택해주세요",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        if (checkedId == R.id.radioCtoF) {

            double resultF = (celsius * 1.8) + 32;

            String result = String.format(
                    Locale.US,
                    "섭씨온도 : %.2f ℃, 화씨온도 : %.2f ℉",
                    (double) celsius,
                    resultF
            );

            txtResult.setText(result);

        } else if (checkedId == R.id.radioFtoC) {

            double resultC = (fahrenheit - 32) / 1.8;

            String result = String.format(
                    Locale.US,
                    "화씨온도 : %.2f ℉, 섭씨온도 : %.2f ℃",
                    (double) fahrenheit,
                    resultC
            );

            txtResult.setText(result);
        }
    }

    private void resetTemperature() {

        radioGroup.clearCheck();

        seekCelsius.setProgress(100);
        seekFahrenheit.setProgress(100);

        celsius = 0;
        fahrenheit = 0;

        txtCelsius.setText("섭씨온도(0.0℃)");
        txtFahrenheit.setText("화씨온도(0.0℉)");

        txtResult.setText("");

        seekCelsius.setEnabled(false);
        seekFahrenheit.setEnabled(false);
    }
}

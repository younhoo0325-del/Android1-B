
package com.example.report04;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    SeekBar seekWeight, seekHeight;
    TextView txtWeight, txtHeight, txtBMI;
    double weight = 35.0;
    double height = 90.0;
    boolean weightChanged = false;
    boolean heightChanged = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        seekWeight = findViewById(R.id.seekWeight);
        seekHeight = findViewById(R.id.seekHeight);

        txtWeight = findViewById(R.id.txtWeight);
        txtHeight = findViewById(R.id.txtHeight);
        txtBMI = findViewById(R.id.txtBMI);


        seekWeight.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar,
                            int progress,
                            boolean fromUser) {

                        weight = 35.0 + (progress * 0.5);

                        txtWeight.setText(
                                String.format(
                                        Locale.US,
                                        "%.1f Kg",
                                        weight
                                )
                        );

                        if (fromUser) {
                            weightChanged = true;
                        }

                        calculateBMI();
                    }

                    @Override
                    public void onStartTrackingTouch(
                            SeekBar seekBar) {
                        weightChanged = true;
                    }

                    @Override
                    public void onStopTrackingTouch(
                            SeekBar seekBar) {
                        calculateBMI();
                    }
                });

        seekHeight.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar,
                            int progress,
                            boolean fromUser) {


                        height = 90.0 + (progress * 0.5);

                        txtHeight.setText(
                                String.format(
                                        Locale.US,
                                        "%.1f Cm",
                                        height
                                )
                        );

                        if (fromUser) {
                            heightChanged = true;
                        }

                        calculateBMI();
                    }

                    @Override
                    public void onStartTrackingTouch(
                            SeekBar seekBar) {
                        heightChanged = true;
                    }

                    @Override
                    public void onStopTrackingTouch(
                            SeekBar seekBar) {
                        calculateBMI();
                    }
                });
    }


    private void calculateBMI() {


        if (!weightChanged || !heightChanged) {
            txtBMI.setText("");
            return;
        }

        double heightMeter = height / 100.0;

        double bmi = weight / (heightMeter * heightMeter);

        String status;

        if (bmi < 18.5) {
            status = "저체중";
        } else if (bmi < 23.0) {
            status = "정상 체중";
        } else if (bmi < 25.0) {
            status = "과체중";
        } else {
            status = "비만";
        }

        String result = String.format(
                Locale.US,
                "BMI : %.2f\n당신은 %s 입니다!",
                bmi,
                status
        );

        txtBMI.setText(result);
    }
}

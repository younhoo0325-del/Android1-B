
package com.example.report04;

import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar1, seekBar2;
    private TextView txtNum1, txtNum2, txtResult;
    private Button btnCalc;

    private int num1 = 1;
    private int num2 = 1;

    private boolean changed1 = false;
    private boolean changed2 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar1 = findViewById(R.id.seekBar1);
        seekBar2 = findViewById(R.id.seekBar2);

        txtNum1 = findViewById(R.id.txtNum1);
        txtNum2 = findViewById(R.id.txtNum2);
        txtResult = findViewById(R.id.txtResult);

        btnCalc = findViewById(R.id.btnCalc);

        seekBar1.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar,
                            int progress,
                            boolean fromUser) {

                        num1 = progress + 1;
                        txtNum1.setText(
                                "자연수 입력(" + num1 + ")"
                        );

                        if (fromUser) {
                            changed1 = true;
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(
                            SeekBar seekBar) {
                        changed1 = true;
                    }

                    @Override
                    public void onStopTrackingTouch(
                            SeekBar seekBar) {
                    }
                });

        seekBar2.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {

                    @Override
                    public void onProgressChanged(
                            SeekBar seekBar,
                            int progress,
                            boolean fromUser) {

                        num2 = progress + 1;
                        txtNum2.setText(
                                "자연수 입력(" + num2 + ")"
                        );

                        if (fromUser) {
                            changed2 = true;
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(
                            SeekBar seekBar) {
                        changed2 = true;
                    }

                    @Override
                    public void onStopTrackingTouch(
                            SeekBar seekBar) {
                    }
                });

        btnCalc.setOnClickListener(v -> calculate());
    }

    private void calculate() {

        if (!changed1 || !changed2) {
            Toast.makeText(
                    this,
                    "입력 바람",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        int a = num1;
        int b = num2;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        int gcd = a;
        int lcm = (num1 * num2) / gcd;

        String result =
                num1 + ", " + num2
                        + "의 GCD(최대공약수)는 "
                        + gcd + "입니다.\n"
                        + num1 + ", " + num2
                        + "의 LCM(최소공배수)는 "
                        + lcm + "입니다.";

        txtResult.setText(result);
    }
}

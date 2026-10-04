package com.example.report01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText editCelsius;
    EditText editFahrenheit;

    Button btnFahrenheit;
    Button btnCelsius;

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editCelsius = findViewById(R.id.editCelsius);
        editFahrenheit = findViewById(R.id.editFahrenheit);

        btnFahrenheit = findViewById(R.id.btnFahrenheit);
        btnCelsius = findViewById(R.id.btnCelsius);

        txtResult = findViewById(R.id.txtResult);



        btnFahrenheit.setOnClickListener(v -> {

            String input = editCelsius.getText().toString().trim();

            if (input.isEmpty()) {
                Toast.makeText(
                        MainActivity2.this,
                        "섭씨 온도를 입력하세요.",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            double celsius = Double.parseDouble(input);

            // 화씨 = 섭씨 × 1.8 + 32
            double fahrenheit = celsius * 1.8 + 32;

            txtResult.setText(
                    String.format(
                            "섭씨 온도 %.2f도는\n화씨 온도 %.2f도 입니다.",
                            celsius,
                            fahrenheit
                    )
            );
        });



        btnCelsius.setOnClickListener(v -> {

            String input = editFahrenheit.getText().toString().trim();

            if (input.isEmpty()) {
                Toast.makeText(
                        MainActivity2.this,
                        "화씨 온도를 입력하세요.",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            double fahrenheit = Double.parseDouble(input);


            double celsius = (fahrenheit - 32) / 1.8;

            txtResult.setText(
                    String.format(
                            "화씨 온도 %.2f도는\n섭씨 온도 %.2f도 입니다.",
                            fahrenheit,
                            celsius
                    )
            );
        });
    }
}
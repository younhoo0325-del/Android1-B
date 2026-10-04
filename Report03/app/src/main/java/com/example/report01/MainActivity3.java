package com.example.report01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    EditText editBirthYear;
    EditText editAge;

    Button btnAge;
    Button btnBirthYear;

    final int CURRENT_YEAR = 2025;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editBirthYear = findViewById(R.id.editBirthYear);
        editAge = findViewById(R.id.editAge);

        btnAge = findViewById(R.id.btnAge);
        btnBirthYear = findViewById(R.id.btnBirthYear);



        btnAge.setOnClickListener(v -> {

            String input = editBirthYear.getText().toString().trim();

            if (input.isEmpty()) {

                Toast.makeText(
                        MainActivity3.this,
                        "태어난 년도를 입력하세요.",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            int birthYear = Integer.parseInt(input);

            int age = CURRENT_YEAR - birthYear;

            Toast.makeText(
                    MainActivity3.this,
                    "당신의 나이는 " + age + "세입니다.",
                    Toast.LENGTH_SHORT
            ).show();
        });



        btnBirthYear.setOnClickListener(v -> {

            String input = editAge.getText().toString().trim();

            if (input.isEmpty()) {

                Toast.makeText(
                        MainActivity3.this,
                        "당신의 나이를 입력하세요.",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            int age = Integer.parseInt(input);

            int birthYear = CURRENT_YEAR - age;

            Toast.makeText(
                    MainActivity3.this,
                    "당신의 태어난 해는 " + birthYear + "년입니다.",
                    Toast.LENGTH_SHORT
            ).show();
        });
    }
}
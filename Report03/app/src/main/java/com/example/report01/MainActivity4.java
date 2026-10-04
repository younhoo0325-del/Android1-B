package com.example.report01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    CheckBox checkReading;
    CheckBox checkTravel;
    CheckBox checkGame;

    Button btnSelect;

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        checkReading = findViewById(R.id.checkReading);
        checkTravel = findViewById(R.id.checkTravel);
        checkGame = findViewById(R.id.checkGame);

        btnSelect = findViewById(R.id.btnSelect);

        txtResult = findViewById(R.id.txtResult);


        btnSelect.setOnClickListener(v -> {

            String hobby = "";


            if (checkReading.isChecked()) {
                hobby += "독서";
            }


            if (checkTravel.isChecked()) {

                if (!hobby.isEmpty()) {
                    hobby += ", ";
                }

                hobby += "여행";
            }


            if (checkGame.isChecked()) {

                if (!hobby.isEmpty()) {
                    hobby += ", ";
                }

                hobby += "게임";
            }



            if (hobby.isEmpty()) {

                txtResult.setText("");

                Toast.makeText(
                        MainActivity4.this,
                        "취미를 선택해주세요.",
                        Toast.LENGTH_SHORT
                ).show();

            } else {


                txtResult.setText("선택한 취미 : " + hobby);
            }

        });
    }
}
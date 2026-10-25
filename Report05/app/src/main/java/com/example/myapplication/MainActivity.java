
package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txtGrade;
    int selectedGrade = -1;

    String[] grades = {
            "1학년",
            "2학년",
            "3학년",
            "4학년"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtGrade = findViewById(R.id.txtGrade);

        txtGrade.setOnClickListener(v -> showGradeDialog());
    }

    private void showGradeDialog() {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle("몇학년 입니까?");

        builder.setSingleChoiceItems(
                grades,
                selectedGrade,
                (dialog, which) -> {
                    selectedGrade = which;
                }
        );

        builder.setPositiveButton("닫기",
                (dialog, which) -> {
                    if (selectedGrade != -1) {
                        txtGrade.setText(grades[selectedGrade]);
                    }
                });

        builder.show();
    }
}


package com.example.myapplication;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button btnAlert, btnInput, btnList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnAlert = findViewById(R.id.btnAlert);
        btnInput = findViewById(R.id.btnInput);
        btnList = findViewById(R.id.btnList);


        btnAlert.setOnClickListener(v -> showAlertDialog());

        btnInput.setOnClickListener(v -> showInputDialog());

        btnList.setOnClickListener(v -> showHobbyDialog());
    }

    private void showAlertDialog() {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle("알림");
        builder.setMessage("이번주 레포트는 Dialog 입니다");

        builder.setPositiveButton("확인",
                (dialog, which) -> {

                    Toast.makeText(
                            MainActivity2.this,
                            "확인했습니다",
                            Toast.LENGTH_SHORT
                    ).show();

                });

        builder.show();
    }

    private void showInputDialog() {

        EditText editText = new EditText(this);

        editText.setSingleLine(true);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle("이름 입력");
        builder.setView(editText);

        builder.setNegativeButton("Cancel",
                (dialog, which) -> dialog.dismiss());

        builder.setPositiveButton("OK",
                (dialog, which) -> {

                    String name = editText.getText()
                            .toString().trim();

                    if (name.isEmpty()) {

                        Toast.makeText(
                                MainActivity2.this,
                                "입력해주세요",
                                Toast.LENGTH_SHORT
                        ).show();

                    } else {

                        Toast.makeText(
                                MainActivity2.this,
                                name,
                                Toast.LENGTH_SHORT
                        ).show();

                    }
                });

        builder.show();
    }

    private void showHobbyDialog() {

        String[] hobbies = {
                "독서",
                "등산",
                "수영",
                "수집",
                "영화"
        };

        boolean[] checkedItems =
                new boolean[hobbies.length];

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle("당신의 취미는?");

        builder.setMultiChoiceItems(
                hobbies,
                checkedItems,
                (dialog, which, isChecked) -> {
                    checkedItems[which] = isChecked;
                }
        );

        builder.setPositiveButton("닫기",
                (dialog, which) -> {

                    ArrayList<String> selected =
                            new ArrayList<>();

                    for (int i = 0; i < hobbies.length; i++) {

                        if (checkedItems[i]) {
                            selected.add(hobbies[i]);
                        }
                    }

                    if (selected.isEmpty()) {

                        Toast.makeText(
                                MainActivity2.this,
                                "취미를 선택해주세요",
                                Toast.LENGTH_SHORT
                        ).show();

                    } else {

                        String result = "취미 : "
                                + String.join(", ", selected);

                        Toast.makeText(
                                MainActivity2.this,
                                result,
                                Toast.LENGTH_SHORT
                        ).show();

                    }
                });

        builder.show();
    }
}

package com.example.project;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {


    String gender = "남자";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        LinearLayout layout1 =
                findViewById(R.id.layoutSample1);

        LinearLayout layout2 =
                findViewById(R.id.layoutSample2);

        Button button1 =
                findViewById(R.id.btnSample1);

        Button button2 =
                findViewById(R.id.btnSample2);

        EditText editName =
                findViewById(R.id.editName);

        Button btnConfirm =
                findViewById(R.id.btnConfirm);

        EditText editText =
                findViewById(R.id.editText);

        Button button =
                findViewById(R.id.button);

        ImageView imageView =
                findViewById(R.id.imageView);

        RadioGroup group =
                findViewById(R.id.radioGroup);

        layout1.setVisibility(View.VISIBLE);
        layout2.setVisibility(View.GONE);



        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
            }
        });


        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                layout1.setVisibility(View.GONE);
                layout2.setVisibility(View.VISIBLE);
            }
        });


        btnConfirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name =
                        editName.getText().toString().trim();

                if (name.isEmpty()) {

                    Toast.makeText(
                            MainActivity2.this,
                            "이름을 입력하세요.",
                            Toast.LENGTH_SHORT
                    ).show();

                } else {

                    Toast.makeText(
                            MainActivity2.this,
                            "입력한 이름 : " + name,
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });


        group.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {

                    @Override
                    public void onCheckedChanged(
                            RadioGroup group,
                            int checkedId) {


                        if (checkedId == R.id.radio1) {

                            imageView.setImageResource(
                                    R.drawable.man1
                            );

                            gender = "남자";

                        }


                        else if (checkedId == R.id.radio2) {

                            imageView.setImageResource(
                                    R.drawable.woman1
                            );

                            gender = "여자";
                        }
                    }
                }
        );


        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String name =
                        editText.getText().toString().trim();

                String message;



                if (name.isEmpty()) {

                    message = "이름 입력 해주세요";

                }


                else {

                    message = String.format(
                            "환영합니다. %s(%s) 님!!!",
                            name,
                            gender
                    );
                }


                Toast.makeText(
                        getBaseContext(),
                        message,
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }
}
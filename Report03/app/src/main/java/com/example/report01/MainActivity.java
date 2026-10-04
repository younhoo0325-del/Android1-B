package com.example.report01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editId;
    EditText editPassword;
    Button btnLogin;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editId = findViewById(R.id.editId);
        editPassword = findViewById(R.id.editPassword);
        btnLogin = findViewById(R.id.btnLogin);
        txtResult = findViewById(R.id.txtResult);

        btnLogin.setOnClickListener(v -> {

            String id = editId.getText().toString().trim();
            String password = editPassword.getText().toString().trim();


            if (id.isEmpty() || password.isEmpty()) {

                Toast.makeText(
                        MainActivity.this,
                        "데이터 입력 해주세요",
                        Toast.LENGTH_SHORT
                ).show();

                txtResult.setVisibility(TextView.INVISIBLE);

            } else {


                txtResult.setText(
                        "아이디 : " + id + " 비밀번호 : " + password
                );

                txtResult.setVisibility(TextView.VISIBLE);
            }
        });
    }
}
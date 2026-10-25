
package com.example.myapplication;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    Button btnSpinner, btnHorizontal, btnCustom;

    ProgressDialog progressDialog;

    Handler handler = new Handler(Looper.getMainLooper());

    Runnable progressRunnable;

    int progress = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnSpinner = findViewById(R.id.btnSpinner);
        btnHorizontal = findViewById(R.id.btnHorizontal);
        btnCustom = findViewById(R.id.btnCustom);

        btnSpinner.setOnClickListener(v -> {
            showSpinnerDialog();
        });

        btnHorizontal.setOnClickListener(v -> {
            showHorizontalDialog();
        });

        btnCustom.setOnClickListener(v -> {
            showCustomDialog();
        });
    }

    private void showSpinnerDialog() {

        progressDialog = new ProgressDialog(this);

        progressDialog.setTitle(
                "프로그램 다이얼로그1 (Spinner)"
        );

        progressDialog.setMessage(
                "현재 처리중입니다."
        );

        progressDialog.setProgressStyle(
                ProgressDialog.STYLE_SPINNER
        );

        progressDialog.setCancelable(false);

        progressDialog.setButton(
                ProgressDialog.BUTTON_NEGATIVE,
                "취소",
                (dialog, which) -> {

                    dialog.dismiss();

                    Toast.makeText(
                            MainActivity3.this,
                            "취소하였습니다",
                            Toast.LENGTH_SHORT
                    ).show();
                }
        );

        progressDialog.show();
    }

    private void showHorizontalDialog() {


        stopProgress();

        progress = 0;

        progressDialog = new ProgressDialog(this);

        progressDialog.setTitle(
                "프로그램 다이얼로그2 (Horizontal)"
        );

        progressDialog.setMessage(
                "잠시만 기다려 주세요."
        );

        progressDialog.setProgressStyle(
                ProgressDialog.STYLE_HORIZONTAL
        );

        progressDialog.setMax(100);
        progressDialog.setProgress(0);
        progressDialog.setCancelable(false);

        progressDialog.setButton(
                ProgressDialog.BUTTON_NEGATIVE,
                "취소",
                (dialog, which) -> {

                    stopProgress();
                    dialog.dismiss();

                    Toast.makeText(
                            MainActivity3.this,
                            "취소하였습니다",
                            Toast.LENGTH_SHORT
                    ).show();
                }
        );

        progressDialog.show();


        progressRunnable = new Runnable() {

            @Override
            public void run() {

                if (progressDialog == null ||
                        !progressDialog.isShowing()) {
                    return;
                }

                progress += 5;

                if (progress > 100) {
                    progress = 100;
                }

                progressDialog.setProgress(progress);

                if (progress < 100) {

                    handler.postDelayed(this, 200);

                } else {

                    progressDialog.setMessage(
                            "로딩이 완료되었습니다"
                    );

                    Toast.makeText(
                            MainActivity3.this,
                            "로딩이 완료되었습니다",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        };

        handler.postDelayed(progressRunnable, 200);
    }

    private void stopProgress() {

        if (progressRunnable != null) {
            handler.removeCallbacks(progressRunnable);
            progressRunnable = null;
        }
    }

    private void showCustomDialog() {

        LayoutInflater inflater =
                LayoutInflater.from(this);

        View dialogView = inflater.inflate(
                R.layout.dialog_custom,
                null
        );

        EditText editId =
                dialogView.findViewById(R.id.editId);

        EditText editPwd =
                dialogView.findViewById(R.id.editPwd);

        Button btnLogin =
                dialogView.findViewById(R.id.btnLogin);

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle("커스텀 다이얼로그");
        builder.setView(dialogView);

        builder.setNegativeButton(
                "취소",
                (dialog, which) -> {

                    dialog.dismiss();

                    Toast.makeText(
                            MainActivity3.this,
                            "취소하였습니다",
                            Toast.LENGTH_SHORT
                    ).show();
                }
        );

        AlertDialog dialog = builder.create();

        btnLogin.setOnClickListener(v -> {

            String id = editId.getText()
                    .toString().trim();

            String pwd = editPwd.getText()
                    .toString().trim();

            if (id.isEmpty() || pwd.isEmpty()) {

                Toast.makeText(
                        MainActivity3.this,
                        "정확하게 입력해주세요",
                        Toast.LENGTH_SHORT
                ).show();

            } else {

                Toast.makeText(
                        MainActivity3.this,
                        id + "/" + pwd,
                        Toast.LENGTH_SHORT
                ).show();

                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        stopProgress();

        if (progressDialog != null &&
                progressDialog.isShowing()) {
            progressDialog.dismiss();
        }

        super.onDestroy();
    }
}

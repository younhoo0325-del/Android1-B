
package com.example.project;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private final Handler handler = new Handler(Looper.getMainLooper());
    private ProgressDialog activeProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(v -> showAlertDialog());
        findViewById(R.id.button2).setOnClickListener(v -> showDatePicker());
        findViewById(R.id.button3).setOnClickListener(v -> showTimePicker());
        findViewById(R.id.button4).setOnClickListener(v -> showNumberPicker());
        findViewById(R.id.button5).setOnClickListener(v -> showCharacterPicker());
        findViewById(R.id.button6).setOnClickListener(v -> showProgressDialog());
        findViewById(R.id.button7).setOnClickListener(v -> showCustomDialog());
    }


    private void showAlertDialog() {
        new AlertDialog.Builder(this)
                .setTitle("일반 Dialog")
                .setMessage("앱을 종료하시겠습니까?")
                .setIcon(R.mipmap.ic_launcher)
                .setPositiveButton("예", (dialog, which) -> {
                    Toast.makeText(this, "종료합니다.", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .setNegativeButton("취소", (dialog, which) ->
                        Toast.makeText(this, "취소 버튼을 눌렀음", Toast.LENGTH_SHORT).show())
                .setNeutralButton("확인", (dialog, which) ->
                        Toast.makeText(this, "확인완료", Toast.LENGTH_SHORT).show())
                .setCancelable(false)
                .show();
    }


    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    String result = selectedYear + "년 "
                            + (selectedMonth + 1) + "월 " + selectedDay + "일";
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }, year, month, day);

        dialog.setTitle("날짜 선택");
        dialog.show();
    }


    private void showTimePicker() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog dialog = new TimePickerDialog(this,
                (view, selectedHour, selectedMinute) -> {
                    String result = String.format(Locale.KOREA,
                            "%02d:%02d", selectedHour, selectedMinute);

                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }, hour, minute, true);

        dialog.setTitle("시간 선택");
        dialog.show();
    }


    private void showNumberPicker() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_birthday);

        NumberPicker numberPicker = dialog.findViewById(R.id.numberPicker);
        Button cancelButton = dialog.findViewById(R.id.button51);
        Button confirmButton = dialog.findViewById(R.id.button52);

        numberPicker.setMaxValue(currentYear - 15);
        numberPicker.setMinValue(currentYear - 80);
        numberPicker.setValue(currentYear - 20);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setDescendantFocusability(
                NumberPicker.FOCUS_BLOCK_DESCENDANTS
        );

        cancelButton.setOnClickListener(v -> dialog.dismiss());

        confirmButton.setOnClickListener(v -> {
            Toast.makeText(
                    this,
                    "선택한 출생 연도 : " + numberPicker.getValue(),
                    Toast.LENGTH_SHORT
            ).show();

            dialog.dismiss();
        });

        dialog.show();
    }


    private void showCharacterPicker() {
        String options = "035167924ACBEFD";

        CharacterPickerDialog dialog = new CharacterPickerDialog(
                this,
                new View(this),
                null,
                options,
                false
        ) {
            @Override
            public void onClick(View v) {
                if (v instanceof Button) {
                    String selected = ((Button) v).getText().toString();

                    Toast.makeText(
                            MainActivity.this,
                            "선택한 문자 : " + selected,
                            Toast.LENGTH_SHORT
                    ).show();
                }

                dismiss();
            }
        };

        dialog.show();
    }


    @SuppressWarnings("deprecation")
    private void showProgressDialog() {
        ProgressDialog dialog = new ProgressDialog(this);
        activeProgressDialog = dialog;

        dialog.setTitle("공지");
        dialog.setMessage(
                "잠시만 기다려 주세요.\n" +
                        "프로그램 로딩 중입니다.\n" +
                        "중지하시겠습니까?"
        );

        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setCancelable(false);

        Runnable completion = () -> {
            if (!isFinishing() && !isDestroyed() && dialog.isShowing()) {
                dialog.dismiss();

                Toast.makeText(
                        this,
                        "프로그램 로딩 완료",
                        Toast.LENGTH_SHORT
                ).show();
            }
        };

        dialog.setOnDismissListener(d -> {
            handler.removeCallbacks(completion);

            if (activeProgressDialog == dialog) {
                activeProgressDialog = null;
            }
        });

        dialog.setButton(
                DialogInterface.BUTTON_NEGATIVE,
                "취소",
                (d, which) -> {
                    Toast.makeText(
                            this,
                            "취소하였습니다.",
                            Toast.LENGTH_SHORT
                    ).show();

                    d.dismiss();
                }
        );

        dialog.show();
        handler.postDelayed(completion, 5000);
    }


    private void showCustomDialog() {
        CustomDialog dialog = new CustomDialog(
                this,
                "환영",
                "Custom Dialog 만들기에 오신 것을 환영합니다.",
                enteredText -> {
                    String result = enteredText.trim().isEmpty()
                            ? "Custom Dialog 확인 버튼을 눌렀습니다."
                            : "입력한 내용 : " + enteredText;

                    Toast.makeText(
                            this,
                            result,
                            Toast.LENGTH_SHORT
                    ).show();
                }
        );

        dialog.show();
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);

        if (activeProgressDialog != null && activeProgressDialog.isShowing()) {
            activeProgressDialog.dismiss();
        }

        super.onDestroy();
    }
}

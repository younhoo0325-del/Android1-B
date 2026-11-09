
package com.example.project;

import android.content.Context;
import android.graphics.Color;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MyMethod {

    private final Context context;
    private final double Official = 3.305785;

    public MyMethod(Context context) {
        this.context = context;
    }

    public void bmiCheck(EditText editText1,
                         EditText editText2,
                         TextView textView) {

        String height = editText1.getText().toString().trim();
        String weight = editText2.getText().toString().trim();

        if (height.isEmpty() || weight.isEmpty()) {
            Toast.makeText(context,
                    "값을 입력해 주세요",
                    Toast.LENGTH_LONG).show();
            return;
        }

        try {
            double h = Double.parseDouble(height);
            double w = Double.parseDouble(weight);

            if (h <= 0 || w <= 0) {
                Toast.makeText(context,
                        "0보다 큰 값을 입력해 주세요",
                        Toast.LENGTH_LONG).show();
                return;
            }

            double result = w / ((h / 100) * (h / 100));

            if (result < 18.5) {
                textView.setTextColor(Color.RED);
                textView.setText(String.format(
                        Locale.KOREA,
                        "BMI : %.2f, 체중부족!!", result));

            } else if (result < 22.9) {
                textView.setTextColor(Color.GREEN);
                textView.setText(String.format(
                        Locale.KOREA,
                        "BMI : %.2f, 정상!!", result));

            } else if (result < 24.9) {
                textView.setTextColor(Color.RED);
                textView.setText(String.format(
                        Locale.KOREA,
                        "BMI : %.2f, 과체중!!", result));

            } else {
                textView.setTextColor(Color.RED);
                textView.setText(String.format(
                        Locale.KOREA,
                        "BMI : %.2f, 비만입니다!!!", result));
            }

        } catch (NumberFormatException e) {
            Toast.makeText(context,
                    "올바른 숫자를 입력해 주세요",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void changeToPyeong(EditText editText,
                               TextView textView) {

        String temp = editText.getText().toString().trim();

        if (temp.isEmpty()) {
            Toast.makeText(context,
                    "값을 입력해 주세요",
                    Toast.LENGTH_LONG).show();
            return;
        }

        try {
            double result = Math.round(
                    Double.parseDouble(temp) / Official * 100
            ) / 100.0;

            textView.setText(result + " 평");

        } catch (NumberFormatException e) {
            Toast.makeText(context,
                    "올바른 숫자를 입력해 주세요",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void changeToMeter(EditText editText,
                              TextView textView) {

        String temp = editText.getText().toString().trim();

        if (temp.isEmpty()) {
            Toast.makeText(context,
                    "값을 입력해 주세요",
                    Toast.LENGTH_LONG).show();
            return;
        }

        try {
            double result = Double.parseDouble(temp) * Official;
            textView.setText(result + " 제곱미터");

        } catch (NumberFormatException e) {
            Toast.makeText(context,
                    "올바른 숫자를 입력해 주세요",
                    Toast.LENGTH_LONG).show();
        }
    }
}


package com.example.project;

import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity4 extends AppCompatActivity {

    Spinner spinnerFruit;

    String[] fruits = {
            "과일을 고르세요",
            "사과",
            "딸기",
            "수박",
            "바나나",
            "감",
            "복숭아",
            "자두"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        setTitle("Report03");

        spinnerFruit = findViewById(R.id.spinnerFruit);

        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_item,
                        fruits
                ) {

                    @Override
                    public View getView(
                            int position,
                            View convertView,
                            ViewGroup parent) {

                        View view = super.getView(
                                position,
                                convertView,
                                parent
                        );

                        TextView textView = (TextView) view;

                        textView.setTextColor(Color.BLACK);

                        return view;
                    }

                    @Override
                    public View getDropDownView(
                            int position,
                            View convertView,
                            ViewGroup parent) {

                        View view = super.getDropDownView(
                                position,
                                convertView,
                                parent
                        );

                        TextView textView = (TextView) view;

                        if (position == 0) {
                            textView.setTextColor(Color.RED);
                        } else {
                            textView.setTextColor(Color.BLACK);
                        }

                        return view;
                    }
                };

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerFruit.setAdapter(adapter);

        spinnerFruit.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        if (position == 0) {
                            return;
                        }

                        String fruit = fruits[position];

                        Toast.makeText(
                                MainActivity4.this,
                                fruit + "는 맛있다",
                                Toast.LENGTH_SHORT
                        ).show();
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {
                    }
                }
        );
    }
}

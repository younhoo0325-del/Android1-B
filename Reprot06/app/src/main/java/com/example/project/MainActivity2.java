
package com.example.project;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    Button btnInputFruit, btnFruitResult;
    ListView listFruits;

    ArrayList<String> fruits = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        setTitle("Report01");

        btnInputFruit = findViewById(R.id.btnInputFruit);
        btnFruitResult = findViewById(R.id.btnFruitResult);
        listFruits = findViewById(R.id.listFruits);

        fruits.add("사과");
        fruits.add("배");
        fruits.add("귤");
        fruits.add("바나나");
        fruits.add("복숭아");
        fruits.add("수박");

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                fruits
        );

        listFruits.setAdapter(adapter);

        listFruits.setChoiceMode(
                ListView.CHOICE_MODE_MULTIPLE
        );

        listFruits.setOnItemClickListener(
                (parent, view, position, id) -> {

                    if (listFruits.isItemChecked(position)) {
                        Toast.makeText(
                                this,
                                "선택 : " + fruits.get(position),
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

        btnInputFruit.setOnClickListener(v -> {
            showInputDialog();
        });

        btnFruitResult.setOnClickListener(v -> {
            showResultDialog();
        });
    }

    private void showInputDialog() {

        EditText editFruit = new EditText(this);

        editFruit.setHint("과일 이름 입력해주세요");
        editFruit.setSingleLine(true);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(24, 16, 24, 16);
        layout.setBackgroundColor(0xFF33B5E5);

        android.widget.TextView label =
                new android.widget.TextView(this);

        label.setText("과일 이름 :");
        label.setTextSize(16);
        label.setTextColor(0xFF222222);

        layout.addView(label);
        layout.addView(editFruit);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("과일 입력")
                .setView(layout)
                .setPositiveButton("확인", null)
                .create();

        dialog.setOnShowListener(d -> {

            dialog.getButton(
                    AlertDialog.BUTTON_POSITIVE
            ).setOnClickListener(v -> {

                String name = editFruit.getText()
                        .toString().trim();

                if (name.isEmpty()) {

                    Toast.makeText(
                            this,
                            "과일 이름을 입력해주세요",
                            Toast.LENGTH_SHORT
                    ).show();

                    return;
                }

                // 목록 추가
                fruits.add(name);
                adapter.notifyDataSetChanged();

                Toast.makeText(
                        this,
                        "입력하였습니다",
                        Toast.LENGTH_SHORT
                ).show();

                dialog.dismiss();
            });
        });

        dialog.show();
    }

    private ArrayList<Integer> getSelectedPositions() {

        ArrayList<Integer> selected = new ArrayList<>();

        SparseBooleanArray checked =
                listFruits.getCheckedItemPositions();

        for (int i = 0; i < fruits.size(); i++) {

            if (checked.get(i)) {
                selected.add(i);
            }
        }

        return selected;
    }

    private void showResultDialog() {

        ArrayList<Integer> selected =
                getSelectedPositions();

        if (selected.isEmpty()) {

            Toast.makeText(
                    this,
                    "과일을 선택해주세요",
                    Toast.LENGTH_SHORT
            ).show();

            return;
        }

        StringBuilder result = new StringBuilder();

        for (int position : selected) {

            result.append(fruits.get(position))
                    .append("\n\n");
        }

        new AlertDialog.Builder(this)
                .setTitle("선택한 과일 목록")
                .setMessage(result.toString().trim())
                .setNegativeButton("삭제",
                        (dialog, which) -> {

                            deleteSelectedFruits(selected);
                        })
                .setPositiveButton("확인",
                        (dialog, which) -> {

                            dialog.dismiss();
                        })
                .show();
    }

    private void deleteSelectedFruits(
            ArrayList<Integer> selected) {

        if (selected.isEmpty()) {
            return;
        }

        for (int i = selected.size() - 1; i >= 0; i--) {

            int position = selected.get(i);

            fruits.remove(position);
        }

        listFruits.clearChoices();

        adapter.notifyDataSetChanged();

        Toast.makeText(
                this,
                selected.size() + "개 삭제하였습니다",
                Toast.LENGTH_SHORT
        ).show();
    }
}

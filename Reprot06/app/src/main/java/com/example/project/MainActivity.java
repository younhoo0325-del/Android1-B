
package com.example.project;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editName;
    Button btnAdd, btnDelete, btnResult;
    ListView listMembers;

    ArrayList<String> members = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnResult = findViewById(R.id.btnResult);
        listMembers = findViewById(R.id.listMembers);

        members.add("홍길동");
        members.add("이대한");
        members.add("한민국");

        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                members
        );

        listMembers.setAdapter(adapter);
        listMembers.setChoiceMode(
                ListView.CHOICE_MODE_MULTIPLE
        );

        listMembers.setOnItemClickListener(
                (parent, view, position, id) -> {

                    if (listMembers.isItemChecked(position)) {
                        Toast.makeText(
                                this,
                                "선택 : " + members.get(position),
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

        btnAdd.setOnClickListener(v -> {

            String name = editName.getText()
                    .toString().trim();

            if (name.isEmpty()) {
                Toast.makeText(
                        this,
                        "이름을 입력해주세요",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            members.add(name);
            adapter.notifyDataSetChanged();
            editName.setText("");

            Toast.makeText(
                    this,
                    "입력하였습니다",
                    Toast.LENGTH_SHORT
            ).show();
        });

        btnDelete.setOnClickListener(v -> deleteMembers());

        btnResult.setOnClickListener(v -> showResult());
    }

    private ArrayList<Integer> getSelected() {

        ArrayList<Integer> selected = new ArrayList<>();

        SparseBooleanArray checked =
                listMembers.getCheckedItemPositions();

        for (int i = 0; i < members.size(); i++) {
            if (checked.get(i)) {
                selected.add(i);
            }
        }

        return selected;
    }

    private void deleteMembers() {

        ArrayList<Integer> selected = getSelected();

        if (selected.isEmpty()) {
            Toast.makeText(
                    this,
                    "회원을 선택해주세요",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        for (int i = selected.size() - 1; i >= 0; i--) {
            members.remove((int) selected.get(i));
        }

        listMembers.clearChoices();
        adapter.notifyDataSetChanged();

        Toast.makeText(
                this,
                selected.size() + "개 삭제하였습니다",
                Toast.LENGTH_SHORT
        ).show();
    }

    private void showResult() {

        ArrayList<Integer> selected = getSelected();

        if (selected.isEmpty()) {
            Toast.makeText(
                    this,
                    "회원을 선택해주세요",
                    Toast.LENGTH_SHORT
            ).show();
            return;
        }

        StringBuilder result = new StringBuilder();

        for (int position : selected) {
            result.append(members.get(position))
                    .append("\n");
        }

        new AlertDialog.Builder(this)
                .setTitle("선택한 회원 목록")
                .setMessage(result.toString().trim())
                .setNegativeButton("삭제",
                        (dialog, which) -> deleteMembers())
                .setPositiveButton("확인",
                        (dialog, which) -> dialog.dismiss())
                .show();
    }
}

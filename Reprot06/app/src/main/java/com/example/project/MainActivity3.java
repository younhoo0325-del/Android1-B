
package com.example.project;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView recyclerView;
    CountryAdapter adapter;
    ArrayList<String> countries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        setTitle("Report01");

        recyclerView = findViewById(R.id.recyclerView);

        countries.add("신라");
        countries.add("고구려");
        countries.add("백제");
        countries.add("발해");
        countries.add("옥저");
        countries.add("동예");
        countries.add("부여");
        countries.add("대한민국");

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        adapter = new CountryAdapter(this, countries);

        recyclerView.setAdapter(adapter);
    }
}

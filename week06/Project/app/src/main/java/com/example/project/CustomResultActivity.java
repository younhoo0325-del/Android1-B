package com.example.project;

import android.os.Bundle;import android.widget.*;import androidx.appcompat.app.AppCompatActivity;
public class CustomResultActivity extends AppCompatActivity{@Override protected void onCreate(Bundle b){super.onCreate(b);setContentView(R.layout.activity_custom_result);setTitle("CustomListView 예제 결과");int p=getIntent().getIntExtra("position",0);String name=getIntent().getStringExtra("fruit");((TextView)findViewById(R.id.textview)).setText(p+" 번째 "+name+"을(를) 좋아합니다");findViewById(R.id.button).setOnClickListener(v->finish());}}

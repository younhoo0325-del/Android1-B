package com.example.project;

import android.app.AlertDialog;import android.os.Bundle;import android.widget.*;import androidx.appcompat.app.AppCompatActivity;
public class GridViewActivity extends AppCompatActivity{@Override protected void onCreate(Bundle b){super.onCreate(b);setContentView(R.layout.activity_gridview);setTitle("GridView 예제");String[] fruits=getResources().getStringArray(R.array.fruits);GridView grid=findViewById(R.id.gridView);grid.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,fruits));grid.setOnItemClickListener((p,v,pos,id)->new AlertDialog.Builder(this).setTitle("알림창").setMessage(pos+" 번째, "+fruits[pos]+"를 선택하셨습니다").setIcon(R.drawable.checked).setPositiveButton("확인",null).show());findViewById(R.id.button).setOnClickListener(v->finish());}}

package com.example.project;

import android.os.Bundle;import android.widget.*;import androidx.appcompat.app.AppCompatActivity;import java.util.*;
public class ExpandableListActivity extends AppCompatActivity{
@Override protected void onCreate(Bundle b){super.onCreate(b);setContentView(R.layout.activity_expandablelistview);setTitle("ExpandableListView 예제");ArrayList<String> groups=new ArrayList<>(Arrays.asList("과일","채소","기타"));HashMap<String,ArrayList<CustomItem>> children=new HashMap<>();
children.put("과일",new ArrayList<>(Arrays.asList(new CustomItem(R.drawable.apple,"사과"),new CustomItem(R.drawable.pear,"배"),new CustomItem(R.drawable.persimmon,"감"))));children.put("채소",new ArrayList<>(Arrays.asList(new CustomItem(R.drawable.cabbage,"배추"),new CustomItem(R.drawable.lettuce,"상추"),new CustomItem(R.drawable.spinach,"시금치"))));children.put("기타",new ArrayList<>(Arrays.asList(new CustomItem(R.drawable.rice,"쌀"),new CustomItem(R.drawable.bean,"콩"))));
ExpandableListView list=findViewById(R.id.expandablelist);list.setAdapter(new ExpandableAdapter(this,groups,children));list.setOnChildClickListener((p,v,g,c,id)->{String group=groups.get(g);Toast.makeText(this,group+"의 "+children.get(group).get(c).getName()+"을 선택",Toast.LENGTH_SHORT).show();return false;});findViewById(R.id.button).setOnClickListener(v->finish());}}

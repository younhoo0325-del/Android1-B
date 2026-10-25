package com.example.project;

import android.os.Bundle;import android.widget.*;import androidx.appcompat.app.AppCompatActivity;import androidx.recyclerview.widget.*;import java.util.*;
public class RecyclerViewActivity extends AppCompatActivity {
@Override protected void onCreate(Bundle b){super.onCreate(b);setContentView(R.layout.activity_recycler_view);setTitle("RecyclerView 예제");
List<CustomItem> items=new ArrayList<>(Arrays.asList(new CustomItem(R.drawable.apple,"Apple"),new CustomItem(R.drawable.pear,"Pear"),new CustomItem(R.drawable.banana,"Banana"),new CustomItem(R.drawable.strawberry,"Strawberry"),new CustomItem(R.drawable.pineapple,"Pineapple"),new CustomItem(R.drawable.mango,"Mango"),new CustomItem(R.drawable.cherry,"Cherry"),new CustomItem(R.drawable.persimmon,"Persimmon"),new CustomItem(R.drawable.melon,"Melon")));
RecyclerAdapter adapter=new RecyclerAdapter(items);RecyclerView list=findViewById(R.id.listView);list.setLayoutManager(new LinearLayoutManager(this));list.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));list.setItemAnimator(new FadeInAnimator());list.setAdapter(adapter);
EditText edit=findViewById(R.id.editText);findViewById(R.id.button1).setOnClickListener(v->{String name=edit.getText().toString().trim();if(name.isEmpty()){Toast.makeText(this,"입력해주세요",Toast.LENGTH_SHORT).show();return;}items.add(new CustomItem(R.drawable.ic_launcher,name));adapter.notifyItemInserted(items.size()-1);edit.setText("");});findViewById(R.id.button2).setOnClickListener(v->finish());
}}

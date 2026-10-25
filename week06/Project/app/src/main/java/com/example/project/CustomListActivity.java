package com.example.project;

import android.os.Bundle;import android.widget.*;import androidx.appcompat.app.AppCompatActivity;import java.util.ArrayList;
public class CustomListActivity extends AppCompatActivity {
@Override protected void onCreate(Bundle b){super.onCreate(b);setContentView(R.layout.activity_custom_list);setTitle("CustomListView 예제");
ArrayList<CustomItem> items=new ArrayList<>();
items.add(new CustomItem(R.drawable.apple,"Apple"));items.add(new CustomItem(R.drawable.pear,"Pear"));items.add(new CustomItem(R.drawable.banana,"Banana"));items.add(new CustomItem(R.drawable.strawberry,"Strawberry"));items.add(new CustomItem(R.drawable.pineapple,"Pineapple"));
CustomAdapter adapter=new CustomAdapter(this,items);ListView list=findViewById(R.id.listView);list.setAdapter(adapter);
EditText edit=findViewById(R.id.editText);findViewById(R.id.button).setOnClickListener(v->{String name=edit.getText().toString().trim();if(name.isEmpty()){Toast.makeText(this,"입력해주세요",Toast.LENGTH_SHORT).show();return;}items.add(new CustomItem(R.drawable.ic_launcher,name));adapter.notifyDataSetChanged();edit.setText("");});
}}

package com.example.project;

import android.content.Intent;import android.os.Bundle;import android.widget.*;import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
@Override protected void onCreate(Bundle b){super.onCreate(b);setContentView(R.layout.activity_main);
String[] names={"CustomListView","RecyclerView","ExpandableListView","Spinner","CustomSpinner","GridView","CustomGrid","Gallery","ListActivity"};
Class<?>[] pages={CustomListActivity.class,RecyclerViewActivity.class,ExpandableListActivity.class,SpinnerActivity.class,CustomSpinnerActivity.class,GridViewActivity.class,CustomGridActivity.class,GalleryActivity.class,SampleListActivity.class};
ListView list=findViewById(R.id.listView);list.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,names));list.setOnItemClickListener((p,v,pos,id)->startActivity(new Intent(this,pages[pos])));
}}

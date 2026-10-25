package com.example.project;

import android.os.Bundle;import android.widget.*;import androidx.appcompat.app.AppCompatActivity;
@SuppressWarnings("deprecation") public class GalleryActivity extends AppCompatActivity{@Override protected void onCreate(Bundle b){super.onCreate(b);setContentView(R.layout.activity_gallery);setTitle("Gallery 예제");int[] posters={R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,R.drawable.mov05};ImageView large=findViewById(R.id.image);large.setImageResource(posters[0]);Gallery gallery=findViewById(R.id.gallery);gallery.setAdapter(new GalleryAdapter(this,posters,large));gallery.setOnItemClickListener((p,v,pos,id)->Toast.makeText(this,pos+"을 선택",Toast.LENGTH_SHORT).show());}}

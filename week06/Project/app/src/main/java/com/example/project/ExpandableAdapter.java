package com.example.project;

import android.content.Context;import android.view.*;import android.widget.*;import java.util.*;
public class ExpandableAdapter extends BaseExpandableListAdapter{
private final Context context;private final ArrayList<String> groups;private final HashMap<String,ArrayList<CustomItem>> children;
public ExpandableAdapter(Context c,ArrayList<String> g,HashMap<String,ArrayList<CustomItem>> i){context=c;groups=g;children=i;}
@Override public int getGroupCount(){return groups.size();}@Override public int getChildrenCount(int g){return children.get(groups.get(g)).size();}@Override public String getGroup(int g){return groups.get(g);}@Override public CustomItem getChild(int g,int c){return children.get(groups.get(g)).get(c);}@Override public long getGroupId(int g){return g;}@Override public long getChildId(int g,int c){return c;}@Override public boolean hasStableIds(){return false;}@Override public boolean isChildSelectable(int g,int c){return true;}
@Override public View getGroupView(int g,boolean expanded,View old,ViewGroup parent){View v=old==null?LayoutInflater.from(context).inflate(R.layout.group_listview,parent,false):old;((TextView)v.findViewById(R.id.textView)).setText(groups.get(g));return v;}
@Override public View getChildView(int g,int c,boolean last,View old,ViewGroup parent){View v=old==null?LayoutInflater.from(context).inflate(R.layout.child_listview,parent,false):old;CustomItem i=getChild(g,c);((ImageView)v.findViewById(R.id.imageView)).setImageResource(i.getImage());((TextView)v.findViewById(R.id.textView)).setText(i.getName());return v;}}

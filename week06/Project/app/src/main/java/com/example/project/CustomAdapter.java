package com.example.project;

import android.content.*;import android.view.*;import android.widget.*;import java.util.ArrayList;
public class CustomAdapter extends BaseAdapter {
private final Context context;private final ArrayList<CustomItem> items;
public CustomAdapter(Context context,ArrayList<CustomItem> items){this.context=context;this.items=items;}
@Override public int getCount(){return items.size();}@Override public CustomItem getItem(int p){return items.get(p);}@Override public long getItemId(int p){return p;}
@Override public View getView(int p,View view,ViewGroup parent){if(view==null)view=LayoutInflater.from(context).inflate(R.layout.custom_item,parent,false);
ImageView image=view.findViewById(R.id.imageView);TextView label=view.findViewById(R.id.textView);Button del=view.findViewById(R.id.button);
CustomItem item=getItem(p);image.setImageResource(item.getImage());label.setText(item.getName());
label.setOnClickListener(v->{int current=items.indexOf(item);if(current<0)return;Intent intent=new Intent(context,CustomResultActivity.class);intent.putExtra("position",current+1);intent.putExtra("fruit",item.getName());context.startActivity(intent);});
del.setOnClickListener(v->{items.remove(item);notifyDataSetChanged();});return view;}
}

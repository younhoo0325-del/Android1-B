package com.example.project;

import android.view.*;import android.widget.*;import androidx.annotation.NonNull;import androidx.recyclerview.widget.RecyclerView;import java.util.List;
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder>{
private final List<CustomItem> items;public RecyclerAdapter(List<CustomItem> items){this.items=items;}
static class Holder extends RecyclerView.ViewHolder{ImageView image;TextView name;Holder(View v){super(v);image=v.findViewById(R.id.imageView);name=v.findViewById(R.id.textView);}}
@NonNull @Override public Holder onCreateViewHolder(@NonNull ViewGroup p,int t){return new Holder(LayoutInflater.from(p.getContext()).inflate(R.layout.item_recyclerview,p,false));}
@Override public void onBindViewHolder(@NonNull Holder h,int p){CustomItem item=items.get(p);h.image.setImageResource(item.getImage());h.name.setText(item.getName());h.itemView.setOnLongClickListener(v->{int pos=h.getBindingAdapterPosition();if(pos==RecyclerView.NO_POSITION)return true;items.remove(pos);notifyItemRemoved(pos);return true;});}
@Override public int getItemCount(){return items.size();}}

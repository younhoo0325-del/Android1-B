
package com.example.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<String> countries;

    public CountryAdapter(Context context, ArrayList<String> countries) {
        this.context = context;
        this.countries = countries;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_country, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String country = countries.get(position);

        holder.txtCountry.setText(country);

        holder.itemView.setOnClickListener(v -> {
            int selectedPosition = holder.getBindingAdapterPosition();

            if (selectedPosition != RecyclerView.NO_POSITION) {
                String selectedCountry = countries.get(selectedPosition);

                Toast.makeText(
                        context,
                        selectedCountry + "에 대하여 알아보자",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtCountry;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtCountry = itemView.findViewById(R.id.txtCountry);
        }
    }
}

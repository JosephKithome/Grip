package com.example.grip.models;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.grip.R;

import java.util.List;

public class RecyclerAdapter  extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<CountryData> countryDataList;
    Context context;

    public RecyclerAdapter(List<CountryData> countryDataList,Context context) {
        this.countryDataList = countryDataList;
        this.context = context;
    }
    public void setCountryDataList(List<CountryData> countryData) {
        this.countryDataList = countryData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view  = LayoutInflater.from(parent.getContext())
                 .inflate(R.layout.item_row,parent,false);
        return new RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
        CountryData data =countryDataList.get(position);
        holder.name.setText(data.name);
        holder.capital.setText(data.capital);
        holder.region.setText(data.region);
        holder.subregion.setText(data.subregion);
        holder.borders.setText(data.borders.toString());
        holder.languages.setText(data.languages.toString());
        holder.population.setText(data.population);

        Glide.with(context)
                .load(data.flag)
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return countryDataList.size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        private TextView name,capital,region, subregion,borders,languages, population;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            capital = itemView.findViewById(R.id.capital);
            region = itemView.findViewById(R.id.region);
            subregion = itemView.findViewById(R.id.subregion);
            borders = itemView.findViewById(R.id.borders);
            languages = itemView.findViewById(R.id.languages);
            population = itemView.findViewById(R.id.population);
            imageView = itemView.findViewById(R.id.flag);
        }
    }
    public  void addImageCount(List<CountryData> countryData){
        for (CountryData cdata : countryData){
            countryDataList.add(cdata);

        }

    }
}

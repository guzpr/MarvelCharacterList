package com.aegishield.prase.belajarandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class HeroesGridAdapter extends RecyclerView.Adapter<HeroesGridAdapter.GridViewHolder> {

    private Context context;
    private ArrayList<Heroes> listHeroes;

    HeroesGridAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_heroes, parent, false);
        return new GridViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int i) {
        Glide.with(context)
                .load(getListHeroes().get(i).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.heroPhoto);
    }

    @Override
    public int getItemCount() {
        return getListHeroes().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView heroPhoto;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            heroPhoto = itemView.findViewById(R.id.hero_photo);

        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Heroes> getListHeroes() {
        return listHeroes;
    }

    public void setListHeroes(ArrayList<Heroes> listHeroes) {
        this.listHeroes = listHeroes;
    }

}

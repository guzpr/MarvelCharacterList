package com.aegishield.prase.belajarandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListHeroesAdapter extends RecyclerView.Adapter<ListHeroesAdapter.CategoryViewHolder>   {

    private Context context;

    ListHeroesAdapter(Context context){
        this.context = context;
    }




    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Heroes> getHeroesList() {
        return heroesList;
    }

    public void setHeroesList(ArrayList<Heroes> heroesList) {
        this.heroesList = heroesList;
    }

    private ArrayList<Heroes> heroesList;

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_heroes,
                viewGroup, false);

        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.name.setText(getHeroesList().get(i).getName());
        categoryViewHolder.realName.setText(getHeroesList().get(i).getRealName());
        Glide.with(context)
                .load(getHeroesList().get(i).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.heroImage);
    }

    @Override
    public int getItemCount() {
        return getHeroesList().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView  name;
        TextView  realName;
        TextView  affiliation;
        TextView power;
        ImageView heroImage;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.hero_name);
            realName = itemView.findViewById(R.id.hero_realname);
            heroImage = itemView.findViewById(R.id.img_item_photo);
        }
    }
}

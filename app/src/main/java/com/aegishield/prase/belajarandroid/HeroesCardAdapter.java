package com.aegishield.prase.belajarandroid;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class HeroesCardAdapter extends RecyclerView.Adapter<HeroesCardAdapter.CardViewViewHolder>{

    private Context context;
    private ArrayList<Heroes> listHeroes;

    HeroesCardAdapter(Context context){
        this.context = context;
    }
    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_hero, viewGroup, false);
        return new CardViewViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, int i) {

        Heroes hero = getListHeroes().get(i);

        Glide.with(context)
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(cardViewViewHolder.heroPhoto);

        cardViewViewHolder.name.setText(hero.getName());
        cardViewViewHolder.realName.setText(hero.getRealName());
        cardViewViewHolder.affiliation.setText("Affiliation : " + hero.getAffiliation());
        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getListHeroes().get(position).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        }));
    }
    @Override
    public int getItemCount() {
        return listHeroes.size();
    }
    public class CardViewViewHolder extends RecyclerView.ViewHolder {
        ImageView heroPhoto;
        TextView name, realName,affiliation;
        Button btnFavorite;

        public CardViewViewHolder(@NonNull View itemView) {
            super(itemView);
            heroPhoto = itemView.findViewById(R.id.hero_photo);
            name = itemView.findViewById(R.id.hero_name);
            realName = itemView.findViewById(R.id.hero_realName);
            affiliation = itemView.findViewById(R.id.hero_affiliation);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
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

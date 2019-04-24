package com.aegishield.prase.belajarandroid;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity   extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_hero);

        getIncomingIntent(this);
    }

    private void getIncomingIntent(Context context) {
        if (getIntent().hasExtra("name") && getIntent().hasExtra("photo") && getIntent().hasExtra(
                "logo") && getIntent().hasExtra("realName") && getIntent().hasExtra("power") ){

            String Name = getIntent().getStringExtra("name");
            String Photo = getIntent().getStringExtra("photo");
            String Logo = getIntent().getStringExtra("logo");
            String RealName = getIntent().getStringExtra("realName");
            String Power = getIntent().getStringExtra("power");
            
            setData(Name,Photo,Logo,RealName,Power,context);
        }
    }

    private void setData(String name, String photo, String logo, String realName, String power,
                         Context context) {
        TextView heroName = findViewById(R.id.hero_name);
        heroName.setText(name);

        TextView heroRealName = findViewById(R.id.hero_realName);
        heroRealName.setText(realName);

        TextView heroPower = findViewById(R.id.hero_power);
        heroPower.setText("Power : " + power);

        ImageView heroPhoto = findViewById(R.id.hero_photo);
        ImageView heroLogo = findViewById(R.id.hero_logo);

        Glide.with(context)
                .load(photo)
                .apply(new RequestOptions().override(350, 550))
                .into(heroPhoto);

        Glide.with(context)
                .load(logo)
                .apply(new RequestOptions().override(350, 550))
                .into(heroLogo);
    }
}

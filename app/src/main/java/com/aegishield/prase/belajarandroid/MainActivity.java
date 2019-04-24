package com.aegishield.prase.belajarandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHero;
    private ArrayList<Heroes> list = new ArrayList<>();
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvHero = findViewById(R.id.rv_category);
        rvHero.setHasFixedSize(true);

        list = new ArrayList<>();

        if (savedInstanceState == null) {
            setActionBarTitle("Mode List");
            list.addAll(HeroesData.getListData());
            showRecyclerList();
            mode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Heroes> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            list.addAll(stateList);
            setMode(stateMode);
        }
    }

    private void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode){
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;
            case R.id.action_grid:
                title="Mode Grid";
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                title="Mode Card View";
                showRecyclerCardView();
                break;
        }

        mode = selectedMode;
        setActionBarTitle(title);

    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(String.format("Marvel Heroes List (%s)",title));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerList(){
        rvHero.setLayoutManager(new LinearLayoutManager(this));
        ListHeroesAdapter  listHeroAdapter = new ListHeroesAdapter(this);
        ShowDetailOnClick.addTo(rvHero).setOnItemClickListener(new ShowDetailOnClick.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedHero(list.get(position));
            }
        });
        listHeroAdapter.setHeroesList(list);
        rvHero.setAdapter(listHeroAdapter);
    }

    private void showRecyclerGrid(){
        rvHero.setLayoutManager(new GridLayoutManager(this, 3));
        HeroesGridAdapter gridPresidentAdapter = new HeroesGridAdapter(this);
        gridPresidentAdapter.setListHeroes(list);
        rvHero.setAdapter(gridPresidentAdapter);
    }

    private void showRecyclerCardView(){
        rvHero.setLayoutManager(new LinearLayoutManager(this));
        HeroesCardAdapter cardViewPresidentAdapter = new HeroesCardAdapter(this);
        cardViewPresidentAdapter.setListHeroes(list);
        rvHero.setAdapter(cardViewPresidentAdapter);
    }

    private void showSelectedHero(Heroes hero){
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("name",hero.getName());
        intent.putExtra("photo",hero.getPhoto());
        intent.putExtra("logo",hero.getLogo());
        intent.putExtra("realName",hero.getRealName());
        intent.putExtra("power",hero.getPower());
        this.startActivity(intent);
    }



}

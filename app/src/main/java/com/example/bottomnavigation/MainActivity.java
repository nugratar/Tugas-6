package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private Map<Integer, Fragment> fragmentMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        fragmentMap = new HashMap<>();
    }

    @Override
    protected void onStart() {
        super.onStart();
        fragmentMap.put(R.id.menu_movie, MovieFragment.newInstance());
        fragmentMap.put(R.id.menu_tvshow, TvShowFragment.newInstance());
        fragmentMap.put(R.id.menu_favorite, FavoriteFragment.newInstance());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.menu_movie);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = fragmentMap.get(item.getItemId());
        assert fragment != null;
        switch (item.getItemId()) {
            case R.id.menu_movie:
                setActionBarTitle("Movies");
                fragment = new MovieFragment();
                break;
            case R.id.menu_tvshow:
                setActionBarTitle("TV Show");
                fragment = new TvShowFragment();
                break;
            case R.id.menu_favorite:
                setActionBarTitle("Favorite");
                fragment = new FavoriteFragment();
                break;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();
        return true;
    }

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }
}
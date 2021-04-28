package com.example.bottomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private Movies movies;
    private TextView tvName;
    private TextView tvReleaseDate;
    private TextView tvPlot;
    private ImageView ivPoster;

    public static String detailMovie = "MOVIE_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvName = findViewById(R.id.tv_name);
        tvReleaseDate = findViewById(R.id.tv_releaseDate);
        tvPlot = findViewById(R.id.tv_plot);
        ivPoster = findViewById(R.id.iv_poster);
    }

    @Override
    protected void onStart() {
        super.onStart();
        movies = getIntent().getParcelableExtra(detailMovie);
        tvName.setText(movies.getName());
        tvReleaseDate.setText(movies.getReleaseDate());
        tvPlot.setText(movies.getPlot());
        ivPoster.setImageResource(movies.getPoster());
        getSupportActionBar().setTitle(movies.getName());
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
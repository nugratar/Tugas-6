package com.example.bottomnavigation;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MovieFragment extends Fragment implements OnItemClickListener<Movies> {

    private RecyclerView rvMovies;
    private ListAdapter listAdapter;

      public static MovieFragment newInstance() {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        rvMovies = view.findViewById(R.id.rv_movies);
        listAdapter = new ListAdapter();
        listAdapter.setMovies(DataSource.getListData());
        rvMovies.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvMovies.setHasFixedSize(true);
        listAdapter.setClickListener(this);
        rvMovies.setAdapter(listAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(Movies movies) {
        Intent m = new Intent(getActivity(), DetailActivity.class);
        m.putExtra(DetailActivity.detailMovie, movies);
//        m.putExtra("movies", movies);
        startActivity(m);
    }
}
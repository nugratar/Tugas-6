package com.example.bottomnavigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Movies> listMovies;
    private OnItemClickListener<Movies> clickListener;

    public void setClickListener(OnItemClickListener<Movies> clickListener) {
        this.clickListener = clickListener;
    }

    public void setMovies(ArrayList<Movies> movies) {
        this.listMovies = movies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_movies, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(listMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Movies movies;
        TextView tvName;
        TextView tvReleaseDate;
        TextView tvPlot;
        ImageView ivPoster;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvName = itemView.findViewById(R.id.tv_name);
            tvReleaseDate = itemView.findViewById(R.id.tv_releaseDate);
            tvPlot = itemView.findViewById(R.id.tv_plot);
            ivPoster = itemView.findViewById(R.id.iv_poster);
        }

        public void onBind(Movies movies) {
            this.movies = movies;
            tvName.setText(movies.getName());
            tvReleaseDate.setText(movies.getReleaseDate());
            tvPlot.setText(movies.getPlot());
            ivPoster.setImageResource(movies.getPoster());
        }

        public void onClick(View view) {
            clickListener.onClick(movies);
        }
    }
}

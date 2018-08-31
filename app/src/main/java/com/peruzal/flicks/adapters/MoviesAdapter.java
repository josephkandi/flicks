package com.peruzal.flicks.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.peruzal.flicks.R;
import com.peruzal.flicks.models.Movie;
import com.peruzal.flicks.viewHolders.MovieViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    List<Movie> mMovies = new ArrayList<>();

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie, viewGroup, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder movieViewHolder, int position) {
        Movie movie = mMovies.get(position);

        movieViewHolder.tvTitle.setText(movie.title);
        movieViewHolder.rtRating.setRating(movie.rating.floatValue());
        movieViewHolder.tvReleaseYear.setText(movie.releaseYear);
        movieViewHolder.tvGenre.setText(movie.genre.toString());

        Picasso.get().load(movie.image.url)
                .placeholder(R.mipmap.ic_launcher)
                .into(movieViewHolder.imgPosterImage);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    public void setData(List<Movie> movies){
        mMovies.clear();
        mMovies.addAll(movies);
        notifyDataSetChanged();
    }
}

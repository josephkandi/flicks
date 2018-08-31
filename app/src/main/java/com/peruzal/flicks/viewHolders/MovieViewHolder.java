package com.peruzal.flicks.viewHolders;

import android.media.Rating;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.peruzal.flicks.R;

public class MovieViewHolder extends RecyclerView.ViewHolder {
    public TextView tvTitle;
    public TextView tvGenre;
    public TextView tvReleaseYear;
    public RatingBar rtRating;
    public ImageView imgPosterImage;


    public MovieViewHolder(@NonNull View itemView) {
        super(itemView);

        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvGenre = itemView.findViewById(R.id.tvGenre);
        tvReleaseYear = itemView.findViewById(R.id.tvReleaseYear);
        rtRating = itemView.findViewById(R.id.rtRating);
        imgPosterImage = itemView.findViewById(R.id.posterImage);
    }
}

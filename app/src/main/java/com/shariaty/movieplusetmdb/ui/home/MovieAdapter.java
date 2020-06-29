package com.shariaty.movieplusetmdb.ui.home;


import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.shariaty.movieplusetmdb.R;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    List<Movie> movies;
    Context context;
    static MovieItemClickListener movieItemClickListener;


    public MovieAdapter(List<Movie> movies, Context context, MovieItemClickListener mListener) {
        this.movies = movies;
        this.context = context;
        this.movieItemClickListener = mListener;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_move, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.mTitle.setText(movies.get(position).getTitle());
        holder.mYear.setText(movies.get(position).getYear());
        Glide.with(context).load(movies.get(position).getThumbnail())
                .centerCrop()
                .placeholder(R.drawable.logo)
                .into(holder.imgThumbnail);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTitle, mYear;
        ImageView imgThumbnail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = (TextView) itemView.findViewById(R.id.movie_title);
            mYear = (TextView) itemView.findViewById(R.id.movie_year);
            imgThumbnail = (ImageView) itemView.findViewById(R.id.img_movie);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //When the items are clicked, it passes the item to the onMoveClick method
                    movieItemClickListener.onClickItem(movies.get(getAdapterPosition()), imgThumbnail);
                }
            });
        }

    }
}

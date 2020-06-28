package com.shariaty.movieplusetmdb.ui.home;


import android.content.Context;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
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

    private List<Movie> movies;
    private Context context;


    public MovieAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_move,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mTitle.setText(movies.get(position).getTitle());
        holder.mYear.setText(movies.get(position).getYear());
        Glide.with(context).load(movies.get(position).getThumbnail())
                .centerCrop()
                .placeholder(R.drawable.logo)
                .into(holder.imgThumbnail);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    public int getItemCount() {
        return movies.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView mTitle,mYear;
        ImageView imgThumbnail;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle=(TextView)itemView.findViewById(R.id.movie_title);
            mYear=(TextView)itemView.findViewById(R.id.movie_year);
            imgThumbnail=(ImageView) itemView.findViewById(R.id.img_movie);
            cardView=(CardView) itemView.findViewById(R.id.card_view);
        }
    }
}

package com.shariaty.movieplusetmdb.ui.home;
//Create an interface class to define program rules
import android.widget.ImageView;

public interface MovieItemClickListener {
    //Need an ImageView to share information between two fragments
    void onClickItem(Movie movie,ImageView imageView);
}

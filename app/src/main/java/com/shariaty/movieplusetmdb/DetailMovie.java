package com.shariaty.movieplusetmdb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailMovie extends AppCompatActivity {

    TextView tvTitle,tvYear,tvDetail;
    ImageView imgThumbnail,imgCover;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);


        tvTitle=(TextView)findViewById(R.id.movie_Dtitle);
        tvYear=(TextView)findViewById(R.id.movie_Dyear);
        tvDetail=(TextView)findViewById(R.id.movie_Detail);
        imgThumbnail=(ImageView) findViewById(R.id.img_Thumbnail);
        imgCover=(ImageView) findViewById(R.id.img_cover);

        Intent intent=getIntent();
        String title=intent.getExtras().getString("title");
        String year=intent.getExtras().getString("year");
        String detail=intent.getExtras().getString("overview");
        String thumbnail=intent.getExtras().getString("imgThumbnail");
        String cover=intent.getExtras().getString("imgCover");

        getSupportActionBar().setTitle(title);
        //set
        tvTitle.setText(title);
        tvYear.setText(year);
        tvDetail.setText(detail);
        Glide.with(this).load(thumbnail).centerCrop().placeholder(R.drawable.logo).into(imgThumbnail);
        Glide.with(this).load(cover).centerCrop().placeholder(R.drawable.logo).into(imgCover);
    }
}
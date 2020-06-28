package com.shariaty.movieplusetmdb.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.shariaty.movieplusetmdb.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment {

     RecyclerView rvPapularMovie;
     RecyclerView rvNowPlaying;
     RecyclerView rvTopReted;
     ProgressBar progressBar;
     List<Movie> movieList;
     String partOfMovieURL;
     String URL;
     String imgURL="https://image.tmdb.org/t/p/w500/";
     String siteURL="https://api.themoviedb.org/3/movie/";
     String APIKey="?api_key=f0af1eac62e3efe5aeacec8754208a6e";
     RequestQueue requestQueue;
     static final String TAG = MovieFragment.class.getSimpleName();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        rvPapularMovie = root.findViewById(R.id.rv_papular_movie);
        rvNowPlaying = root.findViewById(R.id.rv_NowPlaying);
        rvTopReted = root.findViewById(R.id.rv_papular_movie);
        progressBar=root.findViewById(R.id.progressBar);
        rvPapularMovie.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rvNowPlaying.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rvTopReted.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        getDataPapularMovie();
        getDataNowPlaying();
        getDataNowPlaying();
        return root;
    }


    private void ShowRvPapularMovie() {
        //Show Recyclerview
        MovieAdapter movieAdapter=new MovieAdapter(movieList,getActivity());
        rvPapularMovie.setAdapter(movieAdapter);
    }
    private void ShowRvNowPlaying() {
        //Show Recyclerview
        MovieAdapter movieAdapter=new MovieAdapter(movieList,getActivity());
        rvNowPlaying.setAdapter(movieAdapter);
    }
    private void ShowRvTopReted() {
        //Show Recyclerview
        MovieAdapter movieAdapter=new MovieAdapter(movieList,getActivity());
        rvTopReted.setAdapter(movieAdapter);
    }

    public void getDataPapularMovie() {
        movieList = new ArrayList<>();
        partOfMovieURL = "popular";
        URL = siteURL + partOfMovieURL + APIKey;
        requestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response != null) {
                    progressBar.setVisibility(View.GONE);
                    try {
                        JSONArray jsonArray = response.getJSONArray("results");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject results = jsonArray.getJSONObject(i);
                                String title = results.getString("title");
                                String year = results.getString("release_date");
                                String thumbnail = results.getString("poster_path");
                                String description = results.getString("overview");
                                String coverPhoto = results.getString("backdrop_path");
                                movieList.add(new Movie(title, year, description, imgURL + thumbnail + APIKey, imgURL + thumbnail + APIKey, imgURL + coverPhoto + APIKey));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        ShowRvPapularMovie();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.VISIBLE);
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }



    public void getDataNowPlaying() {
        movieList = new ArrayList<>();
        partOfMovieURL = "popular";
        URL = siteURL + partOfMovieURL + APIKey;
        requestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response != null) {
                    progressBar.setVisibility(View.GONE);
                    try {
                        JSONArray jsonArray = response.getJSONArray("results");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject results = jsonArray.getJSONObject(i);
                                String title = results.getString("title");
                                String year = results.getString("release_date");
                                String thumbnail = results.getString("poster_path");
                                String description = results.getString("overview");
                                String coverPhoto = results.getString("backdrop_path");
                                movieList.add(new Movie(title, year, description, imgURL + thumbnail + APIKey, imgURL + thumbnail + APIKey, imgURL + coverPhoto + APIKey));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        ShowRvNowPlaying();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.VISIBLE);
                error.printStackTrace();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
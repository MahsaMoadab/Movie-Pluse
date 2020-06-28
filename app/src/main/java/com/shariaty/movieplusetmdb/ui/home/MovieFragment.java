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
     ProgressBar progressBar;
     List<Movie> movieListPapular;
    List<Movie> movieListNow;
     String partOfMovieURL;
     String URL;
     String imgURL="https://image.tmdb.org/t/p/w500/";
     String siteURL="https://api.themoviedb.org/3/movie/";
     String APIKey="?api_key=f0af1eac62e3efe5aeacec8754208a6e";
     RequestQueue requestQueue;
     String title;
     String year;
     String thumbnail;
     String description;
     String coverPhoto;
     static final String TAG = MovieFragment.class.getSimpleName();


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        rvPapularMovie = root.findViewById(R.id.rv_papular_movie);
        rvNowPlaying=root.findViewById(R.id.rv_Now_Playing);
        progressBar=root.findViewById(R.id.progressBar);
        rvPapularMovie.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        rvNowPlaying.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        requestQueue = Volley.newRequestQueue(getActivity());
        getDataNowPlaying();
        getDataPapularMovie();
        return root;
    }







    private void ShowRvNowPlaying() {
        //Show Recyclerview
        MovieAdapter movieAdapter=new MovieAdapter(movieListNow,getActivity());
        rvNowPlaying.setAdapter(movieAdapter);
    }

    private void getDataNowPlaying() {
        movieListNow = new ArrayList<>();
        partOfMovieURL = "now_playing";
        URL = siteURL + partOfMovieURL + APIKey;

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
                                 title = results.getString("title");
                                 year = results.getString("release_date");
                                 thumbnail = results.getString("poster_path");
                                 description = results.getString("overview");
                                 coverPhoto = results.getString("backdrop_path");
                                movieListNow.add(new Movie(title, year, description, imgURL + thumbnail + APIKey, imgURL + thumbnail + APIKey, imgURL + coverPhoto + APIKey));
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

    private void ShowRvPapularMovie() {
        //Show Recyclerview
        MovieAdapter movieAdapter=new MovieAdapter(movieListPapular,getActivity());
        rvPapularMovie.setAdapter(movieAdapter);
    }
    public void getDataPapularMovie() {
        movieListPapular = new ArrayList<>();
        partOfMovieURL = "popular";
        URL = siteURL + partOfMovieURL + APIKey;

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
                                 title = results.getString("title");
                                 year = results.getString("release_date");
                                 thumbnail = results.getString("poster_path");
                                 description = results.getString("overview");
                                 coverPhoto = results.getString("backdrop_path");
                                movieListPapular.add(new Movie(title, year, description, imgURL + thumbnail + APIKey, imgURL + thumbnail + APIKey, imgURL + coverPhoto + APIKey));
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

}
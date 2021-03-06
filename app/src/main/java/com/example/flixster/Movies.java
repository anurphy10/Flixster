package com.example.flixster;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movies {

    int movieId;
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;

    public Movies() {}

    public Movies(JSONObject jsonObject) throws JSONException {
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath =jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
        movieId = jsonObject.getInt("id");
    }

    public static List<Movies> fromJsonArray(JSONArray moviesJsonArray) throws JSONException {
        List<Movies> movie = new ArrayList<>();
        for (int i = 0; i < moviesJsonArray.length(); i++){
            movie.add(new Movies(moviesJsonArray.optJSONObject(i)));
        }
        return movie;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }
}
package models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movies {

    String posterPath;
    String title;
    String overview;

    public Movies(JSONObject jsonObject) throws JSONException {

        posterPath =jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
    }

    public static List<Movies> fromJsonArray(JSONArray moviesJsonArray) throws JSONException {
        List<Movies> movie = new ArrayList<>();
        for (int i = 0; i < moviesJsonArray.length(); i++){
            movie.add(new Movies(moviesJsonArray.optJSONObject(i)));
        }
        return movie;
    }
}

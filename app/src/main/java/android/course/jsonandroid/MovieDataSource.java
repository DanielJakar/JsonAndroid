package android.course.jsonandroid;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Jakars on 16/05/2017.
 */

public class MovieDataSource {
    public interface OnDataArrivedListener{
        void onDataArrived(ArrayList<Movie> movies, Exception e);
    }
    public static void getMovies (final OnDataArrivedListener listener) {
        Thread movieThread = new Thread(new Runnable() {
            @Override
            public void run() {




                //code that runs in the
                try {
                    String json = StreamIO.readWebSite("http://api.androidhive.info/json/movies.json");
                    ArrayList<Movie> movies = parse(json);
                    listener.onDataArrived(movies, null);
                }catch (IOException | JSONException e){


                    listener.onDataArrived(null, e);

                }

            }
        });
        movieThread.start();
    };





    private static ArrayList<Movie> parse (String json) throws JSONException {
        ArrayList<Movie> movies = new ArrayList<>();
        JSONArray moviesArray = new JSONArray(json);
        for (int i = 0; i < moviesArray.length(); i++) {
        ArrayList<String> genres = new ArrayList<String>();
        JSONObject moviesObject = moviesArray.getJSONObject(i);
        String title = moviesObject.getString("title");
        String image = moviesObject.getString("image");
        int releaseYear = moviesObject.getInt("releaseYear");
        double rating = moviesObject.getDouble("rating");
        JSONArray genreArray = moviesObject.getJSONArray("genre");
        for (int j = 0; j < genreArray.length(); j++) {
        String genre = genreArray.getString(j);
        genres.add(genre + "\n");
        }
        Movie movie = new Movie(title, image, genres, releaseYear,rating);
        movies.add(movie);
        }

        return movies;
    }
}




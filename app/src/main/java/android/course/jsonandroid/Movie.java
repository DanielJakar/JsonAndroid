package android.course.jsonandroid;

import java.util.ArrayList;

/**
 * Created by Jakars on 16/05/2017.
 */

public class Movie {
    private final String title;
    private final String image;
    private final ArrayList<String> genre;
    private final int releaseYear;
    private final double rating;

    public Movie(String title, String image, ArrayList<String> genre, int releaseYear, double rating) {
        this.title = title;
        this.image = image;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    //getters only

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public double getRating() {
        return rating;
    }
    //toStrin()

    @Override
    public String toString() {
        return "Movie title:'" + title + '\'' +
                ", image:'" + image + '\'' +
                ", releaseYear: " + releaseYear +
                ", rating: " + rating +
                ", genres: " + genre ;
    }


    //var -args
    //Syntactic sugar
//    private void print (String... data){
//        String[] data1 = data;
//
//    }
}


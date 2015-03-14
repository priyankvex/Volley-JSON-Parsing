package com.wordpress.priyankvex.volleytest;

/**
 * Created by priyank on 13/3/15.
 * Storage class to hold the data related to a movie.
 */
public class Movie {

    private String title;
    private String rating;
    private String thumbnailUrl;
    private String synopsis;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
}

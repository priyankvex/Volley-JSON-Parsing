package com.wordpress.priyankvex.volleytest;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by priyank on 14/3/15.
 * Class to manage all the network calls using Volley library.
 * It provides methods to make network calls.
 * Different methods each configured to fetch and parse the data of a different type.
 */
public class NetworkCallsManager {

    // URL of the JSON data of blockbusters
    private final String urlBlockBusters = "http://api.rottentomatoes.com/api/public/v1.0/lists/movies/box_office.json?apikey=wwdcawjcq8zufaznn3hpnhqt&limit=10";

    // Utility function to fetch and parse the JSON data of blockbusters provided by the API.
    // Returns a list of Movie objects.
    public ArrayList<Movie> getBlockBusters(final VolleyCallBack callback){

        // ArrayList to store all the movie objects.
        final ArrayList<Movie> blockBusterMovies = new ArrayList<>();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                urlBlockBusters, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        // Response is the JSON data returned from the API
                        // Now we need to get the data out the response
                        // We should be aware of the structure of the response to parse it.
                        try {
                            JSONArray moviesJsonArray = response.getJSONArray("movies");
                            for (int i = 0; i < moviesJsonArray.length(); i++){
                                // Here each JSONObject is a movie data with a complex JSON structure.
                                // Which is needed to be further processed to get data.
                                JSONObject obj = moviesJsonArray.getJSONObject(i);
                                String title = obj.getString("title");
                                String rating = obj.getJSONObject("ratings").getString("critics_rating");
                                String synopsis = obj.getString("synopsis");
                                String thumbnailUrl = obj.getJSONObject("posters").getString("thumbnail");
                                // Storing all the info into a movie object
                                Movie movie = new Movie();
                                movie.setTitle(title);
                                movie.setThumbnailUrl(thumbnailUrl);
                                movie.setRating(rating);
                                movie.setSynopsis(synopsis);
                                blockBusterMovies.add(movie);
                                Log.d("Volley", title);
                                Log.d("Volley", rating);
                                Log.d("Volley", synopsis);
                                Log.d("Volley", thumbnailUrl);
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        callback.onSuccess(blockBusterMovies);
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("Volley Test", "Error: " + error.getMessage());
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, "json_req");

        // Finally returning the list of movie object.
        return blockBusterMovies;
    }

}

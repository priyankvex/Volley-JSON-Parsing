package com.wordpress.priyankvex.volleytest;

import java.util.ArrayList;

/**
 * Created by priyank on 14/3/15.
 * Interface acting as the call back to the onResponse() method of the volley.
 */
public interface VolleyCallBack {
    void onSuccess(ArrayList<Movie> movies);
}

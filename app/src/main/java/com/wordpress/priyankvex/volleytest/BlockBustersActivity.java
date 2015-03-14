package com.wordpress.priyankvex.volleytest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by priyank on 14/3/15.
 * Activity to show the list of blockbusters
 */
public class BlockBustersActivity extends Activity{

    NetworkCallsManager mNetworkCallsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_busters);

        // Getting the list view
        final ListView moviesListView = (ListView) findViewById(R.id.listViewMovies);

        // Initializing the network calls object.
        mNetworkCallsManager = new NetworkCallsManager();

        // getting the block busters using the utility function of the NetworkCallsManager class.
        // It has a callback set. So that we only set the adapter to the list when we get the callback from the
        // onResponse() in the NetworkCallsManager class.
        mNetworkCallsManager.getBlockBusters(new VolleyCallBack() {
            @Override
            public void onSuccess(ArrayList<Movie> movies) {

                // Creating instance of our CustomListAdapter
                CustomListAdapter mCustomListAdapter = new CustomListAdapter(BlockBustersActivity.this, movies);

                // Attaching the list view to the adapter
                moviesListView.setAdapter(mCustomListAdapter);

            }
        });

    }
}


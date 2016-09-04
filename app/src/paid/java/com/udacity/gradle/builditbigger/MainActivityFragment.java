package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment {

    public String LOG_TAG = MainActivityFragment.class.getSimpleName();

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        mProgressBar = (ProgressBar) root.findViewById(R.id.progressBar);
        mProgressBar.setVisibility(ProgressBar.GONE);

        final Button loginButton = (Button) root.findViewById(R.id.tellJokeButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                tellJoke(v);
            }
        });

        return root;
    }

    public void tellJoke(View view) {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(ProgressBar.VISIBLE);
        }
        // Fetch joke in background and display using JokeListener
        new EndpointsAsyncTask(new MyJokeListener()).execute();
    }
}


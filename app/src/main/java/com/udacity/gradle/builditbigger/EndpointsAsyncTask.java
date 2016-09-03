package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.joke.Jokes;
import com.udacity.jokes.backend.myApi.MyApi;

import java.io.IOException;

import in.msomu.jokesdisplaylib.DisplayActivity;

/**
 * Created by msomu on 04/09/16.
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private MyApi myApiService = null;
    private Context context;
    private final JokeListener jokeListener;
    private static final String TAG = "EndpointsAsyncTask";

    public EndpointsAsyncTask(JokeListener jokeListener) {
        this.jokeListener = jokeListener;
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        }

//        context = params[0].first;
  //      String name = params[0].second;

        try {
            return myApiService.getJoke().execute().getJokeDescription();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
//        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
//        Intent jokeDisplayIntent = new Intent(MainActivity.this, DisplayActivity.class);
//        jokeDisplayIntent.putExtra(Jokes.TAG, result);
//        startActivity(jokeDisplayIntent);
        if (jokeListener != null) {
            jokeListener.jokeReceived(result);
        } else {
            Log.i(TAG, "Joke received but listener is null");
        }
    }

    public interface JokeListener {
        public void jokeReceived(String joke);
    }
}

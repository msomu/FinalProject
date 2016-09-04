package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by msomu on 04/09/16.
 * Test AsyncTask
 */
public class AsyncTaskTest extends AndroidTestCase {

    private final CountDownLatch latch = new CountDownLatch(1);
    private String jokeReceived = null;

    public void testAsyncTask() {

        EndpointsAsyncTask task = new EndpointsAsyncTask(new EndpointsAsyncTask.JokeListener() {
            public void jokeReceived(String joke) {
                jokeReceived = joke;
                latch.countDown();
            }
        });

        task.execute();

        try {
            latch.await(20, TimeUnit.SECONDS);
            assertNotNull("Joke received was null", jokeReceived);
        } catch (InterruptedException e) {
            assertTrue(false);
        }
    }
}
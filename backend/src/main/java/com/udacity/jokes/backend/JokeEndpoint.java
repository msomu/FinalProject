package com.udacity.jokes.backend;

/**
 * Created by msomu on 04/09/16.
 * EndPoint
 */

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.joke.Jokes;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myJokeApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.jokes.udacity.com",
                ownerName = "backend.jokes.udacity.com",
                packagePath = ""
        )
)
public class JokeEndpoint {

    public JokeEndpoint() {
    }

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        String jokeDescription = (new Jokes()).fetch();
        return new Joke(jokeDescription);
    }

}

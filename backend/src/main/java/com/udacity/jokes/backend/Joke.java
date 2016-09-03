package com.udacity.jokes.backend;

public class Joke {
    private String jokeDescription;

    public Joke(String jokeDescription) {
        this.jokeDescription = jokeDescription;
    }

    public String getJokeDescription() {
        return jokeDescription;
    }

    public void setJokeDescription(String jokeDescription) {
        this.jokeDescription = jokeDescription;
    }
}

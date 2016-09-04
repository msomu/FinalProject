package com.udacity.joke;

import java.util.ArrayList;

public class Jokes {
    public static final String TAG = "com.udacity.joke";
    private final int numberOfJokes;
    private ArrayList<String> jokesCollection;

    public Jokes() {
        jokesCollection = new ArrayList<>();
        jokesCollection.add("Just read that 4,153,237 people got married last year, not to cause any trouble but shouldn't that be an even number?");
        jokesCollection.add("Life is all about perspective. The sinking of the Titanic was a miracle to the lobsters in the ship's kitchen.");
        jokesCollection.add("My wife and I were happy for twenty years. Then we met.");
        jokesCollection.add("A recent study has found that women who carry a little extra weight live longer than the men who mention it.");
        jokesCollection.add("I haven't spoken to my wife for 18 months- I don't like to interrupt her.");
        jokesCollection.add("Childs experience: if a mother is laughing at the fathers jokes, it means they have guests.");
        numberOfJokes = jokesCollection.size();
    }

    public String fetch() {
        int randomJokeIndex = (int)Math.ceil((double)(this.numberOfJokes - 1) * Math.random());
        return this.jokesCollection.get(randomJokeIndex);
    }
}

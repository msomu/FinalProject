package com.udacity.gradle.builditbigger;

import com.udacity.joke.Jokes;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;

public class JokeTest {
    @Test
    public void testThatJokeShouldNotBeEqualToNull() {
        String joke = new Jokes().fetch();
        assertFalse(joke.equals(""));
    }
}

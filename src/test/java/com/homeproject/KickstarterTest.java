package com.homeproject;

import org.junit.Test;

/**
 * Created by andrey on 02.03.2016.
 */
public class KickstarterTest {

    @Test
    public void shouldWhen() {
        Categories categories = new Categories();
        Projects projects = new Projects();
        IO io = new FakeIO();
        Kickstarter kickstarter = new Kickstarter(categories, projects, io);
        kickstarter.run();
    }

    private class FakeIO implements IO {
        public void println(String message) {

        }

        public int read() {
            return 0;
        }
    }
}

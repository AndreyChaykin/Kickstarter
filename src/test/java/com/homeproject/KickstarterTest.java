package com.homeproject;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by andrey on 02.03.2016.
 */
public class KickstarterTest {

    @Test
    public void shouldWhen() {
        Categories categories = new Categories();
        Projects projects = new Projects();
        FakeIO io = new FakeIO(2, 1, 0);
        Kickstarter kickstarter = new Kickstarter(categories, projects, io);
        kickstarter.run();
        assertEquals("[Chih pih-pih, Please, select category or \"0\" for exit:, Wrong number of category, Please, " +
                "try again!, Please, select category or \"0\" for exit:, Wrong number of category, Please, try again!," +
                " Please, select category or \"0\" for exit:]", io.getMessages().toString());
    }

    private class FakeIO implements IO {
        List<String> messages = new LinkedList<String>();
        List<Integer> fakeIOConsole = new LinkedList<Integer>();

        public FakeIO(Integer... numbers) {
            fakeIOConsole = new LinkedList<Integer>(Arrays.asList(numbers));
        }

        public void println(String message) {
            messages.add(message);
        }

        public int read() {
            return fakeIOConsole.remove(0);
        }

        public List<String> getMessages() {
            return messages;
        }
    }
}

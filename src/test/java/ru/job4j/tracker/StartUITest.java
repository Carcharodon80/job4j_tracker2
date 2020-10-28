package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void createItemTest2() {
        String[] answers = {"crash", "destroy"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        Item[] createdItems = {tracker.findAll()[0], tracker.findAll()[1]};
        Item[] expectedItems = {new Item("crash"), new Item("destroy")};
        expectedItems[0].setId(1);
        expectedItems[1].setId(2);
        assertArrayEquals(createdItems, expectedItems);
    }
}
package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Replaced item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        /* Добавим в tracker новую заявку */
        Item item = tracker.add(new Item("Deleted item"));
        /* Входные данные должны содержать ID добавленной заявки item.getId() */
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new Exit()
        };
        new StartUI(out).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new Exit()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu" + System.lineSeparator()
                + "0. Exit" + System.lineSeparator()));
    }

    @Test
    public void whenShowItems() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        Tracker tracker = new Tracker();
        String ln = System.lineSeparator();
        tracker.add(new Item("New Item 1"));
        tracker.add(new Item("New Item 2"));
        UserAction[] actions = {new ShowAction(out), new Exit()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu" + ln +
                "0. Show all Items" + ln +
                "1. Exit" + ln +
                "All items:" + ln +
                "id = 1, name = New Item 1" + ln +
                "id = 2, name = New Item 2" + ln +
                "Menu" + ln +
                "0. Show all Items" + ln +
                "1. Exit" + ln));
    }

    @Test
    public void whenFindById() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1", "1"});
        Tracker tracker = new Tracker();
        String ln = System.lineSeparator();
        tracker.add(new Item("New Item"));
        UserAction[] actions = {new FindByIdAction(out), new Exit()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu" + ln +
                "0. Find Item by Id" + ln +
                "1. Exit" + ln +
                "id = 1, name = New Item" + ln +
                "Menu" + ln +
                "0. Find Item by Id" + ln +
                "1. Exit" + ln));
    }

    @Test
    public void whenFindByName() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "Fix it!", "1"});
        Tracker tracker = new Tracker();
        String ln = System.lineSeparator();
        tracker.add(new Item("Fix it!"));
        tracker.add(new Item("Fix it!"));
        UserAction[] actions = {new FindByNameAction(out), new Exit()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu" + ln +
                "0. Find Items by Name" + ln +
                "1. Exit" + ln +
                "id = 1, name = Fix it!" + ln +
                "id = 2, name = Fix it!" + ln +
                "Menu" + ln +
                "0. Find Items by Name" + ln +
                "1. Exit" + ln));
    }
}
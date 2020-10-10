package ru.job4j.tracker;

import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item("check");
        Item secondItem = new Item("erase");
        Item thirdItem = new Item("check");
        tracker.add(item);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        System.out.println(tracker.findById(3));
        System.out.println(Arrays.toString(tracker.findByName("check")));
    }
}

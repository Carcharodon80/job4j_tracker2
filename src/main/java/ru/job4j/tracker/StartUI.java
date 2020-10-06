package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("check");
        Item secondItem = new Item();
        secondItem.setName("erase");
        Item thirdItem = new Item();
        thirdItem.setName("check");
        tracker.add(item);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        System.out.println(tracker.findById(2));
    }
}

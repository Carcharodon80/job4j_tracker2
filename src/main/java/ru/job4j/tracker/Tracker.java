package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] itemsWithNames = new Item[items.length];
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                itemsWithNames[index] = items[i];
                index++;
            }
        }
        return Arrays.copyOf(itemsWithNames, index);
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int index = 0;
        for (Item item : items) {
            if (item != null) {
                itemsWithoutNull[index] = item;
                index++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, index);
    }
}
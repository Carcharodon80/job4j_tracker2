package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find Items by Name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}

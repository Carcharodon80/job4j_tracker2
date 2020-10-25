package ru.job4j.tracker;

public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select action: ");
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("All items:");
                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                int id = input.askInt("Введите id заявки: ");
                String newName = input.askStr("Введите новое имя: ");
                Item newItem = new Item(newName);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Замена произведена успешно");
                } else {
                    System.out.println("Ошибка! Заявки с таким id не найдено");
                }
            } else if (select == 3) {
                int id = input.askInt("Введите id заявки: ");
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена");
                } else {
                    System.out.println("Ошибка! Заявки с таким id не найдено");
                }
            } else if (select == 4) {
                int id = input.askInt("Введите номер заявки: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.toString());
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                String name = input.askStr("Введите имя заявки: ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Ошибка! Введите число от 0 до 6");
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}

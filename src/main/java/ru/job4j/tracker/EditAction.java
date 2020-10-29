package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите id заявки: ");
        String newName = input.askStr("Введите новое имя: ");
        Item newItem = new Item(newName);
        if (tracker.replace(id, newItem)) {
            System.out.println("Замена произведена успешно");
        } else {
            System.out.println("Ошибка! Заявки с таким id не найдено");
        }
        return true;
    }
}

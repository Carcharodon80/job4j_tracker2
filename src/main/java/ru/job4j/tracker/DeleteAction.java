package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите номер заявки: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Ошибка! Заявки с таким id не найдено");
        }
        return true;
    }
}

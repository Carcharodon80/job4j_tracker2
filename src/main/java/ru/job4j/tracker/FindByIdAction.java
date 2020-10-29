package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find Item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите id заявки: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}

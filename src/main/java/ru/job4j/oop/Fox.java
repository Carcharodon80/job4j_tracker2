package ru.job4j.oop;

public class Fox {
    public void tryEat(Ball ball) {
        System.out.println(this.getClass().getSimpleName() + " : " + ball.name + ", я тебя съем!");
    }

    public void cheat(Ball ball) {
        System.out.println(this.getClass().getSimpleName() + " : " + ball.name + ", сядь мне на носик и спой еще раз.");
    }

    public void eat(Ball ball) {
        System.out.println("И съела " + this.getClass().getSimpleName() + " " + ball.name);
    }
}

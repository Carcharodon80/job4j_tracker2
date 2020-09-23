package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        ball.name = "Колобок";
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();
        hare.tryEat(ball);
        ball.singSong();
        ball.run();
        wolf.tryEat(ball);
        ball.singSong();
        ball.run();
        fox.tryEat(ball);
        ball.singSong();
        fox.cheat(ball);
        ball.singSong();
        fox.eat(ball);
    }
}

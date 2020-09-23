package ru.job4j.oop;

public class Ball {
    String name;

    public void singSong() {
        System.out.println(this.getClass().getSimpleName() + " : " + "Я " + this.name + ", я " + this.name + "...");
    }

    public void run() {
        System.out.println("И покатился " + this.name + " дальше...");
    }
}

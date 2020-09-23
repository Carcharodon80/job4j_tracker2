package ru.job4j.oop;

public class Jukebox {
    public void music (int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
            System.out.println("Пешеходы по лужам");
            System.out.println("А вода по асфальту рекой...");
        }
        else if (position == 2) {
            System.out.println("Спят усталые игрушки, книжки спят,");
            System.out.println("Одеяла и подушки ждут ребят...");
        }
        else {
            System.out.println("Песня не найдена.");
        }
    }

    public static void main(String[] args) {
        Jukebox item = new Jukebox();
        item.music(1);
        System.out.println();
        item.music(2);
        System.out.println();
        item.music(6);
    }
}

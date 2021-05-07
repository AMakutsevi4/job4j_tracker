package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball bun = new Ball();
        Hare rabbit = new Hare();
        Wolf grey = new Wolf();
        Fox redhead = new Fox();
        bun.tryEat(bun);
        rabbit.tryEat(bun);
        grey.tryEat(bun);
        redhead.tryEat(bun);
    }
}

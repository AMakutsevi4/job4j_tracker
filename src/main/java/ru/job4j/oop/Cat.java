package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println("There are " + this.name + "'s food: " + this.food);
    }

    public void eat(String meal) {
        this.food = meal;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("meat");
        gav.show();

        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}

package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Item item1 = new Item("vasya");
        Item item2 = new Item("petya");
        tracker.add(item1);
        tracker.add(item2);
        System.out.println(tracker.findById(1));
        System.out.println(item2);
    }
}

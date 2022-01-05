package ru.job4j.tracker;

public class MemTrackerProfiling {
    public static void main(String[] args) {
        MemTracker memTracker = new MemTracker();
        for (int i = 0; ; i++) {
            Item item = new Item(i);
            item.setName("item " + i);
            memTracker.add(item);
            memTracker.delete(i);
            System.out.println(memTracker.findById(i));
        }
    }
}
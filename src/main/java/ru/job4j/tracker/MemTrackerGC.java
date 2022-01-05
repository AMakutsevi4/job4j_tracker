package ru.job4j.tracker;

public class MemTrackerGC {
    /**
     * чтобы увидеть лог сборщика в консоли, в параметрах VM options ставим флаг -Xlog:gc*
     * также для определения размера хипа нашей программы, ставим следующие флаги: -Xmx4m -Xms4m
     * Ключи для запуска:
     * - Serial => -XX:+UseSerialGC
     * - Parallel => -XX:+UseParallelGC
     * - G1 => -XX:+UseG1GC
     * - ZGC => -XX:+UseZGC
     */
    public static void main(String[] args) {
        MemTracker memTracker = new MemTracker();
        for (int i = 0; i < 2000; i++) {
            Item item = new Item(i);
            item.setId(i);
            item.setName("item - " + i);
            memTracker.add(item);
            System.gc();
        }
    }
}

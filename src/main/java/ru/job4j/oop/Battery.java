package ru.job4j.oop;

public class Battery {
    private int load;

    public Battery(int capacity) {
        this.load = capacity;
    }

    public void exchange(Battery another) {
        this.load = this.load + another.load;
        another.load = 0;
    }

    public static void main(String[] args) {
        Battery one = new Battery(1200);
        Battery two = new Battery(99555);
        System.out.println("Заряд первой батареи : " + one.load + " Заряд второй батареи : " + two.load);
        one.exchange(two);
        System.out.println("Заряд первой батареи : " + one.load + " Заряд второй батареи : " + two.load);
    }
}

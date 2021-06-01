package ru.job4j.ru.job4j.ex;

public class ElementNotFoundException extends Exception {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i <= value.length - 1; i++) {
            if (value[i].equals(key)) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException();
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] array = {"Hello", "World", "Idea", "Java"};
        try {
            System.out.println(indexOf(array, "number"));
        } catch (ElementNotFoundException e) {
            System.out.println("не существует в массиве");
            e.printStackTrace();
        }
    }
}
package ru.job4j.polymorphism;

public interface FunctionOne {

    default double function(double x, double y) {
        return x * x - 2 * y + 30;
    }

    default void functionMessage() {
        System.out.println("Сообщение из FunctionOne");
    }

    default int getDoubleSum(int[] numbers) {
        return getSum(numbers) * 2;
    }

    default double getAverage(int[] numbers) {
        return getSum(numbers) * 1.0 / numbers.length;
    }

    private int getSum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}

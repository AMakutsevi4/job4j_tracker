package ru.job4j.lambda;

import java.util.function.Supplier;

public class ScopeInside {

    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int num : number) {
            int t = add(
                    () -> total + num
            );
            System.out.println(t);
        }
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}

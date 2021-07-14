package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvMatrixToList {
    public static List<Integer> twoArrays(Integer[][] twoArrays) {
        return Arrays.stream(twoArrays)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}

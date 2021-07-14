package ru.job4j.stream;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class ConvMatrixToListTest {
    @Test
    public void whenMatrixThenList() {
        Integer[][] arrays = {{1, 2, 3},
                {4, 5, 6}};
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        assertThat(ConvMatrixToList.twoArrays(arrays), is(expected));
    }
}
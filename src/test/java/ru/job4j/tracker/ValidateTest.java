package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.Validate;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateTest {

    @Test
    public void whenInvalidInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"one", "1"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));

    }

    @Test
    public void whenCorrectInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"0", "1"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));

    }

    @Test
    public void whenMultipleCorrectInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"1", "4", "36"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1, is(4));
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2, is(36));
    }

    @Test
    public void whenNegativeNumberInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[]{"-2", "1"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-2));
    }
}
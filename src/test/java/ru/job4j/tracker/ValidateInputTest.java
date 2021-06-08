package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));

    }

    @Test
    public void whenCorrectInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));

    }

    @Test
    public void whenMultipleCorrectInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"1", "4", "36"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
        int selected1 = input.askInt("Enter menu:");
        assertThat(selected1, is(4));
        int selected2 = input.askInt("Enter menu:");
        assertThat(selected2, is(36));
    }

    @Test
    public void whenNegativeNumberInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-2", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(-2));
    }
}
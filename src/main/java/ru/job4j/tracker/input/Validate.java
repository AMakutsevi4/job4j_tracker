package ru.job4j.tracker.input;

import ru.job4j.tracker.output.Output;

public class Validate implements Input {

    private final Output out;
    private final Input in;

    public Validate(Output out, Input input) {
        this.out = out;
        this.in = input;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Пожалуйста, введите данные для подтверждения еще раз.");
            }
        } while (invalid);
        return value;
    }
}
package ru.job4j.hashmap;

import java.util.Objects;

public final class Subject {
    private final String name;
    private final int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String name() {
        return name;
    }

    public int score() {
        return score;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Subject) obj;
        return Objects.equals(this.name, that.name)
                && this.score == that.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public String toString() {
        return "Subject["
                + "name=" + name + ", "
                + "score=" + score + ']';
    }

}

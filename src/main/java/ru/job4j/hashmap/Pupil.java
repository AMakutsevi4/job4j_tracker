package ru.job4j.hashmap;

import java.util.List;
import java.util.Objects;

public final class Pupil {
    private final String name;
    private final List<Subject> subjects;

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String name() {
        return name;
    }

    public List<Subject> subjects() {
        return subjects;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Pupil) obj;
        return Objects.equals(this.name, that.name)
                && Objects.equals(this.subjects, that.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subjects);
    }

    @Override
    public String toString() {
        return "Pupil["
                + "name=" + name + ", "
                + "subjects=" + subjects + ']';
    }

}
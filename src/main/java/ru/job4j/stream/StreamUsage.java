package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private final int number;

        public Task(int number) {
            this.number = number;

        }

        @Override
        public String toString() {
            return "Task{"
                    + "number='" + number
                    + '}';
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task(1),
                new Task(-2),
                new Task(3),
                new Task(5)
        );
        List<Task> bugs = tasks.stream().filter(
                task -> task.number > 0
        ).collect(Collectors.toList());
        bugs.forEach(System.out::println);
    }
}
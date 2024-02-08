package ru.job4j.queue;

import java.util.Objects;

public final class Task {
    private final Position position;
    private final String description;
    private final int urgency;

    public Task(Position position,
                String description,
                int urgency) {
        this.position = position;
        this.description = description;
        this.urgency = urgency;
    }

    public Position position() {
        return position;
    }

    public String description() {
        return description;
    }

    public int urgency() {
        return urgency;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Task) obj;
        return Objects.equals(this.position, that.position)
                && Objects.equals(this.description, that.description)
                && this.urgency == that.urgency;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, description, urgency);
    }

    @Override
    public String toString() {
        return "Task["
                + "position=" + position + ", "
                + "description=" + description + ", "
                + "urgency=" + urgency + ']';
    }

}

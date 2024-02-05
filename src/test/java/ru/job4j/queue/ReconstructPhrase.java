package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    private final StringBuilder builder = new StringBuilder();

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private void getEvenElements() {
        int last = evenElements.size();
        int index = 0;
        for (Character c : evenElements) {
            if (index % 2 == 0 && index < last) {
                builder.append(c);
            }
            index++;
        }
     }

    private String getDescendingElements() {
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            builder.append(descendingElements.pollLast());
        }
        return builder.toString();
    }

    public String getReconstructPhrase() {
        getEvenElements();
        return getDescendingElements();
    }
}
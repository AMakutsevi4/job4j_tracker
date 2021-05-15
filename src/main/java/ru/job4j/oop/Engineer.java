package ru.job4j.oop;

public class Engineer extends Profession {
    private int experience;
    private boolean speakEnglish;

    public Engineer(String name, String surname, String education, String birthday, int experience, boolean speakEnglish) {
        super(name, surname, education, birthday);
        this.experience = experience;
        this.speakEnglish = false;
    }

    public static void main(String[] args) {
        Engineer engineer = new Engineer("s", "s", "s", "s", 4, true);
    }
}
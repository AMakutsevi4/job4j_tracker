package ru.job4j.oop;

public class Builder extends Engineer {
    private String speciality;

    public Builder(String name, String surname, String education, String birthday, int experience, boolean speakEnglish, String speciality) {
        super(name, surname, education, birthday, experience, speakEnglish);
        this.speciality = speciality;
    }

    public static void main(String[] args) {
        Builder builder = new Builder("Alex", "Popov", "2 category", "12.12.1212", 8, true, "Test pilot");
    }
}

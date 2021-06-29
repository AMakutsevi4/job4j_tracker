package ru.job4j.oop;

public class Doctor extends Profession {
    private boolean abilityToOppose;
    private boolean speakEnglish;

    public Doctor(String name, String surname, String education,
                  String birthday, boolean abilityToOppose, boolean speakEnglish) {
        super(name, surname, education, birthday);
        this.abilityToOppose = abilityToOppose;
        this.speakEnglish = true;
    }

    public static void main(String[] args) {
        Doctor george = new Doctor("George", "Bla", "3", "12.12.2012", true, false);
    }
}

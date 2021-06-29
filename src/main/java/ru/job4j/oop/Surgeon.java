package ru.job4j.oop;

public class Surgeon extends Doctor {
    private String speciality;

    public Surgeon(String name, String surname,
                   String education, String birthday,
                   boolean abilityToOppose, boolean speakEnglish, String speciality) {
        super(name, surname, education, birthday, abilityToOppose, speakEnglish);
        this.speciality = speciality;
    }

    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon("Fillip", "Posco",
                "7 catehory", "10.10.1010", false,
                true, "anesthetist");
    }
}


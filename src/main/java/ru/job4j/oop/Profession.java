package ru.job4j.oop;

public abstract class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public Profession(String name, String surname, String education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurnameName() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String setSurname(String surname) {
        this.surname = surname;
        return surname;
    }

    public String setEducation(String education) {
        this.education = education;
        return education;
    }

    public String setBirthday(String birthday) {
        this.birthday = birthday;
        return birthday;
    }
}
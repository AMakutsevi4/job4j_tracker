package ru.job4j.pojo;

import java.util.Date;

public class College extends Student {
    public static void main(String[] args) {
        College student = new College();
        student.setFullName("Makutsevich Alexandeh Ivanovich");
        student.setGroup("1");
        student.setAdmission(new Date());
        System.out.println("Студент: " + student.getFullName() + System.lineSeparator()
                + " Группа: " + student.getGroup() + System.lineSeparator()
                + " Дата поступления: " + student.getAdmission());
    }
}

package ru.job4j.oop;

public class JSONReport extends TextReport {
    public String generate(String name, String body) {
        return "name " + name + System.lineSeparator() + "body " + body;
    }

    public static void main(String[] args) {
        JSONReport report = new JSONReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
    }
}
package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 462);
        Book warAndPeace = new Book("War and Peace", 1300);
        Book theLighthouse = new Book("To the lighthouse", 288);
        Book invisibleMan = new Book("Invisible man", 224);

        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = warAndPeace;
        books[2] = theLighthouse;
        books[3] = invisibleMan;
        for (Book i : books) {
            System.out.println(i.getName() + " - " + i.getPage());
        }
        books[0] = invisibleMan;
        books[3] = cleanCode;
        for (Book i : books) {
            System.out.println(i.getName() + " - " + i.getPage());
        }
        for (Book i : books) {
            if ("Clean code".equals(i.getName())) {
                System.out.println(i.getName() + " - " + i.getPage());
            }
        }
    }
}
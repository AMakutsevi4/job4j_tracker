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
        for (int i = 0; i < books.length; i++) {
            Book boo = books[i];
            System.out.println(boo.getName() + " - " + boo.getPage());
        }
        books[0] = invisibleMan;
        books[3] = cleanCode;
        for (int i = 0; i < books.length; i++) {
            Book boo = books[i];
            System.out.println(boo.getName() + " - " + boo.getPage());
        }
        for (int i = 0; i < books.length; i++) {
            Book boo = books[i];
            if (boo.getName() == "Clean code") {
                System.out.println(boo.getName() + " - " + boo.getPage());
            }
        }
    }
}
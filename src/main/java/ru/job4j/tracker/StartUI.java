package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

      public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Выберите: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Создайте новый предмет ====");
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Показать все предметы: ====");
                Item[] items = tracker.findAll();
                for (Item i : items) {
                    System.out.println(i);
                }
            } else if (select == 2) {
                System.out.println("=== Редактировать элемент: ====");
                System.out.println("Введите id заявки");
                int id = scanner.nextInt();
                System.out.println("Введите новое имя элемента");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Элемент изменен");
                } else {
                    System.out.println("Ошибка");
                }
            } else if (select == 3) {
                System.out.println("Введите id заявки");
                int id = scanner.nextInt();
                if (tracker.delete(id)) {
                    System.out.println("Элемент удален");
                } else {
                    System.out.println("Ошибка");
                }

            } else if (select == 4) {
                System.out.println("Введите id заявки");
                int id = scanner.nextInt();
                Item item = tracker.findById(id);
                boolean rsl = item != null;
                if (rsl) {
                    System.out.println("Элемент найден: " + item);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                System.out.println("Введите имя заявки");
                String name = scanner.nextLine();
                Item[] item = tracker.findByName(name);
                if (item.length > 0) {
                    for (int i = 0; i < item.length; i++) {
                  System.out.println("Элемент найден: " + Arrays.toString(Arrays.copyOf(item, i)));
                    }

                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавить новый элемент\n"
                + "1. Показать все предметы\n"
                + "2. Редактировать элемент\n"
                + "3. Удалить элемент'\n"
                + "4. Найти объект по идентификатору (id)\n"
                + "5. Найти объект по названию\n"
                + "6. Выйти из программы");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}

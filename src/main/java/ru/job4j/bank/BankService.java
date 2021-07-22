package ru.job4j.bank;

import ru.job4j.collection.Order;

import java.util.*;

/**
 * Класс описывает работу модели банковской системы
 *
 * @author Makutsevich
 * @version 1.0
 */
public class BankService {
    /**
     * Это поле содержит всех пользователей системы с привязанными к ним счетами.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Этот метод добавляет пользователя в систему
     * Если такого пользователя еще нет, добавляет его в список.
     */
    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    /**
     * Метод принимает на вход паспорт и счет, добавляет счет по пасспорту.
     * По паспорту находит пользователя с помощью метода findByPassport(passport).
     * Добавляет новый счет пользователю, если такого счета еще нет.
     */

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспорт, позволяя по нему получить пользователя.
     * сравнивает значение пасспорта пользователя и входное значение.
     */

    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод принимает на вход паспорт и реквизит, позволяя по ним получить счет.
     * По паспорту находит пользователя с помощью метода findByPassport(passport).
     * Перебирает список счетов пользователя.
     * Сравнивает значение реквизитов счета и входное значение.
     *
     * @return счет или null, если счета с таким реквизитом нету
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            return users.get(user.get())
                    .stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst();
        }
        return null;
    }

    /**
     * Метод для перечисления денег с одного счёта на другой счёт.
     * Используя паспорт и реквезит находит счет с помощью метода findByRequisite.
     * Если счета существуют и счет списания больше или равен amount производится перечисление средств.
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> oneAcc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> twoAcc = findByRequisite(destPassport, destRequisite);
        if (oneAcc.isPresent() && oneAcc.get().getBalance() >= amount && twoAcc.isPresent()) {
            oneAcc.get().setBalance(oneAcc.get().getBalance() - amount);
            twoAcc.get().setBalance(twoAcc.get().getBalance() + amount);
            return true;
        }

        return false;
    }
}
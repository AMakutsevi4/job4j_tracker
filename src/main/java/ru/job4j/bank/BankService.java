package ru.job4j.bank;

import ru.job4j.collection.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу модели банковской системы
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
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }
    /**
     * Метод принимает на вход паспорт, позволяя по нему получить пользователя.
     * сравнивает значение пасспорта пользователя и входное значение.
     */

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }
    /**
     * Метод принимает на вход паспорт и реквизит, позволяя по ним получить счет.
     * По паспорту находит пользователя с помощью метода findByPassport(passport).
     * Перебирает список счетов пользователя.
     * Сравнивает значение реквизитов счета и входное значение.
     *@return счет или null, если счета с таким реквизитом нету
      */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
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
        Account oneAcc = findByRequisite(srcPassport, srcRequisite);
        Account twoAcc = findByRequisite(destPassport, destRequisite);
        if (oneAcc != null && oneAcc.getBalance() >= amount && twoAcc != null) {
            oneAcc.setBalance(oneAcc.getBalance() - amount);
            twoAcc.setBalance(twoAcc.getBalance() + amount);
            return true;
        }

        return false;
    }
}
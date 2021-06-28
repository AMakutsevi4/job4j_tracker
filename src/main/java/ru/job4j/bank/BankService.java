package ru.job4j.bank;

import ru.job4j.collection.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> accounts = new ArrayList<>();
        users.putIfAbsent(user, accounts);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = users.get(user);
        if (user != null) {
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

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

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account oneAcc = findByRequisite(srcPassport, srcRequisite);
        Account twoAcc = findByRequisite(destPassport, destRequisite);
        if (oneAcc != null && twoAcc != null) {
            if (oneAcc.getBalance() >= amount) {
                oneAcc.setBalance(oneAcc.getBalance() - amount);
                twoAcc.setBalance(twoAcc.getBalance() + amount);
                return true;
            }
        }
        return false;
    }
}
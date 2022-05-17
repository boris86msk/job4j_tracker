package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> arr = users.get(user);
        if (!arr.contains(account)) {
            arr.add(account);
        }

    }

    public User findByPassport(String passport) {
        User usr = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                usr = user;
                break;
            }
        }
        return usr;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account acc = null;
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        for (Account account : users.get(user)) {
            if (account.getRequisite().equals(requisite)) {
                acc = account;
                break;
            }
        }
        return acc;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        return rsl;
    }
}

package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс содержит логику роботы банковского сервиса.
 * @author Boris Pokidov
 * @version 1.0
 */
public class BankService {
    /**
     * поле содержит всех пользователей с привязанными к ним счетами.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод добавляет пользователю новый счет при условии
     * что пользователь с таким данными паспорта существует и что счета
     * с таким реквизитом у него еще нет.
     * @param passport номер паспорта пользователя
     * @param account объект класса Account: номер счета, баланс.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> arr = users.get(user);
            if (!arr.contains(account)) {
                arr.add(account);
            }
        }
    }

    /**
     * Метод возвращает объект пользователя по номеру паспорта
     * при условии что такой пользователь зарегестрирован.
     * @return объект User.
     */

    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод возвращает объект аккаунта (счета) по пасорту и реквизиту
     * при условии что такие пользователь и счет существуют.
     * @param passport номер паспорта
     * @param requisite реквизит
     * @return Account acc
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(account -> account.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
            }
        return null;
    }

    /**
     * Метод служит для перевода средст между счетами пользователя
     * проверяет наличии счетов в системе а так же наличии необходимой
     * суммы для перевода на счету "отправителя"
     * @param srcPassport владелец счета списания
     * @param srcRequisite счет списания
     * @param destPassport владелец счета пополнения
     * @param destRequisite счет пополнения
     * @param amount сумма перевода
     * @return true/false перевод осуществлен/не осуществлен
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account accSrc = findByRequisite(srcPassport, srcRequisite);
        Account accDest = findByRequisite(destPassport, destRequisite);
        if (accSrc != null && accDest != null && accSrc.getBalance() >= amount) {
            accDest.setBalance(accDest.getBalance() + amount);
            accSrc.setBalance(accSrc.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}

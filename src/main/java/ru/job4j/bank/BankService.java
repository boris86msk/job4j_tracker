package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> arr = users.get(user.get());
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

    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод возвращает объект аккаунта (счета) по пасорту и реквизиту
     * при условии что такие пользователь и счет существуют.
     * @param passport номер паспорта
     * @param requisite реквизит
     * @return Account acc
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        return findByPassport(passport)
                .flatMap(u -> users.get(u)
                        .stream()
                        .filter(account -> account.getRequisite().equals(requisite))
                        .findFirst());
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
        Optional<Account> accSrc = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> accDest = findByRequisite(destPassport, destRequisite);
        if (accSrc.isPresent() && accDest.isPresent()
                && accSrc.get().getBalance() >= amount) {
            accDest.get().setBalance(accDest.get().getBalance() + amount);
            accSrc.get().setBalance(accSrc.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}

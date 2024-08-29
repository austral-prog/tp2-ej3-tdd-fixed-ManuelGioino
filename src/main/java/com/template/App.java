package com.template;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static Map<String, Integer> createAccount(Map<String, Integer> accounts, String account) {
        if (account == null || account.isEmpty() || accounts.containsKey(account)) {
            Map<String, Integer> errorMap = new HashMap<>();
            errorMap.put("error", -1);
            return errorMap;
        }

        Map<String, Integer> updatedAccounts = new HashMap<>(accounts);
        updatedAccounts.put(account, 0);
        return updatedAccounts;
    }

    public static Map<String, Integer> deposit(Map<String, Integer> accounts, String account, int amount) {
        if (amount < 0 || !accounts.containsKey(account)) {
            Map<String, Integer> errorMap = new HashMap<>();
            errorMap.put("error", -1);
            return errorMap;
        }

        Map<String, Integer> updatedAccounts = new HashMap<>(accounts);
        updatedAccounts.put(account, updatedAccounts.get(account) + amount);
        return updatedAccounts;
    }

    public static Map<String, Integer> withdrawal(Map<String, Integer> accounts, String account, int amount) {
        if (amount < 0 || !accounts.containsKey(account) || accounts.get(account) < amount) {
            Map<String, Integer> errorMap = new HashMap<>();
            errorMap.put("error", -1);
            return errorMap;
        }

        Map<String, Integer> updatedAccounts = new HashMap<>(accounts);
        updatedAccounts.put(account, updatedAccounts.get(account) - amount);
        return updatedAccounts;
    }

    public static Map<String, Integer> transfer(Map<String, Integer> accounts, String account1, String account2, int amount) {
        if (amount < 0 || account1.equals(account2) || !accounts.containsKey(account1) || !accounts.containsKey(account2) || accounts.get(account1) < amount) {
            Map<String, Integer> errorMap = new HashMap<>();
            errorMap.put("error", -1);
            return errorMap;
        }

        Map<String, Integer> updatedAccounts = new HashMap<>(accounts);
        updatedAccounts.put(account1, updatedAccounts.get(account1) - amount);
        updatedAccounts.put(account2, updatedAccounts.get(account2) + amount);
        return updatedAccounts;
    }
}

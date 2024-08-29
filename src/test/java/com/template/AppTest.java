package com.template;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    void testCreateAccountSuccess() {
        Map<String, Integer> accounts = Map.of();
        Map<String, Integer> updatedAccounts = App.createAccount(accounts, "john");
        assertEquals(0, updatedAccounts.get("john"));
    }

    @Test
    void testCreateAccountEmptyName() {
        Map<String, Integer> accounts = Map.of();
        Map<String, Integer> updatedAccounts = App.createAccount(accounts, "");
        assertEquals(-1, updatedAccounts.get("error"));
    }

    @Test
    void testCreateAccountDuplicate() {
        Map<String, Integer> accounts = Map.of("john", 0);
        Map<String, Integer> updatedAccounts = App.createAccount(accounts, "john");
        assertEquals(-1, updatedAccounts.get("error"));
    }

    @Test
    void testDepositSuccess() {
        Map<String, Integer> accounts = Map.of("john", 10);
        Map<String, Integer> updatedAccounts = App.deposit(accounts, "john", 5);
        assertEquals(15, updatedAccounts.get("john"));
    }

    @Test
    void testDepositNegativeAmount() {
        Map<String, Integer> accounts = Map.of("john", 10);
        Map<String, Integer> updatedAccounts = App.deposit(accounts, "john", -5);
        assertEquals(-1, updatedAccounts.get("error"));
    }

    @Test
    void testDepositNonExistentAccount() {
        Map<String, Integer> accounts = Map.of();
        Map<String, Integer> updatedAccounts = App.deposit(accounts, "john", 5);
        assertEquals(-1, updatedAccounts.get("error"));
    }

    @Test
    void testWithdrawalSuccess() {
        Map<String, Integer> accounts = Map.of("john", 10);
        Map<String, Integer> updatedAccounts = App.withdrawal(accounts, "john", 5);
        assertEquals(5, updatedAccounts.get("john"));
    }

    @Test
    void testWithdrawalNegativeAmount() {
        Map<String, Integer> accounts = Map.of("john", 10);
        Map<String, Integer> updatedAccounts = App.withdrawal(accounts, "john", -5);
        assertEquals(-1, updatedAccounts.get("error"));
    }

    @Test
    void testWithdrawalInsufficientFunds() {
        Map<String, Integer> accounts = Map.of("john", 10);
        Map<String, Integer> updatedAccounts = App.withdrawal(accounts, "john", 15);
        assertEquals(-1, updatedAccounts.get("error"));
    }

    @Test
    void testWithdrawalNonExistentAccount() {
        Map<String, Integer> accounts = Map.of();
        Map<String, Integer> updatedAccounts = App.withdrawal(accounts, "john", 5);
        assertEquals(-1, updatedAccounts.get("error"));
    }

    @Test
    void testTransferSuccess() {
        Map<String, Integer> accounts = Map.of("john", 10, "jane", 5);
        Map<String, Integer> updatedAccounts = App.transfer(accounts, "john", "jane", 5);
        assertEquals(5, updatedAccounts.get("john"));
        assertEquals(10, updatedAccounts.get("jane"));
    }

    @Test
    void testTransferNegativeAmount() {
        Map<String, Integer> accounts = Map.of("john", 10, "jane", 5);
        Map<String, Integer> updatedAccounts = App.transfer(accounts, "john", "jane", -5);
        assertEquals(-1, updatedAccounts.get("error"));
    }

    @Test
    void testTransferSameAccount() {
        Map<String, Integer> accounts = Map.of("john", 10);
        Map<String, Integer> updatedAccounts = App.transfer(accounts, "john", "john", 5);
        assertEquals(-1, updatedAccounts.get("error"));
    }

    @Test
    void testTransferInsufficientFunds() {
        Map<String, Integer> accounts = Map.of("john", 5, "jane", 5);
        Map<String, Integer> updatedAccounts = App.transfer(accounts, "john", "jane", 10);
        assertEquals(-1, updatedAccounts.get("error"));
    }

    @Test
    void testTransferNonExistentAccount() {
        Map<String, Integer> accounts = Map.of("john", 10);
        Map<String, Integer> updatedAccounts = App.transfer(accounts, "john", "jane", 5);
        assertEquals(-1, updatedAccounts.get("error"));
    }

    @Test
    void testTransferNonExistentSourceAccount() {
        Map<String, Integer> accounts = Map.of("jane", 10);
        Map<String, Integer> updatedAccounts = App.transfer(accounts, "john", "jane", 5);
        assertEquals(-1, updatedAccounts.get("error"));
    }

    @Test
    void testTransferNonExistentDestinationAccount() {
        Map<String, Integer> accounts = Map.of("john", 10);
        Map<String, Integer> updatedAccounts = App.transfer(accounts, "john", "jane", 5);
        assertEquals(-1, updatedAccounts.get("error"));
    }
}

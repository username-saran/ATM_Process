package com.atmprocess;

public class CustomerDetails {
    private int AccNo;
    private String AccountHolder;
    private int Pin;
    private int AccountBalance;

    public CustomerDetails(int accNo, String accountHolder, int pin, int accountBalance) {
        AccNo = accNo;
        AccountHolder = accountHolder;
        Pin = pin;
        AccountBalance = accountBalance;
    }

    public int getAccNo() {
        return AccNo;
    }

    public void setAccNo(int accNo) {
        AccNo = accNo;
    }

    public String getAccountHolder() {
        return AccountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        AccountHolder = accountHolder;
    }

    public int getPin() {
        return Pin;
    }

    public void setPin(int pin) {
        Pin = pin;
    }

    public int getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        AccountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "AccNo=" + AccNo +
                ", AccountHolder='" + AccountHolder + '\'' +
                ", Pin=" + Pin +
                ", AccountBalance=" + AccountBalance +
                '}';
    }
}

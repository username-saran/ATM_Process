package com.atmprocess;

public class CreationATM {
    private int denomination;
    private int number;
    private int value;

    public CreationATM(int denomination, int number, int value) {
        this.denomination = denomination;
        this.number = number;
        this.value = value;
    }

    public int getDenomination() {
        return denomination;
    }

    public int getNumber() {
        return number;
    }

    public int getValue() {
        return value;
    }

    public void setDenomination(int denomination) {
        this.denomination = denomination;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CreationATM{" +
                "denomination=" + denomination +
                ", number=" + number +
                ", value=" + value +
                '}';
    }
}

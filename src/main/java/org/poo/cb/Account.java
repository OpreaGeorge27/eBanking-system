package org.poo.cb;

public abstract class Account {
    private String currency;
    private double currentValue;

    public Account(String currency){
        this.currency = currency;
    }


    public void addMoney(Float amount){
        this.currentValue+=amount;
    }

    public void subMoney(Float amount){
        this.currentValue-=amount;
    }

    public String getCurrency() {
        return currency;
    }

    public double getCurrentValue() {
        return currentValue;
    }
}

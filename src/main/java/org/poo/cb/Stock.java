package org.poo.cb;

import java.util.*;

public class Stock {
    private String name;
    private Map<String, Float> history;
    private float amount;
    private float lastPrice;
    private boolean isRecommended;

    public Stock(String name, Map<String, Float> history, float amount) {
        this.amount = amount;
        this.name = name;
        this.history = history;
        this.isRecommended = false;
    }

    public void setLastPrice(float lastPrice) {
        this.lastPrice = lastPrice;
    }

    public float getPrice() {
        return lastPrice;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return (int) amount;
    }

    public Map<String, Float> getHistory() {
        return history;
    }

    public boolean isRecommended() {
        return isRecommended;
    }

    public void setRecommended(boolean recommended) {
        isRecommended = recommended;
    }
}

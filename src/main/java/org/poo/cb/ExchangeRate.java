package org.poo.cb;

public class ExchangeRate {
    private String currency1;
    private String currency2;
    private Float ratio;

    public ExchangeRate(String currency1, String currency2, Float ratio) {
        this.currency1 = currency1;
        this.currency2 = currency2;
        this.ratio = ratio;
    }

    public String getCurrency1() {
        return currency1;
    }

    public String getCurrency2() {
        return currency2;
    }

    public Float getRatio() {
        return ratio;
    }
}

package org.poo.cb;

import java.util.HashMap;
import java.util.Map;

public class Exchanger {
    //MEDIATOR
    private Map<String, Map<String, ExchangeRate>> exchanges;

    public Exchanger() {
        this.exchanges = new HashMap<>();
    }

    public void setExchanges(Map<String, Map<String, ExchangeRate>> exchanges) {
        this.exchanges = exchanges;
    }

    public Float getExchangeValue(String curr1, String curr2, Float val1) {
        Float exchangeRate = exchanges.get(curr2).get(curr1).getRatio();
        return val1 * exchangeRate;
    }
}

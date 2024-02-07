package org.poo.cb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadCSV {
    private String convfile;
    private String stockfile;

    public ReadCSV(String convfile, String stockFile, Exchanger exchanger) {
        this.convfile = convfile;
        this.stockfile = stockFile;
    }

    public void readConversions() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + convfile));
            String line = reader.readLine();
            String[] header = line.split(",");
            Map<String, Map<String, ExchangeRate>> ret = new HashMap<>();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Map<String, ExchangeRate> map = new HashMap<>();

                for (int i = 1; i < parts.length; i++) {
                    ExchangeRate exch = new ExchangeRate(parts[0],header[i],Float.valueOf(parts[i]));
                    map.put(header[i], exch);
                }

                ret.put(parts[0],map);
            }
            EBank.getInstance().getExchanger().setExchanges(ret);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReadStocks() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + stockfile));
            String line = reader.readLine();
            String[] header = line.split(",");
            Map<String, Stock> stocks = new HashMap<>();
            while ((line = reader.readLine()) != null) {
                Map<String, Float> ret = new LinkedHashMap<>();
                String[] parts = line.split(",");
                for (int i = 1; i < parts.length; i++) {
                    ret.put(header[i],Float.valueOf(parts[i]));
                }
                Stock stock = new Stock(parts[0],ret,0);
                stock.setLastPrice(Float.valueOf(parts[parts.length-1]));
                EBank.getInstance().getForSaleStocks().put(parts[0],stock);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package org.poo.cb;

import java.io.IOException;
import java.util.ArrayList;

public class WriteJSON {

    public WriteJSON() {

    }

    public void printUser(User user) throws IOException {
        String ret = "{";
        ret += "\"email\":\"" + user.getEmail() + "\",\"firstname\":\"" + user.getFirstName();
        ret += "\",\"lastname\":\"" + user.getName() + "\",\"address\":\"";
        ret += user.getAddress() + "\",\"friends\":[";
        int contor = user.getFriends().size();
        for (User usr : user.getFriends().values()) {
            ret += "\"" + usr.getEmail() + "\"";
            if (--contor > 0) {
                ret += ",";
            }
        }
        ret += "]}";
        System.out.println(ret);
    }

    public void printPortofolio(User user) throws IOException {
        String ret = "{\"stocks\":[";
        int contor = user.getStocks().size();
        for (Stock stock : user.getStocks().values()) {
            ret += "{\"stockName\":\"" + stock.getName() + "\",\"amount\":" + stock.getAmount() + "}";
            if (--contor > 0) {
                ret += ",";
            }
        }
        ret += "],\"accounts\":[";
        contor = user.getAccounts().size();
        for (Account account : user.getAccounts().values()) {
            ret += "{\"currencyName\":\"" + account.getCurrency() + "\",\"amount\":\"";
            System.out.printf(ret);
            System.out.printf("%.2f\"}", account.getCurrentValue());
            ret = "";
            if (--contor > 0) {
                ret += ",";
            }
        }
        ret += "]}";
        System.out.println(ret);
    }

    public void printRecStocks(ArrayList<Stock> rec) {
        String ret = "{\"stocksToBuy\":[";
        int cnt = rec.size();
        for (Stock stock : rec) {
            ret += "\"" + stock.getName() + "\"";
            if (--cnt > 0)
                ret += ",";
        }
        ret += "]}";
        System.out.println(ret);
    }

}

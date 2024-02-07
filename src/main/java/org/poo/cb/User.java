package org.poo.cb;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class User {
    private String email;
    private String firstName;
    private String name;
    private String address;
    private Map<String, User> friends;
    private Map<AccountType,Account> accounts;
    private Map<String,Stock> stocks;


    public User(String email, String firstName, String name, String address) {
        this.email = email;
        this.firstName = firstName;
        this.name = name;
        this.address = address;
        this.friends = new LinkedHashMap<>();
        this.accounts = new LinkedHashMap<>();
        this.stocks = new LinkedHashMap<>();
    }

    public String getEmail() {
        return email;
    }

    public Map<String, Stock> getStocks() {
        return stocks;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Map<String, User> getFriends() {
        return friends;
    }

    public Map<AccountType, Account> getAccounts() {
        return accounts;
    }




}

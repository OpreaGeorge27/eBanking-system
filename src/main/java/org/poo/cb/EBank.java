package org.poo.cb;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class EBank implements Bank {
    //SINGLETON
    private static EBank instance;
    private Exchanger exchanger;
    private UserInteraction interact;
    private WriteJSON JSONwriter;
    private ReadCSV reader;
    private String exchangeRatesPath;
    private String stocksPath;
    private String commandsPath;
    private Map<String, User> users;
    private Map<String, Stock> forSaleStocks;

    private EBank() {
        exchanger = new Exchanger();
        interact = new UserInteraction();
        JSONwriter = new WriteJSON();
        users = new HashMap<>();
        forSaleStocks = new HashMap<>();
    }

    public static EBank getInstance() {
        if (instance == null) {
            instance = new EBank();
        }
        return instance;
    }

    public void setPaths(String exchangeRatesPath, String stocksPath, String commandsPath) {
        this.commandsPath = commandsPath;
        this.exchangeRatesPath = exchangeRatesPath;
        this.stocksPath = stocksPath;
        this.reader = new ReadCSV(exchangeRatesPath, stocksPath, exchanger);
        reader.readConversions();
        reader.ReadStocks();
    }

    public WriteJSON getJSONwriter() {
        return JSONwriter;
    }

    public Exchanger getExchanger(){
        return exchanger;
    }

    public void addUser(User user) {
        users.put(user.getEmail(), user);
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, Stock> getForSaleStocks() {
        return forSaleStocks;
    }

    public void createUser(String email, String firstName, String name, String addr) {
        interact.setCommand(new CreateUserCommand(email, firstName, name, addr));
        interact.executeCommand();
    }

    public void listUser(String email) {
        interact.setCommand(new ListUserCommand(email));
        interact.executeCommand();
    }

    public void addFriend(String email,String friend){
        interact.setCommand(new AddFriendCommand(email,friend));
        interact.executeCommand();
    }

    public void addAccount(String email, String curr){
        interact.setCommand(new AddAccountCommand(email,curr));
        interact.executeCommand();
    }

    public void addMoney(String email,String type,Float amount){
        interact.setCommand(new AddMoneyCommand(email,type,amount));
        interact.executeCommand();
    }

    public void listPortofolio(String email){
        interact.setCommand(new ListPortofolioCommand(email));
        interact.executeCommand();
    }

    public void exchangeMoney(String email,String currency1,String currency2,Float amount){
        interact.setCommand(new ExchangeMoneyCommand(email,currency1,currency2,amount));
        interact.executeCommand();
    }

    public void transferMoney(String email,String friend,String currency, float amount){
        interact.setCommand(new TransferCommand(email,friend,currency,amount));
        interact.executeCommand();
    }

    public void buyStock(String email,String stockName,float amount){
        interact.setCommand(new BuyStocksCommand(email,stockName,amount));
        interact.executeCommand();
    }

    public void recommandStocks(){
        interact.setCommand(new RecommandStocksCommand());
        interact.executeCommand();
    }


    public void clearData(){
        users.clear();
    }

}

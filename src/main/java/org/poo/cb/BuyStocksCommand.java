package org.poo.cb;

public class BuyStocksCommand implements Command {
    private String email;
    private String stockName;
    private float amount;

    public BuyStocksCommand(String email, String stockName, float amount) {
        this.email = email;
        this.stockName = stockName;
        this.amount = amount;
    }

    @Override
    public void execute() {
        User user = EBank.getInstance().getUsers().get(email);
        Account acc = user.getAccounts().get(AccountType.valueOf("USD"));
        Stock stock = EBank.getInstance().getForSaleStocks().get(stockName);
        Float stockValue = stock.getPrice() * amount;
        if(stockValue > acc.getCurrentValue()){
            throw new IllegalArgumentException("Insufficient amount in account for buying stock");
        }
        acc.subMoney(stockValue);
        user.getStocks().put(stockName,new Stock(stockName,stock.getHistory(),amount));
    }
}

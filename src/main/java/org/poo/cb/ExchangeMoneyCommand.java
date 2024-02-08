package org.poo.cb;

public class ExchangeMoneyCommand implements Command {
    private String email;
    private String curr1;
    private String curr2;
    private Float amount;

    public ExchangeMoneyCommand(String email, String curr1, String curr2, Float amount) {
        this.email = email;
        this.curr1 = curr1;
        this.curr2 = curr2;
        this.amount = amount;
    }

    @Override
    public void execute() {
        User user = EBank.getInstance().getUsers().get(email);
        Account curr1Acc = user.getAccounts().get(AccountType.valueOf(curr1));
        Account curr2Acc = user.getAccounts().get(AccountType.valueOf(curr2));
        Float transfer = EBank.getInstance().getExchanger().getExchangeValue(curr1, curr2, amount);
        if (curr1Acc.getCurrentValue() < transfer) {
            throw new IllegalArgumentException("Insufficient amount in account " + curr1 + " for exchange");
        }
        curr2Acc.addMoney(amount);
        if (((curr1Acc.getCurrentValue() / 2) < transfer) && !user.isPremium()) {
            curr1Acc.subMoney(0.01f * transfer);
            curr1Acc.subMoney(transfer);
        }
        else{
            //pt premium scadem doar valoarea transferului
            curr1Acc.subMoney(transfer);
        }
    }
}

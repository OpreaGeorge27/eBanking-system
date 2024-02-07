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
        Account  curr1Acc = user.getAccounts().get(AccountType.valueOf(curr1));
        Account curr2Acc  = user.getAccounts().get(AccountType.valueOf(curr2));
        if(curr1Acc.getCurrentValue() < amount){
            System.out.println("Insufficient amount in account "+ curr1 +" for exchange");
        }
        Float transfer = EBank.getInstance().getExchanger().getExchangeValue(curr1,curr2,amount);
        curr2Acc.addMoney(amount);
        if(curr1Acc.getCurrentValue()/2 < transfer){
            curr1Acc.subMoney(0.01f*transfer);
            //aici nu stiu ce se intampla daca de exemplu clientul are 98EUR si transfera 98 nu e precizat in cerinta
        }
        curr1Acc.subMoney(transfer);
    }
}

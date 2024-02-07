package org.poo.cb;

public class TransferCommand implements Command {
    private String email;
    private String friend;
    private String currency;
    private float amount;

    public TransferCommand(String email,String friend,String currency,float amount){
        this.email=email;
        this.friend=friend;
        this.currency=currency;
        this.amount=amount;
    }

    @Override
    public void execute() {
        User user = EBank.getInstance().getUsers().get(email);
        User frnd = EBank.getInstance().getUsers().get(friend);
        if(user.getFriends().containsKey(friend) == false){
            throw new IllegalArgumentException("You are not allowed to transfer money to " + friend);
        }
        Account usrAcc = user.getAccounts().get(AccountType.valueOf(currency));
        Account frAcc  = frnd.getAccounts().get(AccountType.valueOf(currency));
        if(usrAcc.getCurrentValue() < amount){
            throw new IllegalArgumentException("Insufficient amount in account " + currency +" for transfer");
        }
        usrAcc.subMoney(amount);
        frAcc.addMoney(amount);
    }
}

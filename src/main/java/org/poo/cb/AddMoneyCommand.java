package org.poo.cb;

public class AddMoneyCommand implements Command {
    private String email;
    private Float amount;
    private AccountType acc;

    public AddMoneyCommand(String email, String accType, Float amount) {
        this.amount = amount;
        try {
            acc = AccountType.valueOf(accType);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
        this.email = email;
    }

    @Override
    public void execute() {
        User user = EBank.getInstance().getUsers().get(email);
        Account account = user.getAccounts().get(acc);
        account.addMoney(amount);
    }
}

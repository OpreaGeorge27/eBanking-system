package org.poo.cb;

public class BuyPremiumCommand implements Command {
    private String email;

    public BuyPremiumCommand(String email) {
        this.email = email;
    }

    @Override
    public void execute() {
        User user = EBank.getInstance().getUsers().get(email);
        if (user == null) {
            throw new IllegalArgumentException("User with  " + email + " doesn’t exist");
        }
        Account account = user.getAccounts().get(AccountType.valueOf("USD"));
        if (account.getCurrentValue() < 100) {
            throw new IllegalArgumentException("Insufficiend amount in account for buying premium option");
        }
        account.subMoney(100f);
        user.setPremium(true);
    }
}

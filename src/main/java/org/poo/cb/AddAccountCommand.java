package org.poo.cb;

public class AddAccountCommand implements Command {
    private String owner;
    private AccountType currency;

    public AddAccountCommand (String email, String currency){
        this.owner=email;
        try{
            this.currency=AccountType.valueOf(currency);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void execute() {
        User user = EBank.getInstance().getUsers().get(owner);
        Account account = AccCreator.getInstance().createAccount(currency);
        user.getAccounts().put(currency,account);
    }
}

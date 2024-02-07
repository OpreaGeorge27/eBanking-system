package org.poo.cb;

public class AccCreator {
    //FACTORY
    private static AccCreator instance;

    private AccCreator() {

    }

    public static AccCreator getInstance() {
        if (instance == null) {
            instance = new AccCreator();
        }
        return instance;
    }

    public Account createAccount(AccountType accountType) {
        switch (accountType) {
            case EUR:
                return new EURAcc();
            case GBP:
                return new GBPAcc();
            case JPY:
                return new JPYAcc();
            case CAD:
                return new CADAcc();
            case USD:
                return new USDAcc();
            default:
                throw new IllegalArgumentException("Invalid currency type");
        }
    }

}

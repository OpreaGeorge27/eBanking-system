package org.poo.cb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        if (args == null) {
            System.out.println("Running Main");
            return;
        }
        String exchangeRates = args[0];
        String stocks = args[1];
        String operations = args[2];
        EBank app = EBank.getInstance();
        app.clearData();
        app.setPaths(exchangeRates, stocks, operations);
        ReadCommands readCommands = new ReadCommands(operations);
        readCommands.readAndExecute();
    }
}
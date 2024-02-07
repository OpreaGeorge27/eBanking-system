package org.poo.cb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadCommands {
    public String commandsPath;

    public ReadCommands(String path) {
        this.commandsPath = path;
    }

    public void readAndExecute() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + commandsPath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                switch (parts[0]) {
                    case "CREATE":
                        String addr = "";
                        for (int i = 5; i < parts.length; i++) {
                            addr += parts[i];
                            if (i < parts.length - 1) {
                                addr += " ";
                            }
                        }
                        EBank.getInstance().createUser(parts[2], parts[3], parts[4], addr);
                        break;

                    case "LIST":
                        if (parts[1].equals("USER"))
                            EBank.getInstance().listUser(parts[2]);
                        if (parts[1].equals("PORTFOLIO"))
                            EBank.getInstance().listPortofolio(parts[2]);
                        break;

                    case "ADD":
                        if (parts[1].equals("FRIEND")) {
                            EBank.getInstance().addFriend(parts[2], parts[3]);
                        }
                        if (parts[1].equals("ACCOUNT")) {
                            EBank.getInstance().addAccount(parts[2], parts[3]);
                        }
                        if (parts[1].equals("MONEY")) {
                            EBank.getInstance().addMoney(parts[2], parts[3], Float.valueOf(parts[4]));
                        }
                        break;
                    case "EXCHANGE":
                        if (parts[1].equals("MONEY")) {
                            EBank.getInstance().exchangeMoney(parts[2], parts[3], parts[4], Float.valueOf(parts[5]));
                        }
                        break;
                    case "TRANSFER":
                        EBank.getInstance().transferMoney(parts[2], parts[3], parts[4], Float.valueOf(parts[5]));
                        break;
                    case "BUY":
                        if (parts[1].equals("PREMIUM")) {
                            EBank.getInstance().buyPremium(parts[2]);
                        } else {
                            EBank.getInstance().buyStock(parts[2], parts[3], Float.valueOf(parts[4]));
                        }
                        break;
                    case "RECOMMEND":
                        EBank.getInstance().recommandStocks();
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("File error");
        }
    }


}

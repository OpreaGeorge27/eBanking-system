package org.poo.cb;

import java.io.IOException;

public class ListPortofolioCommand implements Command {
    private String email;

    public ListPortofolioCommand(String email) {
        this.email = email;
    }

    @Override
    public void execute() {
        WriteJSON writer = new WriteJSON();
        User user = EBank.getInstance().getUsers().get(email);
        try {
            writer.printPortofolio(user);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

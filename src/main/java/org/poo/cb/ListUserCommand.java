package org.poo.cb;

import java.io.IOException;
import java.util.Map;

public class ListUserCommand implements Command {
    private String email;
    WriteJSON writer;

    public ListUserCommand(String email){
        this.email=email;
        writer = new WriteJSON();
    }

    @Override
    public void execute() {
        Map<String, User> users = EBank.getInstance().getUsers();
        User user = users.get(email);
        try{
            writer.printUser(user);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}

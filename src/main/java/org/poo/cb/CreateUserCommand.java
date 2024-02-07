package org.poo.cb;

import java.util.Map;

public class CreateUserCommand implements Command {
    private String email;
    private String firstName;
    private String name;
    private String address;

    public CreateUserCommand(String email, String firstName, String name, String addr){
        this.email = email;
        this.firstName = firstName;
        this.name = name;
        this.address = addr;
    }

    @Override
    public void execute() {
        if(EBank.getInstance().getUsers().containsKey(email)){
            throw new IllegalArgumentException("User with " + email + " already exists");
        }
        User user = new User(email,firstName,name,address);
        EBank bank = EBank.getInstance();
        bank.addUser(user);
    }
}

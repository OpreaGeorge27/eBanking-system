package org.poo.cb;

public class UserInteraction {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        try {
            command.execute();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

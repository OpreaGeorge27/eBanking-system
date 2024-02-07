package org.poo.cb;

import java.util.Map;

public class AddFriendCommand implements Command {
    private String userEmail;
    private String friendEmail;

    public AddFriendCommand(String user, String friendEmail) {
        this.userEmail = user;
        this.friendEmail = friendEmail;
    }

    @Override
    public void execute() {
        Map<String, User> users = EBank.getInstance().getUsers();
        User user = users.get(userEmail);
        if (user == null) {
            throw new IllegalArgumentException("User with " + userEmail + " doesn't exist");
        }
        User friend = users.get(friendEmail);
        if (friend == null) {
            throw new IllegalArgumentException("User with " + friendEmail + " doesn't exist");
        }
        if (user.getFriends().containsKey(friendEmail)) {
            throw new IllegalArgumentException("User with " + friendEmail + " is already a friend");

        }
        user.getFriends().put(friendEmail, friend);
        friend.getFriends().put(userEmail, user);
    }
}

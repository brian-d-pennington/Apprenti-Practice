package org.example;

public class CodeAlong {
    public static void main(String[] args) {
        BirthdayManager birthday = new BirthdayManager();

        Friend ralph = new Friend("Ralph", "05/19/1981");
        birthday.addFriend(ralph);

        Friend pedro = new Friend("Pedro", "06/16/1916");
        birthday.addFriend(pedro);

        for (Friend friend: birthday.getFriends()) {
            System.out.println(friend);
        }

        for (Friend friend : birthday.getMap().keySet()) {

        }
    }
}

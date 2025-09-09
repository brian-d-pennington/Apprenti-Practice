package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BirthdayManager {
    private HashMap<Friend, List<Gift>> friendsGiftList;

    public BirthdayManager () {
        this.friendsGiftList = new HashMap<Friend, List<Gift>>();
    }

    public HashMap<Friend, List<Gift>> getMap() {
        return this.friendsGiftList;
    }

    public List<Friend> getFriends() {
        return this.friendsGiftList.keySet().stream().toList();
    }

    public void addFriend(Friend newFriend) {
        friendsGiftList.put(newFriend, new ArrayList<Gift>());
    }

    public void addGift(Friend friend, Gift gift) {
        friendsGiftList.get(friend).add(gift);
    }

    public void removeFriend(Friend exFriend) {
        friendsGiftList.remove(exFriend);
    }




}

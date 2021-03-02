package com.sda.patterns.behavioral.iterator;

import com.sda.patterns.behavioral.iterator.iterator.ProfileIterator;
import com.sda.patterns.behavioral.iterator.network.Profile;
import com.sda.patterns.behavioral.iterator.network.SocialNetwork;

public class SocialSpammer {

    private SocialNetwork network;
    private ProfileIterator iterator;

    public SocialSpammer(SocialNetwork network) {
        this.network = network;
    }

    public void sendSpamToFriends(String profileEmail, String message) {
        System.out.println("iterate over friends");
        iterator = network.createFriendsIterator(profileEmail);
        if (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendSpamToCoworkers(String profileEmail, String message) {
        System.out.println("iterate over coworkers");
        iterator = network.createCoworkersIterator(profileEmail);
        if (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    private void sendMessage(String profileEmail, String message) {
        System.out.println("sent message to " + profileEmail
                + " with body " + message);
    }
}

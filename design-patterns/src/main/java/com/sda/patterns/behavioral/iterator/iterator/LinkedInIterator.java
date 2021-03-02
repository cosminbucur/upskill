package com.sda.patterns.behavioral.iterator.iterator;

import com.sda.patterns.behavioral.iterator.network.LinkedIn;
import com.sda.patterns.behavioral.iterator.network.Profile;

import java.util.ArrayList;
import java.util.List;

public class LinkedInIterator implements ProfileIterator {

    private LinkedIn network;
    private String type;
    private String email;
    private int currentPosition = 0;

    private List<String> emails = new ArrayList<>();
    private List<Profile> contacts = new ArrayList<>();

    public LinkedInIterator(LinkedIn network, String type, String email) {
        this.network = network;
        this.type = type;
        this.email = email;
    }

    @Override
    public boolean hasNext() {
        // get contacts from linkedin
        if (emails.isEmpty()) {
            List<String> profiles = network.requestRelatedContactsFromLinkedIn(email, type);
            for (String profile : profiles) {
                emails.add(profile);
            }
        }
        return currentPosition < emails.size();
    }

    @Override
    public Profile getNext() {
        if (!hasNext()) {
            return null;
        }

        String friendEmail = emails.get(currentPosition);
        Profile friendContact = contacts.get(currentPosition);

        if (friendContact == null) {
            friendContact = network.requestContactInfoFromLinkedIn(friendEmail);
            contacts.set(currentPosition, friendContact);
        }
        currentPosition++;
        return friendContact;
    }
}

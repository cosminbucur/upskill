package com.sda.patterns.behavioral.iterator.network;

import com.sda.patterns.behavioral.iterator.iterator.ProfileIterator;

import java.util.ArrayList;
import java.util.List;

public class LinkedIn implements SocialNetwork {

    private List<Profile> contacts;

    public LinkedIn(List<Profile> contacts) {
        this.contacts = contacts;
    }

    // request contact info
    public Profile requestContactInfoFromLinkedIn(String profileEmail) {
        System.out.println("loading profile: " + profileEmail);
        return findContact(profileEmail);
    }

    // request contacts
    public List<String> requestRelatedContactsFromLinkedIn(String profileEmail, String contactType) {
        Profile profile = findContact(profileEmail);
        if (profile != null) {
            return profile.getContacts(contactType);
        }
        return new ArrayList<>();
    }

    private Profile findContact(String profileEmail) {
        for (Profile profile : contacts) {
            if (profile.getEmail().equals(profileEmail)) {
                return profile;
            }
        }
        return null;
    }


    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return null;
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return null;
    }
}

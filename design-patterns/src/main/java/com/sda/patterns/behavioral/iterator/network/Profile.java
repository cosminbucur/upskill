package com.sda.patterns.behavioral.iterator.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile {

    private String name;
    private String email;

    // friends (1, 2 ,3)
    // coworkers (1)
    private Map<String, List<String>> contacts = new HashMap<>();

    // parse contact list from a set of "friends:name@gmail"
    public Profile(String name, String email, String... contacts) {
        this.name = name;
        this.email = email;

        // TODO: parse contacts from input
    }

    public String getEmail() {
        return email;
    }

    public List<String> getContacts(String contactType) {
        // add contact type if doesn't exist
        if (!contacts.containsKey(contactType)) {
            contacts.put(contactType, new ArrayList<>());
        }
        return contacts.get(contactType);
    }
}

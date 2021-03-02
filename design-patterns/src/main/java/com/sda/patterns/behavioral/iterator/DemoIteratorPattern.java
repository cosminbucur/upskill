package com.sda.patterns.behavioral.iterator;

import com.sda.patterns.behavioral.iterator.network.LinkedIn;
import com.sda.patterns.behavioral.iterator.network.Profile;
import com.sda.patterns.behavioral.iterator.network.SocialNetwork;

import java.util.ArrayList;
import java.util.List;

public class DemoIteratorPattern {

    public static void main(String[] args) {

        SocialNetwork network = new LinkedIn(createProfiles());

        SocialSpammer spammer = new SocialSpammer(network);
        spammer.sendSpamToFriends("ana@gmail.com",
                "hey! check out this link");
        spammer.sendSpamToCoworkers("ana@gmail.com",
                "hey! invited to meeting");
    }

    public static List<Profile> createProfiles() {
        List<Profile> data = new ArrayList<>();
        String ana = "ana@gmail.com";
        String cristi = "cristi@gmail.com";
        String elena = "elena@gmail.com";
        String vali = "vali@gmail.com";
        String alina = "alina@gmail.com";
        String paul = "paul@gmail.com";

        data.add(new Profile("Ana", ana, "friends:" + cristi, "coworkers:" + vali));
        data.add(new Profile("Cristi", cristi, "friends:" + ana, "coworkers:" + vali));
        data.add(new Profile("Elena", elena, "coworkers:" + paul));
        data.add(new Profile("Paul", paul, "coworkers:" + elena));
        data.add(new Profile("Vali", vali, "coworkers:" + ana, "coworkers:" + cristi, "friends:" + alina));
        data.add(new Profile("Alina", alina, "friends:" + ana, "friends:" + vali));

        return data;
    }
}

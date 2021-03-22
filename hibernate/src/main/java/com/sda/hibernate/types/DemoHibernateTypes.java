package com.sda.hibernate.types;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DemoHibernateTypes {

    public static void main(String[] args) {
        PlayerDao playerDao = new PlayerDao();

        playerDao.create(createPlayer());
    }

    private static Player createPlayer() {
        Player player = new Player();
        player.setUsername("alex");
        player.setBirthDate(LocalDate.of(1980, 7, 21));
        player.setRegistrationDate(LocalDateTime.now());
        player.setAge(21);
        player.setStatus(Status.ACTIVE);
        player.setAddress(createAddress());
        return player;
    }

    private static Address createAddress() {
        Address address = new Address();
        address.setAddressLine1("str Unirii 10");
        address.setAddressLine2("bl 1, ap 20");
        address.setCity("Bucharest");
        address.setCounty("Bucharest");
        address.setCountry("Romania");
        return address;
    }
}

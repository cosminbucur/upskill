package com.sda.hibernate.queries.native_query;

import java.util.List;

public class DemoNativeQuery {

    public static void main(String[] args) {
        Trader trader1 = new Trader("john");
        Trader trader2 = new Trader("anne");

        TraderDao traderDao = new TraderDao();
        traderDao.create(trader1);
        traderDao.create(trader2);

        List<Trader> traders = traderDao.findAllWithNativeQuery();
        System.out.println("--- all traders: " + traders);

        List<Trader> filteredTraders = traderDao.findAllByNameWithNamedNativeQuery("anne");
        System.out.println("--- filtered traders: " + filteredTraders);
    }
}

package com.sda.hibernate.queries.hql;

import java.util.List;

public class DemoHqlQuery {

    public static void main(String[] args) {
        Stock stock1 = new Stock("stock1", "S0223");
        Stock stock2 = new Stock("stock2", "S0445");

        StockDao stockDao = new StockDao();
        stockDao.create(stock1);
        stockDao.create(stock2);

        List<Stock> stocks = stockDao.findAllWithHqlQuery();
        System.out.println("--- stocks: " + stocks);

        List<Stock> filteredStocks = stockDao.findAllByStockCodeWithHqlQuery("S0223");
        System.out.println("--- filteredStocks: " + filteredStocks);
    }
}

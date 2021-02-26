package com.sda.cohesion.high;

public class DemoHighCohesion {

    public static void main(String[] args) {
        InternetDownloader internetDownloader = new InternetDownloader();
        DataParser dataParser = new DataParser();
        DataStore dataStore = new DataStore();

        internetDownloader.downloadFromInternet();
        dataParser.parseData();
        dataStore.storeInDatabase();
    }
}

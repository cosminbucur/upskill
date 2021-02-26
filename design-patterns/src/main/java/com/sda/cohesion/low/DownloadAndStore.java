package com.sda.cohesion.low;

public class DownloadAndStore {

    public void doEverything() {
        downloadFromInternet();
        parseData();
        storeInDatabase();
    }

    private void downloadFromInternet() {
        System.out.println("downloading...");
    }

    private void parseData() {
        System.out.println("reading the downloaded file...");
    }

    private void storeInDatabase() {
        System.out.println("saving in the db...");
    }
}

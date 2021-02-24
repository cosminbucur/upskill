package com.sda.advanced.concurrency.deadlock;

public class DemoDeadlock {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Scanner scanner = new Scanner();

        Thread robert = new Thread(new PrintAndScan(printer, scanner), "robert");
        Thread ana = new Thread(new ScanAndPrint(printer, scanner), "ana");

        robert.start();
        ana.start();
    }
}

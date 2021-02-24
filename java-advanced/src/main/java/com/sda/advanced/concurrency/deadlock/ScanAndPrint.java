package com.sda.advanced.concurrency.deadlock;

public class ScanAndPrint implements Runnable {

    private final Printer printer;
    private final Scanner scanner;

    public ScanAndPrint(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        synchronized (printer) {
            try {
                scanner.scan();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " finished scanning");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " waiting for printer");
            synchronized (scanner) {
                printer.print();
                System.out.println(Thread.currentThread().getName() + " is printing");
            }

            System.out.println(Thread.currentThread().getName() + " finished printing");
        }
    }
}

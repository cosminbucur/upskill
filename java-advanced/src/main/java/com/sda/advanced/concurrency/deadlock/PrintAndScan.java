package com.sda.advanced.concurrency.deadlock;

public class PrintAndScan implements Runnable {

    private final Printer printer;
    private final Scanner scanner;

    public PrintAndScan(Printer printer, Scanner scanner) {
        this.printer = printer;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        synchronized (printer) {
            try {
                printer.print();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " finished printing");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " waiting for scanner");
            synchronized (scanner) {
                scanner.scan();
                System.out.println(Thread.currentThread().getName() + " is scanning");
            }
            System.out.println(Thread.currentThread().getName() + " finished scanning");
        }
    }
}

package com.sda.dry.after;

public class Mechanic {

    public void serviceCar() {
        System.out.println("servicing car");
        performOtherTasks();
    }

    public void serviceBike() {
        System.out.println("servicing bike");
        performOtherTasks();
    }

    public void performOtherTasks() {
        System.out.println("perform tasks other than servicing");
    }
}

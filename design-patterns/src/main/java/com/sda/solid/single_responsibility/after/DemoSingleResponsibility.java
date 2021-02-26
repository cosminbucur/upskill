package com.sda.solid.single_responsibility.after;

public class DemoSingleResponsibility {

    public static void main(String[] args) {
        Employee employee = new Employee();
        HRPromotions hrPromotions = new HRPromotions();
        TaxCalculator taxCalculator = new TaxCalculator();

        hrPromotions.isPromotionDueThisYear(employee);
        taxCalculator.calculateTaxForCurrentYear(employee);
    }
}

package com.sda.fundamentals.conditionals;

public class DemoSwitch {

    public static void main(String[] args) {
        // 1. fast food menu
        // 2. regular menu
        // 3. vegan menu
        // 5. unknown option

        // SHIFT + TAB align left
        // TAB = align right
        int option = 3;
        switch (option) {
            case 1:
                System.out.println("fast food menu");
                break;
            case 2:
                System.out.println("regular menu");
                break;
            case 3:
                System.out.println("vegan menu");
                break;
            default:
                System.out.println("unknown option");
        }
    }
}

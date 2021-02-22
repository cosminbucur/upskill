package com.sda.advanced.functional.method_reference.instance;

import java.util.Comparator;

public class BoatComparator implements Comparator<Boat> {

    // - 1 0 1
    @Override
    public int compare(Boat first, Boat second) {
        return first.getLength().compareTo(second.getLength());
    }
}

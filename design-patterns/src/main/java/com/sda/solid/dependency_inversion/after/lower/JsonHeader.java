package com.sda.solid.dependency_inversion.after.lower;

import com.sda.solid.dependency_inversion.after.higher.IHeader;

public class JsonHeader implements IHeader {
    @Override
    public void build() {
        System.out.println("build json");
    }
}

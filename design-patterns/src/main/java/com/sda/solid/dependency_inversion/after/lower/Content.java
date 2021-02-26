package com.sda.solid.dependency_inversion.after.lower;

import com.sda.solid.dependency_inversion.after.higher.IContent;

public class Content implements IContent {

    @Override
    public void build() {
        System.out.println("content");
    }
}

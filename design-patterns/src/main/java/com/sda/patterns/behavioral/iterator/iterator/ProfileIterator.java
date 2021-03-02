package com.sda.patterns.behavioral.iterator.iterator;

import com.sda.patterns.behavioral.iterator.network.Profile;

public interface ProfileIterator {

    boolean hasNext();

    Profile getNext();
}

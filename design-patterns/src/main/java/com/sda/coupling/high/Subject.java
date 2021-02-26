package com.sda.coupling.high;

public class Subject {

    private Topic topic = new Topic();

    public void startReading() {
        topic.understand();
    }
}

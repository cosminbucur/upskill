package com.sda.coupling.loose;

public class DemoLooseCoupling {

    public static void main(String[] args) {
        Topic topic1 = new Topic1();
        Topic topic2 = new Topic1();
        Subject subject = new Subject(topic1);
        subject.startReading();
    }
}

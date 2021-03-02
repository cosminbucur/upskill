package com.sda.patterns.behavioral.observer;

import org.junit.jupiter.api.Test;

class MessagePublisherTest {

    @Test
    void testObserver() {
        Subject publisher = new MessagePublisher();

        Observer subscriber1 = new SubscriberOne();
        Observer subscriber2 = new SubscriberTwo();

        publisher.registerObserver(subscriber1);
        publisher.registerObserver(subscriber2);

        publisher.notifyUpdate(new Message("price decreased"));
        publisher.removeObserver(subscriber2);

        publisher.notifyUpdate(new Message("price decreased"));

    }
}
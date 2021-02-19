package com.sda.advanced.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class DemoQueue {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i <= 5; i++) {
            queue.add(i);
        }

        // print queue
        System.out.println("elements " + queue);

        // just read the head of queue
        Integer head = queue.peek();

        // always remove first element
        Integer deletedElement = queue.remove();
        System.out.println(deletedElement);

        // read and remove the head of queue
        Integer firstElement = queue.poll();

        int queueSize = queue.size();
        if (queueSize == 0) {
            System.out.println("completed");
        }
    }
}

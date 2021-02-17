package com.sda.advanced.collections.stack;

import java.util.Stack;

public class DemoStack {

    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(2);  // 2
        stack.push(1);  // 2 1

        System.out.println(stack.pop());    // 2

        System.out.println(stack.empty());  // false

        System.out.println(stack.peek());   // 2

        System.out.println("search " + stack.search(2));    // 1

        System.out.println(stack.size());
    }
}

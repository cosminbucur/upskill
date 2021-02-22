package com.sda.advanced.functional.method_reference.constructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoConstructor {

    public static void main(String[] args) {
        // create command from string
        new Command("REBOOT");

        // interface = lambda expression
        Robot robot = (order) -> new Command(order);
        Command reboot = robot.execute("REBOOT");

        List<String> commandLines = Arrays.asList("JUMP", "PUNCH", "SHOOT");

        List<Command> result = new ArrayList<>();

        // old school
        for (String commandString : commandLines) {
            System.out.println(new Command(commandString));
        }

        // constructor method reference
        commandLines.stream()
                .map(Command::new)
                .forEach(System.out::println);
    }
}

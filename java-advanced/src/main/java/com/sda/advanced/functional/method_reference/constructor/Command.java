package com.sda.advanced.functional.method_reference.constructor;

public class Command {

    private String commandLine;

    public Command(String commandLine) {
        this.commandLine = commandLine;
        System.out.println("command line: " + commandLine);
    }

    @Override
    public String toString() {
        return "Command{" +
                "commandLine='" + commandLine + '\'' +
                '}';
    }
}

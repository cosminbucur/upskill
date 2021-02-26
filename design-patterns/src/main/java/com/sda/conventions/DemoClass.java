package com.sda.conventions;

import java.util.Objects;

/**
 * Some class comment
 */
public class DemoClass {

    // static variables
    private static final String STATIC_VARIABLE = "30";
    // instance variable
    private int instanceVariable;

    // static block
    {
        int x = 1;
    }

    // constructor
    public DemoClass() {
        // default
    }

    public DemoClass(int instanceVariable) {
        this.instanceVariable = instanceVariable;
    }

    // method
    public void doPublicWork() {
        privateMethod();
    }

    private void privateMethod() {

    }

    // helper methods

    // getters and setters
    public int getInstanceVariable() {
        return instanceVariable;
    }

    public void setInstanceVariable(int instanceVariable) {
        this.instanceVariable = instanceVariable;
    }

    // equals and hashcode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoClass demoClass = (DemoClass) o;
        return instanceVariable == demoClass.instanceVariable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(instanceVariable);
    }

    // to string
    @Override
    public String toString() {
        return "DemoClass{" +
                "instanceVariable=" + instanceVariable +
                '}';
    }
}

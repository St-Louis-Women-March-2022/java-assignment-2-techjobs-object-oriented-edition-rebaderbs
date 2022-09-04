package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Employer {

    private int id;
    private static int nextId = 1;
    //static so the changing value is NOT stored in any Employer object
    private String value;

    public Employer() {
        id = nextId;
        nextId++;
        //first constructor: no arguments; assigns value of id = nextId;
        //increments nextId by 1 so that EVERY Employer object will have a different ID#
    }

    public Employer(String value) {
        this();
        this.value = value;
        //second constructor: assigns a value to value field;
        //initializes id for the object by calling 1st constructor with this() - REMEMBER this() or super() must be first statement in constructor!!!!
        //including this() will make initializing the ID a default behavior
    }

    // Custom toString, equals, and hashCode methods:

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) return true;
        if (!(o instanceof Employer)) return false;
        Employer employer = (Employer) o;
        return getId() == employer.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

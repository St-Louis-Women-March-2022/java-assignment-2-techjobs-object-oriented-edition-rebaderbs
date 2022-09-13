package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    //common fields:
    protected int id;
    private static int nextId = 1;
    private String value;

    //common constructors:
    public JobField() {
        id = nextId;
        nextId++;
    }
    public JobField(String value) {
        this();
        this.value = value;
    }

    // toString, equals, hashCode methods
    @Override
    public String toString()    {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobField)) return false;
//        if (o == null || getClass() != o.getClass()) return false;
        JobField jobField = (JobField) o;
        return getId() == jobField.getId();
//        return id == jobField.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
//        return Objects.hash(id);
    }

    // getters and setters
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

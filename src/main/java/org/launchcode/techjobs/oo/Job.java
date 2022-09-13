package org.launchcode.techjobs.oo;

import java.lang.reflect.Field;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job()    {
        id = nextId;
        nextId++;
    }
    //2nd constructor: 5 parameters - one for each field above; call the 1st constructor on first line using this() to initialize the id;
    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency)    {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    //custom toString method
    @Override
    public String toString()    {
        if (this.getName().equals(""))  {
            this.setName(("Data not available"));
        }
        if (this.getEmployer().getValue().equals(""))   {
            this.setEmployer(new Employer("Data not available"));
        }
        if (this.getLocation().getValue().equals(""))   {
            this.setLocation(new Location("Data not available"));
        }
        if (this.getPositionType().getValue().equals(""))   {
            this.setPositionType(new PositionType("Data not available"));
        }
        if (this.getCoreCompetency().getValue().equals(""))   {
            this.setCoreCompetency(new CoreCompetency("Data not available"));
        }

        return "\n" + "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Employer: " + employer + "\n" +
                "Location: " + location + "\n" +
                "Position Type: " + positionType + "\n" +
                "Core Competency: " + coreCompetency + "\n";
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    //I only selected int id and unchecked the rest of the fields
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Location getLocation() {
        return location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

}

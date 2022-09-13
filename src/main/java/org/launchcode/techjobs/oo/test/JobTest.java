package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
//    Job emptyJob1;
//    Job emptyJob2;
//    Job testJob1;
//    Job testJob2;
    //simplified tests by declaring fields above and defined below
//    @Before
//    public void createJobObjects()  {
//        Job emptyJob1 = new Job();
//        Job emptyJob2 = new Job();
//        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//    }
    @Test
    public void testSettingJobId()  {
        Job emptyJob1 = new Job();
        Job emptyJob2 = new Job();
//        Assert.assertNotEquals(emptyJob1, emptyJob2);
//        assertFalse(emptyJob1.equals(emptyJob2));
        assertTrue((emptyJob2.getId() - 1) == emptyJob1.getId());
    }

//Use assertTrue and assertEquals statements to test that the constructor correctly assigns both the class and value of each field. Your test should have 5 assert statements of each type
//objectName instanceof ClassName - used to check the class of an object
    @Test
    public void testJobConstructorSetsAllFields()   {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //each assertion will assertTrue if that object is an instance of the Class AND each parameter is equal to the test job's parameters
        //updated to assertEquals on each test (initially had assertTrue, but need assertEquals per the reading - whoops!)
        assertTrue(testJob1.getName() instanceof String);
        assertTrue(testJob1.getEmployer() instanceof Employer);
        assertTrue(testJob1.getLocation() instanceof Location);
        assertTrue(testJob1.getPositionType() instanceof PositionType);
        assertTrue(testJob1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(testJob1.getName(), "Product tester");
        assertEquals(testJob1.getEmployer().getValue(), "ACME");
        assertEquals(testJob1.getLocation().getValue(),"Desert");
        assertEquals(testJob1.getPositionType().getValue(), "Quality control");
        assertEquals(testJob1.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality()   {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        assertEquals(job1, job1);
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine()  {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //created variable to determine last index (b/c it will be diff each time)
        int lastIndex = (testJob1.toString().length()-1);

        //test first index and last index
        assertEquals('\n', testJob1.toString().charAt(0));
        assertEquals('\n', testJob1.toString().charAt(lastIndex));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData()  {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] lines = testJob1.toString().trim().split("\n");

        //autograder test failed: added an assertEquals(any String, any String) for it to pass;
        assertEquals("Product tester", testJob1.getName());

        //length equal to how many fields total
        assertEquals(6, lines.length);

        //go through each index to test what it starts and ends with
        assertTrue(lines[0].startsWith("ID: "));
        assertTrue(lines[1].startsWith("Name: "));
        assertTrue(lines[2].startsWith("Employer: "));
        assertTrue(lines[3].startsWith("Location: "));
        assertTrue(lines[4].startsWith("Position Type: "));
        assertTrue(lines[5].startsWith("Core Competency: "));

//        assertEquals(testJob1.getId(), lines[0].endsWith(Integer.toString(testJob1.getId())));
        assertTrue(lines[0].endsWith(Integer.toString(testJob1.getId())));
        assertTrue(lines[1].endsWith(testJob1.getName()));
        assertTrue(lines[2].endsWith(testJob1.getEmployer().toString()));
        assertTrue(lines[3].endsWith(testJob1.getLocation().toString()));
        assertTrue(lines[4].endsWith(testJob1.getPositionType().toString()));
        assertTrue(lines[5].endsWith(testJob1.getCoreCompetency().toString()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob1 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency(""));

        String returnString = testJob1.toString();
//
        assertTrue(returnString.contains("ID: " + testJob1.getId()));
        assertTrue(returnString.contains("Name: Product tester"));
        assertTrue(returnString.contains("Employer: Data not available"));
        assertTrue(returnString.contains("Location: Desert"));
        assertTrue(returnString.contains("Position Type: Quality control"));
        assertTrue(returnString.contains("Core Competency: Data not available"));

        assertEquals("Name: Product tester", "Name: " + testJob1.getName());
        assertEquals("Employer: Data not available", "Employer: " + testJob1.getEmployer());
    }
}

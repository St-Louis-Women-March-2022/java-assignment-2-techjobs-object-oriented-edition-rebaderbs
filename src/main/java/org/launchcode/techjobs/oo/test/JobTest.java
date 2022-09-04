package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId()  {
        Job test_job1 = new Job();
        Job test_job2 = new Job();
        Assert.assertNotEquals(test_job1, test_job2);
    }

//Use assertTrue and assertEquals statements to test that the constructor correctly assigns both the class and value of each field. Your test should have 5 assert statements of each type
//objectName instanceof ClassName - used to check the class of an object
    @Test
    public void testJobConstructorSetsAllFields()   {
        Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //each assertion will assertTrue if that object is an instance of the Class AND each parameter is equal to the test job's parameters
        //updated to assertEquals on each test (initially had assertTrue, but need assertEquals per the reading - whoops!)
        Assert.assertTrue(test_job3 instanceof Job);
        Assert.assertEquals(test_job3.getName(), "Product tester");

        Assert.assertTrue(test_job3.getEmployer() instanceof Employer);
        Assert.assertEquals(test_job3.getEmployer().getValue(), "ACME");

        Assert.assertTrue(test_job3.getLocation() instanceof Location);
        Assert.assertEquals(test_job3.getLocation().getValue(),"Desert");

        Assert.assertTrue(test_job3.getPositionType() instanceof PositionType);
        Assert.assertEquals(test_job3.getPositionType().getValue(), "Quality control");

        Assert.assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
        Assert.assertEquals(test_job3.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality()   {
        Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(test_job3.equals(test_job4));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine()  {
        Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //created variable to determine last index (b/c it will be diff each time)
        int lastIndex = (test_job3.toString().length()-1);

        //test first index and last index
        Assert.assertTrue(test_job3.toString().charAt(0) == '\n');
        Assert.assertTrue(test_job3.toString().charAt(lastIndex) =='\n');
    //TEST PASSES
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData()  {
        Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String[] lines = test_job3.toString().trim().split("\n");

        System.out.print(test_job3.toString());

        //length equal to how many fields total
        assertTrue(lines.length == 6);

        //go through each index to test what it starts and ends with
        assertTrue(lines[0].startsWith("ID: "));
        assertTrue(lines[1].startsWith("Name: "));
        assertTrue(lines[2].startsWith("Employer: "));
        assertTrue(lines[3].startsWith("Location: "));
        assertTrue(lines[4].startsWith("Position Type: "));
        assertTrue(lines[5].startsWith("Core Competency: "));

        assertTrue(lines[0].endsWith(Integer.toString(test_job3.getId())));
        assertTrue(lines[1].endsWith(test_job3.getName()));
        assertTrue(lines[2].endsWith(test_job3.getEmployer().toString()));
        assertTrue(lines[3].endsWith(test_job3.getLocation().toString()));
        assertTrue(lines[4].endsWith(test_job3.getPositionType().toString()));
        assertTrue(lines[5].endsWith(test_job3.getCoreCompetency().toString()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job test_job1 = new Job();

        String[] lines = test_job1.toString().trim().split("\n");

        System.out.print(test_job1.toString());

        //remove ID field (index 0) that ALWAYS contains data so it shows no data available
        List<String> list = new ArrayList<String>(Arrays.asList(lines));
        list.remove(0);
        lines = list.toArray(new String[0]);

        String emptyIdField = "Data not available";

        for (String line : lines)   {
            assertTrue(line.endsWith(emptyIdField));
        }
    }
}

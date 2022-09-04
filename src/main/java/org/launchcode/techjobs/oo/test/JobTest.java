package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

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
        Assert.assertTrue(test_job3 instanceof Job);
        Assert.assertTrue(test_job3.getName() == "Product tester");

        Assert.assertTrue(test_job3.getEmployer() instanceof Employer);
        Assert.assertTrue(test_job3.getEmployer().getValue() == "ACME");

        Assert.assertTrue(test_job3.getLocation() instanceof Location);
        Assert.assertTrue(test_job3.getLocation().getValue() == "Desert");

        Assert.assertTrue(test_job3.getPositionType() instanceof PositionType);
        Assert.assertTrue(test_job3.getPositionType().getValue() == "Quality control");

        Assert.assertTrue(test_job3.getCoreCompetency() instanceof CoreCompetency);
        Assert.assertTrue(test_job3.getCoreCompetency().getValue() == "Persistence");
    }

    @Test
    public void testJobsForEquality()   {
        Job test_job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job test_job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(test_job3.equals(test_job4));
    }

}

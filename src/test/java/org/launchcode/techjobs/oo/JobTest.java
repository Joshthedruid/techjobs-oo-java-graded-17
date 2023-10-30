package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1,job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job1.getName(),"Product tester");
        assertEquals(job1.getCoreCompetency().getValue(), "Persistence");
        assertEquals(job1.getEmployer().getValue(), "ACME");
        assertEquals(job1.getLocation().getValue(), "Desert");
        assertEquals(job1.getPositionType().getValue(), "Quality control");

        assertTrue(job1 instanceof Job);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job myJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String myString = myJob.toString();
        char[] s = System.lineSeparator().toCharArray();
        assertTrue(myString.startsWith(String.valueOf(s[0])) || myString.startsWith(String.valueOf(s[1])));
        assertTrue(myString.endsWith(String.valueOf(s[0])) || myString.endsWith(String.valueOf(s[1])));
    }

    @Test
     public void testToStringContainsCorrectLabelsAndData(){
        Job myJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String myString = myJob.toString();
        String[] chopString = myString.split(System.lineSeparator());
        assertEquals(chopString[1], "ID: " + myJob.getId());
        assertEquals(chopString[2], "Name: Product tester");
        assertEquals(chopString[3], "Employer: ACME");
        assertEquals(chopString[4], "Location: Desert");
        assertEquals(chopString[5], "Position Type: Quality control");
        assertEquals(chopString[6], "Core Competency: Persistence");
    }

    @Test
    public void testToStringHandlesEmptyField(){
        Job myJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String myString = myJob.toString();
        String[] chopString = myString.split(System.lineSeparator());
        assertEquals(chopString[3], "Employer: Data not available");
    }
}

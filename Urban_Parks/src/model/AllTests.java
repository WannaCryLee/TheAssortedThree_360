/*
 /*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
 
package model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
/**
 * Run all the JUnit tests at once
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ AdminTest.class, CerealTest.class, VolunteerTest.class, ParkManagerTest.class, JobTest.class, LogInTest.class, ValidateJobTest.class })

public class AllTests {

}

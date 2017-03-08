package edu.uniandes.ecos.CAIS.P3PSP2;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest
        extends TestCase {

    private Program program3;

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest(String testName) {
        super(testName);
        this.program3 = new Program();
        String path = System.getProperty("user.dir");
        path += "/src/resources/files";
        this.program3.readFiles(path);
        this.program3.setXk(386.0);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AppTest.class);
    }

    public void testCaseOne() {
        this.program3.createCase(2, 0);
        assertEquals("B1 debe ser 1.7279", 1.7279, this.program3.getB1(), 0.01);
        assertEquals("B0 debe ser -22.55", -22.55, this.program3.getB0(), 0.01);
        assertEquals("Rxy debe ser 0.9545", 0.9545, this.program3.getRxy(), 0.01);
        assertEquals("R2 debe ser 0.9111", 0.9111, this.program3.getR2(), 0.01);
        assertEquals("Yk debe ser 644.429", 644.429, this.program3.getYk(), 0.01);
    }

    public void testCaseTwo() {
        this.program3.createCase(2, 1);
        assertEquals("B1 debe ser 0.1681", 0.1681, this.program3.getB1(), 0.01);
        assertEquals("B0 debe ser -4.039", -4.039, this.program3.getB0(), 0.01);
        assertEquals("Rxy debe ser 0.9333", 0.9333, this.program3.getRxy(), 0.01);
        assertEquals("R2 debe ser 0.8711", 0.8711, this.program3.getR2(), 0.01);
        assertEquals("Yk debe ser 60.858", 60.858, this.program3.getYk(), 0.01);

    }

    public void testCaseThree() {
        this.program3.createCase(3, 0);
        assertEquals("B1 debe ser 1.43097", 1.43097, this.program3.getB1(), 0.01);
        assertEquals("B0 debe ser -23.92", -23.92, this.program3.getB0(), 0.01);
        assertEquals("Rxy debe ser 1.43097", 0.9545, this.program3.getRxy(), 0.01);
        assertEquals("R2 debe ser 0.9276", 0.9276, this.program3.getR2(), 0.01);
        assertEquals("Yk debe ser 528.4294", 528.4294, this.program3.getYk(), 0.01);
    }

    public void testCaseFour() {
        this.program3.createCase(3, 1);
        assertEquals("B1 debe ser 0.140164", 0.140164, this.program3.getB1(), 0.01);
        assertEquals("B0 debe ser -4.604", -4.604, this.program3.getB0(), 0.01);
        assertEquals("Rxy debe ser 0.9480", 0.9480, this.program3.getRxy(), 0.01);
        assertEquals("R2 debe ser 0.8988", 0.8988, this.program3.getR2(), 0.01);
        assertEquals("Yk debe ser 49.4994", 49.4994, this.program3.getYk(), 0.01);
    }
    
}

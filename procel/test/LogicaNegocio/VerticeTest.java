/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ingesis
 */
public class VerticeTest {
    
    public VerticeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInfo method, of class Vertice.
     */
    @Test
    public void testGetInfo() {
        System.out.println("getInfo");
        Vertice instance = new Vertice();
        Object expResult = null;
        Object result = instance.getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInfo method, of class Vertice.
     */
    @Test
    public void testSetInfo() {
        System.out.println("setInfo");
        Object info = null;
        Vertice instance = new Vertice();
        instance.setInfo(info);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMarca method, of class Vertice.
     */
    @Test
    public void testGetMarca() {
        System.out.println("getMarca");
        Vertice instance = new Vertice();
        boolean expResult = false;
        boolean result = instance.getMarca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMarca method, of class Vertice.
     */
    @Test
    public void testSetMarca() {
        System.out.println("setMarca");
        boolean marca = false;
        Vertice instance = new Vertice();
        instance.setMarca(marca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSubindice method, of class Vertice.
     */
    @Test
    public void testGetSubindice() {
        System.out.println("getSubindice");
        Vertice instance = new Vertice();
        int expResult = 0;
        int result = instance.getSubindice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSubindice method, of class Vertice.
     */
    @Test
    public void testSetSubindice() {
        System.out.println("setSubindice");
        int subindice = 0;
        Vertice instance = new Vertice();
        instance.setSubindice(subindice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

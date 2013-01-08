/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

import Modelo.Vertice;
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
    }

    /**
     * Test of getSubindice method, of class Vertice.
     */
    @Test
    public void testGetSubindice() {
        System.out.println("getSubindice");
        Vertice instance = new Vertice();
        int expResult = 0;
        long result = instance.getSubindice();
        assertEquals(expResult, result);
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
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

import Modelo.Arco;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jhurtado
 */
public class ArcoTest {
    
    public ArcoTest() {
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
     * Test of getVerticeInicial method, of class Arco.
     */
    @Test
    public void testGetVi() {
        System.out.println("getVerticeInicial");
        Arco instance = new Arco(1,2,3);
        int expResult = 1;
        long result = instance.getVerticeInicial();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVerticeInicial method, of class Arco.
     */
    @Test
    public void testSetVi() {
        System.out.println("setVerticeInicial");
        int vi = 5;
        Arco instance = new Arco(1,2,3);
        instance.setVerticeInicial(vi);
        assertEquals(vi,instance.getVerticeInicial());
}

    /**
     * Test of getVerticeFinal method, of class Arco.
     */
    @Test
    public void testGetVj() {
        System.out.println("getVerticeFinal");
        Arco instance = new Arco(6,7,9);
        int expResult = 7;
        long result = instance.getVerticeFinal();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVerticeFinal method, of class Arco.
     */
    @Test
    public void testSetVj() {
        System.out.println("setVerticeFinal");
        int vj = 5;
        Arco instance =new Arco(9,8,7) ;
        instance.setVerticeFinal(vj);
        assertEquals(vj,instance.getVerticeFinal());
    }

    /**
     * Test of getCosto method, of class Arco.
     */
    @Test
    public void testGetCosto() {
        System.out.println("getCosto");
        Arco instance = new Arco(4,5,6);
        int expResult = 6;
        int result = instance.getCosto();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCosto method, of class Arco.
     */
    @Test
    public void testSetCosto() {
        System.out.println("setCosto");
        int costo = 12;
        Arco instance = new Arco(12,13,10);
        instance.setCosto(costo);
        assertEquals(costo,instance.getCosto());
    }
}

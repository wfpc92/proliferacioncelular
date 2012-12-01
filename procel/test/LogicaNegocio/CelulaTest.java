/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

import Modelo.Celula;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jhurtado
 */
public class CelulaTest {
    
    public CelulaTest() {
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
     * Test of getLongLado method, of class Celula.
     */
    @Test
    public void testGetLongLado() {
        System.out.println("getLongLado");
        Celula instance = new Celula(123,3.4,4);
        double expResult = 3.4;
        double result = instance.getLongLado();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setLongLado method, of class Celula.
     */
    @Test
    public void testSetLongLado() {
        System.out.println("setLongLado");
        double longLado = 5.7;
        Celula instance = new Celula(123,3.4,4);
        instance.setLongLado(longLado);
         Assert.assertEquals(longLado, instance.getLongLado());
    }

    /**
     * Test of getNumLado method, of class Celula.
     */
    @Test
    public void testGetNumLado() {
        System.out.println("getNumLado");
        Celula instance = new Celula(123,3.4,4);
        int expResult = 4;
        int result = instance.getNumLado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumLado method, of class Celula.
     */
    @Test
    public void testSetNumLado() {
        System.out.println("setNumLado");
        int numLado = 15;
        Celula instance = new Celula(123,3.4,4);
        instance.setNumLado(numLado);
        assertEquals(numLado, instance.getNumLado());
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Celula.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Celula instance = new Celula(123,3.4,4);
        int expResult = 123;
        long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Celula.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 321;
        Celula instance = new Celula(123,3.4,4);
        instance.setId(id);
        assertEquals(id, instance.getId());
        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
        
    }
}

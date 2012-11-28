/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
     * Test of getVi method, of class Arco.
     */
    @Test
    public void testGetVi() {
        System.out.println("getVi");
        Arco instance = new Arco(1,2,3);
        int expResult = 1;
        long result = instance.getVi();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVi method, of class Arco.
     */
    @Test
    public void testSetVi() {
        System.out.println("setVi");
        int vi = 5;
        Arco instance = new Arco(1,2,3);
        instance.setVi(vi);
        assertEquals(vi,instance.getVi());
}

    /**
     * Test of getVj method, of class Arco.
     */
    @Test
    public void testGetVj() {
        System.out.println("getVj");
        Arco instance = new Arco(6,7,9);
        int expResult = 7;
        long result = instance.getVj();
        assertEquals(expResult, result);
    }

    /**
     * Test of setVj method, of class Arco.
     */
    @Test
    public void testSetVj() {
        System.out.println("setVj");
        int vj = 5;
        Arco instance =new Arco(9,8,7) ;
        instance.setVj(vj);
        assertEquals(vj,instance.getVj());
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

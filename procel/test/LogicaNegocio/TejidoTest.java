/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

import Modelo.Grafo;
import Modelo.Tejido;
import Modelo.Celula;
import java.util.ArrayList;
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
public class TejidoTest {
    
    public TejidoTest() {
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
     * Test of getId method, of class Tejido.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        ArrayList listaPruebaV = new ArrayList();
        ArrayList listaPruebaA = new ArrayList();
        listaPruebaV.add(1);
        listaPruebaA.add(2);
        Grafo TejidoG= new Grafo(listaPruebaV,listaPruebaA);
        Tejido instance = new Tejido(1,"Tejido 1");
        instance.setTamMuestra(12);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Tejido.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        ArrayList listaPruebaV = new ArrayList();
        ArrayList listaPruebaA = new ArrayList();
        listaPruebaV.add(1);
        listaPruebaA.add(2);
        Grafo TejidoG= new Grafo(listaPruebaV,listaPruebaA);
        int id = 2;
        Tejido instance = new Tejido(1,"Tejido 1");
        instance.setTamMuestra(12);
        instance.setId(id);
        assertEquals(id,instance.getId());        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Tejido.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        ArrayList listaPruebaV = new ArrayList();
        ArrayList listaPruebaA = new ArrayList();
        listaPruebaV.add(1);
        listaPruebaA.add(2);
        Grafo TejidoG= new Grafo(listaPruebaV,listaPruebaA);
        Tejido instance = new Tejido(1,"Tejido 1");
        instance.setTamMuestra(12);
        String expResult = "Tejido 1";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Tejido.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        ArrayList listaPruebaV = new ArrayList();
        ArrayList listaPruebaA = new ArrayList();
        listaPruebaV.add(1);
        listaPruebaA.add(2);
        Grafo TejidoG= new Grafo(listaPruebaV,listaPruebaA);
        String nombre = "Tejido1.1";
        Tejido instance = new Tejido(1,"Tejido 1");
        instance.setTamMuestra(12);
        instance.setNombre(nombre);
        assertEquals(nombre,instance.getNombre());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getTejidoG method, of class Tejido.
     */
    @Test
    public void testGetTejidoG() {
        System.out.println("getTejidoG");
        ArrayList listaPruebaV = new ArrayList();
        ArrayList listaPruebaA = new ArrayList();
        listaPruebaV.add(1);
        listaPruebaA.add(2);
        Grafo TejidoG= new Grafo(listaPruebaV,listaPruebaA);
        Tejido instance = new Tejido(1,"Tejido 1");
        instance.setTamMuestra(12);
        Grafo expResult = new Grafo(listaPruebaV,listaPruebaA);
        Grafo result = instance.getTejidoG();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTejidoG method, of class Tejido.
     */
    @Test
    public void testSetTejidoG() {
        System.out.println("setTejidoG");
        ArrayList listaPruebaV = new ArrayList();
        ArrayList listaPruebaA = new ArrayList();
        listaPruebaV.add(1);
        listaPruebaA.add(2);
        Grafo TejidoG= new Grafo(listaPruebaV,listaPruebaA);
        Tejido instance = new Tejido(1,"Tejido 1");
        instance.setTamMuestra(12);
        ArrayList listaPruebaV1 = new ArrayList();
        ArrayList listaPruebaA1= new ArrayList();
        listaPruebaV.add(3);
        listaPruebaA.add(4);
        Grafo TegidoG1 = new Grafo(listaPruebaV1,listaPruebaA1);
        instance.setTejidoG(TegidoG1);
        assertEquals(TegidoG1,instance.getTejidoG());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}

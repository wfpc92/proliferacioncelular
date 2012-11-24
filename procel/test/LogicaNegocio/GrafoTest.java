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
public class GrafoTest {
    
    public GrafoTest() {
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
     * Test of getLista_vertices method, of class Grafo.
     */
    @Test
    public void testGetLista_vertices() {
        System.out.println("getLista_vertices");
        
        Grafo instance = new Grafo(ListaA,listaB,6);
        ListaVertice expResult = null;
        ListaVertice result = instance.getLista_vertices();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLista_vertices method, of class Grafo.
     */
    @Test
    public void testSetLista_vertices() {
        System.out.println("setLista_vertices");
        Grafo instance = new Grafo();
        instance.setLista_vertices(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLista_arcos method, of class Grafo.
     */
    @Test
    public void testGetLista_arcos() {
        System.out.println("getLista_arcos");
        Grafo instance = new Grafo();
        ListaArco expResult = null;
        ListaArco result = instance.getLista_arcos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLista_arcos method, of class Grafo.
     */
    @Test
    public void testSetLista_arcos() {
        System.out.println("setLista_arcos");
        Grafo instance = new Grafo();
        instance.setLista_arcos(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarVertice method, of class Grafo.
     */
    @Test
    public void testAgregarVertice() {
        System.out.println("AgregarVertice");
        int info = 0;
        int sub = 0;
        Grafo instance = new Grafo();
        instance.AgregarVertice(info, sub);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarArco method, of class Grafo.
     */
    @Test
    public void testAgregarArco() {
        System.out.println("AgregarArco");
        int vi = 0;
        int vj = 0;
        int costo = 0;
        Grafo instance = new Grafo();
        instance.AgregarArco(vi, vj, costo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ElimVertice method, of class Grafo.
     */
    @Test
    public void testElimVertice() {
        System.out.println("ElimVertice");
        int subindice = 0;
        Grafo instance = new Grafo();
        instance.ElimVertice(subindice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ElimArco method, of class Grafo.
     */
    @Test
    public void testElimArco() {
        System.out.println("ElimArco");
        int vi = 0;
        int vj = 0;
        Grafo instance = new Grafo();
        instance.ElimArco(vi, vj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CostoArco method, of class Grafo.
     */
    @Test
    public void testCostoArco() {
        System.out.println("CostoArco");
        int vi = 0;
        int vj = 0;
        Grafo instance = new Grafo();
        int expResult = 0;
        int result = instance.CostoArco(vi, vj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of InfoVertice method, of class Grafo.
     */
    @Test
    public void testInfoVertice() {
        System.out.println("InfoVertice");
        int v = 0;
        Grafo instance = new Grafo();
        int expResult = 0;
        int result = instance.InfoVertice(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Sucesores method, of class Grafo.
     */
    @Test
    public void testSucesores() {
        System.out.println("Sucesores");
        Grafo instance = new Grafo();
        Lista expResult = null;
        Lista result = instance.Sucesores(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordenGrafo method, of class Grafo.
     */
    @Test
    public void testOrdenGrafo() {
        System.out.println("ordenGrafo");
        Grafo instance = new Grafo();
        int expResult = 0;
        int result = instance.ordenGrafo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MarcarVertice method, of class Grafo.
     */
    @Test
    public void testMarcarVertice() {
        System.out.println("MarcarVertice");
        Grafo instance = new Grafo();
        instance.MarcarVertice(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DesmarcarVertice method, of class Grafo.
     */
    @Test
    public void testDesmarcarVertice() {
        System.out.println("DesmarcarVertice");
        Grafo instance = new Grafo();
        instance.DesmarcarVertice(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MarcadoVertice method, of class Grafo.
     */
    @Test
    public void testMarcadoVertice() {
        System.out.println("MarcadoVertice");
        Grafo instance = new Grafo();
        boolean expResult = false;
        boolean result = instance.MarcadoVertice(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DesmarcarGrafo method, of class Grafo.
     */
    @Test
    public void testDesmarcarGrafo() {
        System.out.println("DesmarcarGrafo");
        Grafo instance = new Grafo();
        instance.DesmarcarGrafo(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Camino method, of class Grafo.
     */
    @Test
    public void testCamino() {
        System.out.println("Camino");
        Grafo instance = new Grafo();
        Lista expResult = null;
        Lista result = instance.Camino(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SiguienteVertice method, of class Grafo.
     */
    @Test
    public void testSiguienteVertice() {
        System.out.println("SiguienteVertice");
        Grafo instance = new Grafo();
        int expResult = 0;
        int result = instance.SiguienteVertice(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Dijkstra method, of class Grafo.
     */
    @Test
    public void testDijkstra() {
        System.out.println("Dijkstra");
        Grafo instance = new Grafo();
        int[] expResult = null;
        int[] result = instance.Dijkstra(null);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of min method, of class Grafo.
     */
    @Test
    public void testMin() {
        System.out.println("min");
        int a = 0;
        int b = 0;
        Grafo instance = new Grafo();
        int expResult = 0;
        int result = instance.min(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocio;

import java.util.ArrayList;
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
        
        ArrayList listaAPrueba = new ArrayList();
        ArrayList listaBPrueba = new ArrayList();
        Grafo instance = new Grafo();
        ArrayList a=instance.getLista_vertices();
        assertEquals(a,listaAPrueba);
    }

    /**
     * Test of setLista_vertices method, of class Grafo.
     */
    @Test
    public void testSetLista_vertices() {
        
        System.out.println("setLista_vertices");
        ArrayList listaCPrueba = new ArrayList();
        listaCPrueba.add(1);
        Grafo instance = new Grafo();
        instance.setLista_vertices(listaCPrueba);
        assertEquals(instance.getLista_vertices(),listaCPrueba);
   
    }

    /**
     * Test of getLista_arcos method, of class Grafo.
     */
    @Test
    public void testGetLista_arcos() {
        System.out.println("getLista_arcos");
        ArrayList listaAPrueba = new ArrayList();
        ArrayList listaBPrueba = new ArrayList();
        listaAPrueba.add(1);
        listaBPrueba.add(2);
        Grafo instance = new Grafo(listaAPrueba,listaBPrueba);
        assertEquals(instance.getListaArcos(),listaBPrueba);
    }

    /**
     * Test of setLista_arcos method, of class Grafo.
     */
    @Test
    public void testSetLista_arcos() {
        System.out.println("setLista_arcos");
        ArrayList listaCPrueba = new ArrayList();
        Grafo instance = new Grafo();
        instance.setLista_vertices(listaCPrueba);
        assertEquals(listaCPrueba,instance.getListaArcos());
    }

    /**
     * Test of AgregarVertice method, of class Grafo.
     */
    @Test
    public void testAgregarVertice() {
        System.out.println("AgregarVertice");
        Celula celula = new Celula();
        Grafo instance=new Grafo();
        int sub=0;
        instance.AgregarVertice(celula, sub);
        assertEquals(instance.BuscarVertice(sub),true);
    }

   /* @Test
    public void testAgregarArco() {
        System.out.println("AgregarArco");
        int vi = 1;
        int vj = 2;
        int costo = 4;
        //Arco a= new Arco();
        a.setVi(1);
        a.setVj(2);
        a.setCosto(4);
        Grafo instance = new Grafo();
        instance.AgregarArco(vi, vj, costo);
        //assertEquals(instance.estaArco(a),true);!//Agregar metodo estaArco() en la clase
    }
*/
    
    @Test
    public void testElimVertice() {
        System.out.println("ElimVertice");
        Celula celula=new Celula(1,2,3);
        int sub= 0;
        Grafo instance = new Grafo();
        instance.AgregarVertice(celula, sub);
      //  boolean a=instance.ElimVertice(sub);
       // assertEquals(a, true);
    }

    /**
     * Test of ElimArco method, of class Grafo.
     */
    @Test
    public void testElimArco() {
        System.out.println("ElimArco");
        int vi = 6;
        int vj = 7;
        int costo=2;
        Grafo instance = new Grafo();
        instance.AgregarArco(vi, vj, costo);
       // boolean a=instance.ElimArco(vi, vj);
       // assertEquals(a, true);
    }

    /**
     * Test of CostoArco method, of class Grafo.
     */
    @Test
    public void testCostoArco() {
        System.out.println("CostoArco");
        int vi = 1;
        int vj = 2;
        int costo=4;
        Grafo instance = new Grafo();
        instance.AgregarArco(vi,vj,costo);
        int result;
        result = instance.CostoArco(vi,vj);
        assertEquals(costo, result);
    }

    /**
     * Test of InfoVertice method, of class Grafo.
     */
    @Test
    public void testInfoVertice() {
        System.out.println("InfoVertice");
        int v = 1;
        Grafo instance = new Grafo();
        Celula celula=new Celula();
        //Assert.assertArrayEquals(celula, instance.InfoVertice(v));
        
    }

    @Test
    public void testOrdenGrafo() {
        System.out.println("ordenGrafo");
        Grafo instance = new Grafo();
        int expResult = 0;
        int result = instance.ordenGrafo();
        assertEquals(expResult, result);
    }

    /**
     * Test of MarcarVertice method, of class Grafo.
     */
    @Test
    public void testMarcarVertice() {
        System.out.println("MarcarVertice");
        Grafo instance = new Grafo();
        int v1=1;
        //assertEquals(instance.MarcarVertice(v1),true);
    }

    /**
     * Test of DesmarcarVertice method, of class Grafo.
     */
    @Test
    public void testDesmarcarVertice() {
        System.out.println("DesmarcarVertice");
        Grafo instance = new Grafo();
        int v1=1;
        Grafo g=new Grafo();
        Celula c=new Celula();
        g.AgregarVertice(c, v1);
       // assertEquals(instance.DesmarcarVertice(g, v1),true);
    }

    /**
     * Test of MarcadoVertice method, of class Grafo.
     */
    @Test
    public void testMarcadoVertice() {
        System.out.println("MarcadoVertice");
        Grafo instance = new Grafo();
        Grafo g=new Grafo();
        int sub=1;
        boolean result = instance.MarcadoVertice(g, sub);
        assertEquals(false, result);
    }

   /* public void testDesmarcarGrafo() {
        System.out.println("DesmarcarGrafo");
        Grafo instance = new Grafo();
 
        instance.DesmarcarGrafo(g,v1);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
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
    }*/
    }
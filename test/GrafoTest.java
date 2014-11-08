/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Acer
 */
public class GrafoTest {
    
    

    /**
     * Test of caminoCorto method, of class Grafo.
     */
    @Test
    public void testCaminoCorto() {
        System.out.println("caminoCorto");
        Grafo instance = new Grafo();
        instance.caminoCorto();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of centroGrafo method, of class Grafo.
     */
    @Test
    public void testCentroGrafo() {
        System.out.println("centroGrafo");
        Grafo instance = new Grafo();
        String expResult = "Guatemala";
        String result = instance.centroGrafo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

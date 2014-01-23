package ohjelma.ohha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mikaelwi
 */
public class RuudukkoTest {
    Ruudukko test;
    public RuudukkoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        test = new Ruudukko(4, 3, 0, 2);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void leveysOikein(){
        assertEquals(test.getLeveys(), 3);
    }
    @Test
    public void korkeusOikein(){
        assertEquals(test.getKorkeus(), 4);
    }
    @Test
    public void tyhjaRivioikein(){
        assertEquals(test.getTyhjaRivi(), 0);
    }
    @Test
    public void tyhjaSarakeOikein(){
        assertEquals(test.getTyhjaSarake(), 2);
    }
    @Test vpo

}

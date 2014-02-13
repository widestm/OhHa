/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ohjelma.ohha;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author WidestM
 */
public class LogiikkaTest {
    Logiikka logi;
    public LogiikkaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    this.logi = new Logiikka(new Ruudukko(4, 4, 3, 0));
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void alustaaRatkaistavanRuudukon(){
        logi.kaynnista();
        assertEquals(true, logi.getRuudukko().onkoRatkaistavissa());
    }
    @Test
    public void tyhjaMerkkiOikeassaKohdassa() {
        logi.kaynnista();
        assertEquals(16, logi.getRuudukko().getRuudukko()[3][0]);
}
    @Test
    public void siirrotLasketaanOikein(){
        logi.kaynnista();
        logi.siirra(3, 1);
        logi.siirra(0, 0);
        logi.siirra(1, 0);
        logi.siirra(3, 2);
        logi.siirra(2, 2);
        logi.siirra(1, 2);
        logi.siirra(3, 3);
        assertEquals(4, logi.getSiirrot());
    }
    @Test
    public void aikaaLasketaan(){
        logi.aloitaAjastus();
        logi.kaynnista();
        logi.lopetaAjastus();
        assertNotSame(0, logi.aikaaKaytetty());
    }
    

}

package ohjelma.ohha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
    ByteArrayOutputStream tulostus;

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
        test.taytaRuudukko();
        tulostus = new ByteArrayOutputStream();
        System.setOut(new PrintStream(tulostus));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void leveysOikein() {
        assertEquals(test.getLeveys(), 3);
    }

    @Test
    public void korkeusOikein() {
        assertEquals(test.getKorkeus(), 4);
    }

    @Test
    public void tyhjaRivioikein() {
        assertEquals(test.getTyhjaRivi(), 0);
    }

    @Test
    public void tyhjaSarakeOikein() {
        assertEquals(test.getTyhjaSarake(), 2);
    }

    @Test
    public void ruudunTayttaminenOikein() {
        test.taytaRuudukko();
        for (int i = 0; i < test.getKorkeus() - 1; i++) {
            for (int j = 0; j < test.getLeveys() - 1; j++) {
                assertEquals(test.getRuudukko()[i][j], 1);
            }
        }
    }

    @Test
    public void tulostusOikein() {
        String odotettu = 
                    "111\n"+
                    "111\n"+
                    "111\n"+
                    "111\n\n"
                ;
        test.tulosta();
        assertEquals(odotettu, tulostus.toString());
    }
    @Test
    public void tyhjaMeneeOikeaanPaikkaan(){
        test.asetaTyhja();
        assertEquals(test.getRuudukko()[0][2], 0);
    }
    @Test
    public void tyhjanSiirtaminenToimii(){
        test.asetaTyhja();
        test.asetaTyhja(2, 2);
        assertEquals(test.getRuudukko()[0][2], 0);
    }
    
    
}

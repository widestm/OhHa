package ohjelma.ohha;

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
        test.taytaRuudukko();
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
        int n = 0;
        test.taytaRuudukko();
        for (int i = 0; i < test.getKorkeus(); i++) {
            for (int j = 0; j < test.getLeveys(); j++) {
                assertEquals(test.getRuudukko()[i][j].getJNro(), n);
                n++;
            }
        }
    }

    @Test
    public void tulostusOikein() {
        String odotettu
                = "0 1 2 \n"
                + "3 4 5 \n"
                + "6 7 8 \n"
                + "9 10 11 \n";
        assertEquals(odotettu, test.toString());
    }
//    @Test
//    public void tyhjaMeneeOikeaanPaikkaan(){
//        test.asetaTyhja();
//        assertEquals(test.getRuudukko()[0][2], 0);
//    }
//    @Test
//    public void tyhjanSiirtaminenToimii(){
//        test.asetaTyhja();
//        test.asetaTyhja(2, 2);
//        assertEquals(test.getRuudukko()[0][2], 0);
//    }

}

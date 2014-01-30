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
    int tyhjaRuutu;

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
        tyhjaRuutu = test.getKorkeus() * test.getLeveys();
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
        int n = 1;
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
                = "1 2 3 \n"
                + "4 5 6 \n"
                + "7 8 9 \n"
                + "10 11 12 \n";
        assertEquals(odotettu, test.toString());
    }

    @Test
    public void tyhjaMeneeOikeaanPaikkaan() {
        test.asetaTyhja();
        assertEquals(test.getRuudukko()[0][2].getJNro(), tyhjaRuutu);
    }

    @Test
    public void tyhjanSiirtaminenToimii() {
        test.asetaTyhja();
        test.asetaTyhja(2, 2);
        assertEquals(test.getRuudukko()[2][2].getJNro(), tyhjaRuutu);
    }

    @Test
    public void siirtoVasemmalle() {
        test.asetaTyhja();
        int apum = test.getRuudukko()[0][1].getJNro();
        test.siirto(0, 1);
        assertEquals(test.getRuudukko()[0][1].getJNro(), tyhjaRuutu);
        assertEquals(test.getRuudukko()[0][2].getJNro(), apum);

    }

    @Test
    public void siirtoOikealle() {
        test.asetaTyhja(1, 1);
        int apum = test.getRuudukko()[1][2].getJNro();
        test.siirto(1, 2);
        assertEquals(test.getRuudukko()[1][2].getJNro(), tyhjaRuutu);
        assertEquals(test.getRuudukko()[1][1].getJNro(), apum);

    }

    @Test
    public void siirtoAlas() {
        test.asetaTyhja(1, 1);
        int apum = test.getRuudukko()[2][1].getJNro();
        test.siirto(2, 1);
        assertEquals(test.getRuudukko()[2][1].getJNro(), tyhjaRuutu);
        assertEquals(test.getRuudukko()[1][1].getJNro(), apum);

    }

    @Test
    public void siirtoYlos() {
        test.asetaTyhja(1, 1);
        int apum = test.getRuudukko()[0][1].getJNro();
        test.siirto(0, 1);
        assertEquals(test.getRuudukko()[0][1].getJNro(), tyhjaRuutu);
        assertEquals(test.getRuudukko()[1][1].getJNro(), apum);

    }

    @Test
    public void sekoitusSekoittaaJotain() {
        Ruudukko temp = test;
        test.sekoitaRuudukko();
        assertSame(test.getRuudukko(), temp.getRuudukko());
    }

    @Test
    public void inversiotOikeinYhdessaTapauksessa() {
        assertEquals(test.onkoRatkaistavissa(), true);
    }

}

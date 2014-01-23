package ohjelma.ohha;

import java.util.Random;

/**
 *
 * @author WidestM
 */
public class Ruudukko {

    private int[][] ruudukko;
    private int korkeus;
    private int leveys;
    private int ruutujenLkm;
    private Random random;

    public Ruudukko(int korkeus, int leveys, int ruutuja) {
        this.random = new Random();
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.ruutujenLkm = ruutuja;

    }

    public int[][] getRuudukko() {
        return ruudukko;
    }

    public void taytaRuudukko() {
//        ruudukko = new int[][]{
//            
//            {0, 1, 2},
//            {3, 4, 5},
//            {6, 7, 8},
//            {9, 10, 11}
//        };
        
        
    }

}

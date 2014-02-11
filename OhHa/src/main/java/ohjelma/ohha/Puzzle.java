package ohjelma.ohha;

import java.util.Random;

/**
 *
 * @author WidestM
 */
public class Puzzle {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Random rand = new Random();
        Ruudukko r = new Ruudukko(4, 4, 3, rand.nextInt(4));
        TekstiKayttoliittyma txt = new TekstiKayttoliittyma(r);
        txt.kaynnista();
    }
}

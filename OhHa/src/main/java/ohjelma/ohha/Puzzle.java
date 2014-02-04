package ohjelma.ohha;

import java.util.Random;
import java.util.Scanner;

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
        Scanner s = new Scanner(System.in);

        Ruudukko r = new Ruudukko(4, 4, 0, 2);
        r.taytaRuudukko();
        System.out.println(r.toString());
        r.asetaTyhja();
        System.out.println(r.toString());
        r.sekoitaRuudukko();
        
        System.out.println(r.toString());
        r.asetaTyhja(3,rand.nextInt(4));
        System.out.println(r.toString());
        System.out.println( r.onkoRatkaistavissa()? "parillinen":"pariton");
        

        while (true) {
            System.out.println("");
            System.out.println(r.toString());
            System.out.println("Anna rivi: ");
            int rivi = Integer.parseInt(s.nextLine());
            System.out.println("Anna sarake: ");
            int sarake = Integer.parseInt(s.nextLine());
            r.siirto(rivi, sarake);

        }

    }
}

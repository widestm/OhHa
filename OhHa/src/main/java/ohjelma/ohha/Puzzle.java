package ohjelma.ohha;

import java.util.Scanner;

public class Puzzle {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Ruudukko test = new Ruudukko(4, 3, 0, 2);
        test.taytaRuudukko();
        System.out.println(test.toString());
        test.asetaTyhja();
        test.sekoitaRuudukko();
        

        while (true) {

            System.out.println(test.toString());
            System.out.println("Anna rivi: ");
            int rivi = Integer.parseInt(s.nextLine());
            System.out.println("Anna sarake: ");
            int sarake = Integer.parseInt(s.nextLine());
            test.siirto(rivi, sarake);

        }

    }
}

package ohjelma.ohha;

public class Puzzle {

    public static void main(String[] args) {
        Ruudukko test = new Ruudukko(4, 3, 0, 2);
        test.taytaRuudukko();
        System.out.println(test.toString());
        test.asetaTyhja();
        System.out.println(test.toString());
        test.siirto(0, 1);
        System.out.println(test.toString());
        test.siirto(0, 2);
        System.out.println(test.toString());
        test.siirto(1, 2);
        System.out.println(test.toString());
        test.siirto(1, 1);
        System.out.println(test.toString());
        test.siirto(1, 0);
        System.out.println(test.toString());
        test.siirto(2, 0);
        System.out.println(test.toString());
        test.siirto(3, 0);
       System.out.println(test.toString());

    }
}

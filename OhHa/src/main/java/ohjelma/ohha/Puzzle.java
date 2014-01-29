package ohjelma.ohha;

public class Puzzle {

    public static void main(String[] args) {
        Ruudukko test = new Ruudukko(4, 3, 0, 2);
        test.taytaRuudukko();
        test.toString();
        test.asetaTyhja();
        test.toString();
        test.siirto(0, 1);
        test.toString();
        test.siirto(0, 2);
        test.toString();
        test.siirto(1, 2);
        test.toString();
        test.siirto(1, 1);
        test.toString();
        test.siirto(1, 0);
        test.toString();
        test.siirto(2, 0);
        test.toString();
        test.siirto(3, 0);
        test.toString();

    }
}

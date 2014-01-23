package ohjelma.ohha;

public class App {

    public static void main(String[] args) {
        Ruudukko2 test= new Ruudukko2();
        test.tayta();
        test.tulosta();
        test.asetaTyhja();
        test.tulosta();
        test.siirto(0, 1);
        test.tulosta();
        test.siirto(0, 2);
        test.tulosta();
        test.siirto(1, 2);
        test.tulosta();
        test.siirto(1, 1);
        test.tulosta();
        test.siirto(1, 0);
        test.tulosta();
        test.siirto(2, 0);
        test.tulosta();
        test.siirto(3, 0);
        test.tulosta();
        
    }
}

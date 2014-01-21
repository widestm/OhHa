package ohjelma.ohha;

/**
 *
 * @author WidestM
 */
public class Ruudukko {

    Integer[][] ruudukko;

    public Ruudukko(int korkeus, int leveys) {
        this.ruudukko = new Integer[korkeus][leveys];

    }

    public Integer[][] getRuudukko() {
        return ruudukko;
    }

    
    
}

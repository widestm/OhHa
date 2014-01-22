package ohjelma.ohha;

import java.util.Random;

/**
 *
 * @author WidestM
 */
public class Ruudukko {

    Ruutu[][] ruudukko;
    private int korkeus;
    private int leveys;
    private int ruutujenLkm;
    private Random random;

    public Ruudukko(int korkeus, int leveys, int ruutuja) {
        this.random = new Random();
        this.ruudukko = new Ruutu[korkeus][leveys];
        this.korkeus=korkeus;
        this.leveys=leveys;
        this.ruutujenLkm=ruutuja;
        
    }

    public Ruutu[][] getRuudukko() {
        return ruudukko;
    }

    
    
    public void taytaRuudukko(){
        int tyhjaRuutu= random.nextInt(ruutujenLkm);
        
        for (int i = 0; i < korkeus-1; i++) {
            for (int j = 0; j < leveys-1; j++) {
                
            }
            
        }
    }
}

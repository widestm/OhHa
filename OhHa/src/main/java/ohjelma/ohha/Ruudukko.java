package ohjelma.ohha;

import java.util.Random;

/**
 *
 * @author WidestM
 */
public class Ruudukko {

    private final int korkeus;
    private final int leveys;
    private int tyhjaRivi;
    private int tyhjaSarake;
    private Ruutu[][] ruudukko;
    private Random random;
    private int taulukonViimeinen;

    public Ruudukko(int korkeus, int leveys, int tyhjaRivi, int tyhjaSarake) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.tyhjaRivi = tyhjaRivi;
        this.tyhjaSarake = tyhjaSarake;
        this.random = new Random();
        this.taulukonViimeinen = korkeus*leveys;
    }

    public Ruutu[][] getRuudukko() {
        return ruudukko;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getLeveys() {
        return leveys;
    }

    public int getTyhjaRivi() {
        return tyhjaRivi;
    }

    public int getTyhjaSarake() {
        return tyhjaSarake;
    }

    public void taytaRuudukko() {
        int n = 1;
        ruudukko = new Ruutu[korkeus][leveys];
        for (int sarake = 0; sarake < korkeus; sarake++) {
            for (int rivi = 0; rivi < leveys; rivi++) {
                ruudukko[sarake][rivi] = new Ruutu(sarake, rivi, n);
                n++;
            }
        }
    }

    @Override
    public String toString() {
        String tulostus = "";
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[0].length; j++) {
                tulostus += ruudukko[i][j].getJNro() + " ";
            }
            tulostus += "\n";
        }
        return tulostus;
    }

    public void asetaTyhja(int rivi, int sarake) {
        this.tyhjaRivi = rivi;
        this.tyhjaSarake = sarake;
        this.asetaTyhja();
    }

    public void asetaTyhja() {
        Ruutu temp;
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[0].length; j++) {
                if (ruudukko[i][j].getJNro() == taulukonViimeinen) {
                    temp = ruudukko[i][j];
                    ruudukko[i][j] = ruudukko[tyhjaRivi][tyhjaSarake];
                    ruudukko[tyhjaRivi][tyhjaSarake] = temp;
                    break;
                }
            }
        }
    }

    public void sekoitaRuudukko() {
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[0].length; j++) {
                Ruutu temp = ruudukko[i][j];
                int arvottuRivi = random.nextInt(korkeus);
                int arvottuSarake = random.nextInt(leveys);
                ruudukko[i][j] = ruudukko[arvottuRivi][arvottuSarake];
                ruudukko[arvottuRivi][arvottuSarake] = temp;
            }
        }
    }

    public boolean onkoRatkaistavissa() {
        int inversioita = 0;
        int x = 0;
        int y = 0;
        int verrattava;

        while (true) {
//            System.out.println("verrattava: " + y + ", " + x);            //debugrivi
            verrattava = ruudukko[y][x].getJNro();
            x++;
            if (x > ruudukko[0].length - 1) {
                y++;
                if (y > ruudukko.length - 1) {
                    break;
                }
                x = 0;
            }
            for (int i = y; i < ruudukko.length; i++) {
                
                if (i == y) {
                    for (int j = x; j < ruudukko[0].length; j++) {
//                        System.out.println("i: " + i + " j:" + j);                //debug
                        if (ruudukko[i][j].getJNro() < verrattava && ruudukko[i][j].getJNro() != taulukonViimeinen && verrattava != taulukonViimeinen) {
                            inversioita++;

                        }
                    }
                } else {
                    for (int j = 0; j < ruudukko[0].length; j++) {
//                        System.out.println("i: " + i + " j:" + j);               //debug
                        if (ruudukko[i][j].getJNro() < verrattava && ruudukko[i][j].getJNro() != taulukonViimeinen && verrattava != taulukonViimeinen) {
                            inversioita++;

                        }
                    }
                }
            }
        }
        System.out.println(inversioita);
        if (inversioita % 2 == 0) {
            return true;
        }
        return false;

    }

    public void siirto(int rivi, int sarake) {                                          //siirto osoittamalla ruutua jota halutaan siirtää ja testaataan onko sallittu
        int uusiRivi = rivi;
        int uusiSarake = sarake;
        if (rivi > 0 && ruudukko[rivi - 1][sarake].getJNro() == taulukonViimeinen) {                     //ylhäälle siirto            
            uusiRivi--;
        } else if (rivi < (korkeus - 1) && ruudukko[rivi + 1][sarake].getJNro() == taulukonViimeinen) {  //alhaalle
            uusiRivi++;
        } else if (sarake > 0 && ruudukko[rivi][sarake - 1].getJNro() == taulukonViimeinen) {              //vasempaan
            uusiSarake--;
        } else if (sarake < leveys - 1 && ruudukko[rivi][sarake + 1].getJNro() == taulukonViimeinen) {     //oikealle
            uusiSarake++;
        }

        Ruutu temp = ruudukko[rivi][sarake];
        ruudukko[rivi][sarake] = ruudukko[uusiRivi][uusiSarake];
        ruudukko[uusiRivi][uusiSarake] = temp;
        this.tyhjaRivi=rivi;
        this.tyhjaSarake=sarake;
        

    }
}

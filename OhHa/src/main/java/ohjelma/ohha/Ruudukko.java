package ohjelma.ohha;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author WidestM
 */
public class Ruudukko {

    private int korkeus;
    private int leveys;
    private int tyhjaRivi;
    private int tyhjaSarake;
    private Ruutu[][] ruudukko;
    private Random random;

    public Ruudukko(int korkeus, int leveys, int tyhjaRivi, int tyhjaSarake) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.tyhjaRivi = tyhjaRivi;
        this.tyhjaSarake = tyhjaSarake;
        this.random = new Random();
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
                ruudukko[sarake][rivi] = new Ruutu(sarake, rivi, n, true);
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

//    public void asetaTyhja(int rivi, int sarake) {
//        Ruutu temp = ruudukko[rivi][sarake];
//        for (int i = 0; i < ruudukko.length; i++) {
//            for (int j = 0; j < ruudukko.length; j++) {
//                if (ruudukko[i][j].getJNro() == 16) {
//                    ruudukko[rivi][sarake] = ruudukko[i][j];
//                    ruudukko
//                }
//            }
//
//        }
//
//        ruudukko[rivi][sarake] =
//    }
    public void asetaTyhja() {
        ruudukko[tyhjaRivi][tyhjaSarake].setSisalto(false);
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
            System.out.println("verrattava: " + y + ", " + x);
            verrattava = ruudukko[y][x].getJNro();
            x++;
            if (x > ruudukko[0].length - 1) {
                y++;
                if (y > ruudukko.length - 1) {
                    break;
                }
                x = 0;
            }
//            System.out.println("aloitusruutu: " + y + ", " + x);
            for (int i = y; i < ruudukko.length; i++) {
                for (int j = x; j < ruudukko[0].length; j++) {
                    System.out.println("i: " + i + " j:" + j);
                    if (ruudukko[i][j].getJNro() < verrattava && ruudukko[i][j].getJNro() != 16 && verrattava != 16) {
                        inversioita++;
                        

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
        Ruutu temp = ruudukko[rivi][sarake];
        if (rivi > 0 && !ruudukko[rivi - 1][sarake].getSisalto()) {                     //ylhäälle siirto            
            ruudukko[rivi][sarake] = ruudukko[rivi - 1][sarake];
            ruudukko[rivi - 1][sarake] = temp;
        } else if (rivi < (korkeus - 1) && !ruudukko[rivi + 1][sarake].getSisalto()) {  //alhaalle
            ruudukko[rivi][sarake] = ruudukko[rivi + 1][sarake];
            ruudukko[rivi + 1][sarake] = temp;
        } else if (sarake > 0 && !ruudukko[rivi][sarake - 1].getSisalto()) {              //vasempaan
            ruudukko[rivi][sarake] = ruudukko[rivi][sarake - 1];
            ruudukko[rivi][sarake - 1] = temp;
        } else if (sarake < leveys - 1 && !ruudukko[rivi][sarake + 1].getSisalto()) {     //oikealle
            ruudukko[rivi][sarake] = ruudukko[rivi][sarake + 1];
            ruudukko[rivi][sarake + 1] = temp;
        }

    }
}

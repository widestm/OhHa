package ohjelma.ohha;

import java.util.Random;

/**
 *
 * @author WidestM
 */
public class Ruudukko {

    private int[][] ruudukko;
    private int korkeus;
    private int leveys;
    private int tyhjaRivi;
    private int tyhjaSarake;

    public Ruudukko(int korkeus, int leveys, int tyhjaRivi, int tyhjaSarake) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.tyhjaRivi = tyhjaRivi;
        this.tyhjaSarake = tyhjaSarake;

    }

    public int[][] getRuudukko() {
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
        ruudukko = new int[korkeus][leveys];

        for (int sarake = 0; sarake < korkeus; sarake++) {
            for (int rivi = 0; rivi < leveys; rivi++) {
                ruudukko[sarake][rivi] = 1;

            }
        }
    }

    public String toString() {
        String tulostus = "";
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[0].length; j++) {
                tulostus += ruudukko[i][j];
            }
            tulostus += "\n";
        }
        return tulostus;
    }

    public void asetaTyhja(int rivi, int sarake) {
        ruudukko[rivi][sarake] = 0;
    }

    public void asetaTyhja() {
        ruudukko[tyhjaRivi][tyhjaSarake] = 0;
    }

    public void siirto(int rivi, int sarake) {
        if (rivi > 0 && ruudukko[rivi - 1][sarake] == 0) {                     //ylhäälle siirto
            ruudukko[rivi][sarake] = 0;
            ruudukko[rivi - 1][sarake] = 1;
        } else if (rivi < (korkeus - 1) && ruudukko[rivi + 1][sarake] == 0) {  //alhaalle
            ruudukko[rivi][sarake] = 0;
            ruudukko[rivi + 1][sarake] = 1;
        } else if (sarake > 0 && ruudukko[rivi][sarake - 1] == 0) {              //vasempaan
            ruudukko[rivi][sarake] = 0;
            ruudukko[rivi][sarake - 1] = 1;
        } else if (sarake < leveys - 1 && ruudukko[rivi][sarake + 1] == 0) {     //oikealle
            ruudukko[rivi][sarake] = 0;
            ruudukko[rivi][sarake + 1] = 1;
        }

    }
}

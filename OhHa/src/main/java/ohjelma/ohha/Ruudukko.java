package ohjelma.ohha;

import java.util.Random;

/**
 *
 * @author Mikael Wide
 */
public class Ruudukko {

    private final int korkeus;
    private final int leveys;
    private int tyhjaRivi;
    private int tyhjaSarake;
    private int[][] taulukko;
    private Random random;
    private int taulukonViimeinen;

    /**
     *
     * @param korkeus
     * @param leveys
     * @param tyhjaRivi
     * @param tyhjaSarake
     */
    public Ruudukko(int korkeus, int leveys, int tyhjaRivi, int tyhjaSarake) {
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.tyhjaRivi = tyhjaRivi;
        this.tyhjaSarake = tyhjaSarake;
        this.random = new Random();
        this.taulukonViimeinen = korkeus * leveys;
    }

    public int[][] getTaulukko() {
        return taulukko;
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

    /**
     * Täyttää ruudukon konstruktorissa asetetuilla arvoilla
     */
    public void taytaRuudukko() {
        int n = 1;
        taulukko = new int[korkeus][leveys];
        for (int sarake = 0; sarake < korkeus; sarake++) {
            for (int rivi = 0; rivi < leveys; rivi++) {
                taulukko[sarake][rivi] = n;
                n++;
            }
        }
    }

    @Override
    public String toString() {
        String tulostus = "";
        for (int i = 0; i < taulukko.length; i++) {
            for (int j = 0; j < taulukko[0].length; j++) {
                tulostus += taulukko[i][j] + " ";
            }
            tulostus += "\n";
        }
        return tulostus;
    }

    /**
     * Muuttaa this.tyhjaRivi ja this.tyhjaSarake muuttujien arvoa ja kutsuu
     * metodia this.asetaTyhja()
     *
     * @param rivi Kertoo mille riville tyhjä merkki asetetaan
     * @param sarake Kertoo mille sarakkeelle tyhjä merkki asetetaan
     */
    public void asetaTyhja(int rivi, int sarake) {
        this.tyhjaRivi = rivi;
        this.tyhjaSarake = sarake;
        this.asetaTyhja();
    }

    /**
     * Asettaa tyhjän merkin siihen paikkaan johon this.tyhjaRivi ja
     * this.tyhjaSarake osoittaa. Ohjelman toteuksessa taulukon suurinta arvoa
     * ajatellaan tyhjänä.
     *
     */
    public void asetaTyhja() {
        int temp;
        for (int i = 0; i < taulukko.length; i++) {
            for (int j = 0; j < taulukko[0].length; j++) {
                if (taulukko[i][j] == taulukonViimeinen) {
                    temp = taulukko[i][j];
                    taulukko[i][j] = taulukko[tyhjaRivi][tyhjaSarake];
                    taulukko[tyhjaRivi][tyhjaSarake] = temp;
                    break;
                }
            }
        }
    }

    /**
     * Sekoittaa ruukudon luvut
     */
    public void sekoitaRuudukko() {
        for (int i = 0; i < taulukko.length; i++) {
            for (int j = 0; j < taulukko[0].length; j++) {
                int temp = taulukko[i][j];
                int arvottuRivi = random.nextInt(korkeus);
                int arvottuSarake = random.nextInt(leveys);
                taulukko[i][j] = taulukko[arvottuRivi][arvottuSarake];
                taulukko[arvottuRivi][arvottuSarake] = temp;
            }
        }
    }

    /**
     * Tämä metodi laskee taulukossa olevien inversioiden määrän ja palauttaa
     * true jos niitä on parillinen määrä ja silloin pelin pystyy ratkaista
     * siirtämällä vain tyhjää ruutua yhden askeleen kerralla.
     *
     * @return Palauttaa true jos peli on ratkaistavissa
     */
    public boolean onkoRatkaistavissa() {
        int inversioita = 0;
        int x = 0;
        int y = 0;
        int verrattava;

        while (true) {
//            System.out.println("verrattava: " + y + ", " + x);            //debugrivi
            verrattava = taulukko[y][x];
            x++;
            if (x > taulukko[0].length - 1) {
                y++;
                if (y > taulukko.length - 1) {
                    break;
                }
                x = 0;
            }
            for (int i = y; i < taulukko.length; i++) {

                if (i == y) {
                    for (int j = x; j < taulukko[0].length; j++) {
//                        System.out.println("i: " + i + " j:" + j);                //debug
                        if (taulukko[i][j] < verrattava && taulukko[i][j] != taulukonViimeinen && verrattava != taulukonViimeinen) {
                            inversioita++;

                        }
                    }
                } else {
                    for (int j = 0; j < taulukko[0].length; j++) {
//                        System.out.println("i: " + i + " j:" + j);               //debug
                        if (taulukko[i][j] < verrattava && taulukko[i][j] != taulukonViimeinen && verrattava != taulukonViimeinen) {
                            inversioita++;

                        }
                    }
                }
            }
        }
        if (inversioita % 2 == 0) {
            return true;
        }
        return false;

    }

    /**
     * Metodissa osoitetaan jotain ruutua taulukossa, jos tämän kyseisen ruudun
     * (rivi, sarake) vieressä on tyhjä ruutu, ruudut vaihtavat paikkaa. Metodi
     * päivittää myös muuttujat this.tyhjaRivi ja this.tyhjaSarake jotta ne ovat
     * oikein.
     *
     * @param rivi Siirrettävän ruudun rivi
     * @param sarake Siirrettävän ruudun sarake
     */
    public boolean siirto(int rivi, int sarake) {                                          //siirto osoittamalla ruutua jota halutaan siirtää ja testaataan onko sallittu
        boolean onnistuiko = false;
        int uusiRivi = rivi;
        int uusiSarake = sarake;
        if (rivi > 0 && taulukko[rivi - 1][sarake] == taulukonViimeinen) {                     //ylhäälle siirto            
            onnistuiko=true;
            uusiRivi--;
        } else if (rivi < (korkeus - 1) && taulukko[rivi + 1][sarake] == taulukonViimeinen) {  //alhaalle
            onnistuiko=true;
            uusiRivi++;
        } else if (sarake > 0 && taulukko[rivi][sarake - 1] == taulukonViimeinen) {              //vasempaan
            onnistuiko=true;
            uusiSarake--;
        } else if (sarake < leveys - 1 && taulukko[rivi][sarake + 1] == taulukonViimeinen) {     //oikealle
            onnistuiko=true;
            uusiSarake++;
        }

        int temp = taulukko[rivi][sarake];
        taulukko[rivi][sarake] = taulukko[uusiRivi][uusiSarake];
        taulukko[uusiRivi][uusiSarake] = temp;
        this.tyhjaRivi = rivi;
        this.tyhjaSarake = sarake;
        return onnistuiko;
    }

    public boolean ratkaistu() {
        boolean palautus = true;
        int apu = 1;
        for (int i = 0; i < taulukko.length; i++) {
            for (int j = 0; j < taulukko[0].length; j++) {
                if (taulukko[i][j] != apu) {
                    palautus = false;
                }
                apu++;
            }

        }

        return palautus;
    }
}

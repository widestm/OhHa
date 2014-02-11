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
    private int[][] ruudukko;
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

    /**
     * Täyttää ruudukon konstruktorissa asetetuilla arvoilla
     */
    public void taytaRuudukko() {
        int n = 1;
        ruudukko = new int[korkeus][leveys];
        for (int sarake = 0; sarake < korkeus; sarake++) {
            for (int rivi = 0; rivi < leveys; rivi++) {
                ruudukko[sarake][rivi] = n;
                n++;
            }
        }
    }

    @Override
    public String toString() {
        String tulostus = "";
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[0].length; j++) {
                tulostus += ruudukko[i][j] + " ";
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
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[0].length; j++) {
                if (ruudukko[i][j] == taulukonViimeinen) {
                    temp = ruudukko[i][j];
                    ruudukko[i][j] = ruudukko[tyhjaRivi][tyhjaSarake];
                    ruudukko[tyhjaRivi][tyhjaSarake] = temp;
                    break;
                }
            }
        }
    }

    /**
     * Sekoittaa ruukudon luvut
     */
    public void sekoitaRuudukko() {
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[0].length; j++) {
                int temp = ruudukko[i][j];
                int arvottuRivi = random.nextInt(korkeus);
                int arvottuSarake = random.nextInt(leveys);
                ruudukko[i][j] = ruudukko[arvottuRivi][arvottuSarake];
                ruudukko[arvottuRivi][arvottuSarake] = temp;
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
            verrattava = ruudukko[y][x];
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
                        if (ruudukko[i][j] < verrattava && ruudukko[i][j] != taulukonViimeinen && verrattava != taulukonViimeinen) {
                            inversioita++;

                        }
                    }
                } else {
                    for (int j = 0; j < ruudukko[0].length; j++) {
//                        System.out.println("i: " + i + " j:" + j);               //debug
                        if (ruudukko[i][j] < verrattava && ruudukko[i][j] != taulukonViimeinen && verrattava != taulukonViimeinen) {
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
        if (rivi > 0 && ruudukko[rivi - 1][sarake] == taulukonViimeinen) {                     //ylhäälle siirto            
            onnistuiko=true;
            uusiRivi--;
        } else if (rivi < (korkeus - 1) && ruudukko[rivi + 1][sarake] == taulukonViimeinen) {  //alhaalle
            onnistuiko=true;
            uusiRivi++;
        } else if (sarake > 0 && ruudukko[rivi][sarake - 1] == taulukonViimeinen) {              //vasempaan
            onnistuiko=true;
            uusiSarake--;
        } else if (sarake < leveys - 1 && ruudukko[rivi][sarake + 1] == taulukonViimeinen) {     //oikealle
            onnistuiko=true;
            uusiSarake++;
        }

        int temp = ruudukko[rivi][sarake];
        ruudukko[rivi][sarake] = ruudukko[uusiRivi][uusiSarake];
        ruudukko[uusiRivi][uusiSarake] = temp;
        this.tyhjaRivi = rivi;
        this.tyhjaSarake = sarake;
        return onnistuiko;
    }

    public boolean ratkaistu() {
        boolean palautus = true;
        int apu = 1;
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[0].length; j++) {
                if (ruudukko[i][j] != apu) {
                    palautus = false;
                }
                apu++;
            }

        }

        return palautus;
    }
}

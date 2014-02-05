package ohjelma.ohha;

import java.util.Scanner;

/**
 *
 * @author WidestM
 */
public class Logiikka {

    private Ruudukko r;
    private Scanner luk;
    private int siirtoja;
    private long aloitusAika;
    private long lopetusAika;

    /**
     *
     * @param ruudukko
     */
    public Logiikka(Ruudukko ruudukko) {
        this.r = ruudukko;
        this.luk = new Scanner(System.in);

    }

    /**
     * Metodi luo ruudukon alustaa sen, testaa ratkaistavuuden, pyörittää
     * looppia kunnes siirtojen avulla saadaan ratkaistu taulukko
     */
    public void kaynnista() {
        r.taytaRuudukko();

        while (true) {
            r.sekoitaRuudukko();
            r.asetaTyhja();
            if (r.onkoRatkaistavissa()) {
                break;
            }
        }
        r.asetaTyhja(3, 2);
        System.out.println(r.toString());
        System.out.println("Hei! Tervetuloa Sliding Puzzleen");
        System.out.println("Tyhjä ruutu on taulukon suurin arvo!");
        System.out.println("Voit siirtää vain yhtä ruutua kerralla");
        System.out.println("Jos ruudun vieressä on tyhjä ruutu se siirretään sen tilalle");
        aloitaAjastus();
        while (!r.ratkaistu()) {

            System.out.println("Anna rivi: ");
            int rivi = Integer.parseInt(luk.nextLine());
            System.out.println("Anna sarake: ");
            int sarake = Integer.parseInt(luk.nextLine());
            r.siirto(rivi, sarake);
            siirtoja++;
            System.out.println(r.toString());
        }
        lopetaAjastus();
        System.out.println("Onneksi olkoon, ratkaisit pelin!");
        System.out.println("Käytit ratkaisemiseen " + siirtoja + " siirtoa ja aikaa "+this.aikaaKaytetty()+"s");
        
    }

    /**
     *  Metodi aloittaa ajastuksen
     */
    public void aloitaAjastus() {
        this.aloitusAika = System.currentTimeMillis();
    }

    /**
     *  Metodi lopettaa ajastuksen
     */
    public void lopetaAjastus() {
        this.lopetusAika = System.currentTimeMillis();
    }

    /**
     *
     * @return Palauttaa käytetyn ajan sekunneissa
     */
    public long aikaaKaytetty() {
        return (this.lopetusAika - this.aloitusAika)/1000;
    }

}

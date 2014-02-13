package ohjelma.ohha;


/**
 *
 * @author Mikael Wide
 */
public class Logiikka {

    private Ruudukko r;
    private int siirrot;
    private long aloitusAika;
    private long lopetusAika;

    /**
     *
     * @param ruudukko
     */
    public Logiikka(Ruudukko ruudukko) {
        this.r = ruudukko;

    }
    /**
     * Metodi luo ruudukon ja alustaa sen, testaa ratkaistavuuden, pyörittää
     * looppia kunnes pelilauta on ratkaistavaa muotoa
     */
    public void alusta() {
        r.taytaRuudukko();

        while (true) {
            r.sekoitaRuudukko();
            r.asetaTyhja();
            if (r.onkoRatkaistavissa()) {
                break;
            }
        }

    }

    public int getSiirrot() {
        return siirrot;
    }
    public Ruudukko getRuudukko() {
        return r;
    }

    /**
     * Metodi aloittaa ajastuksen
     */
    public void aloitaAjastus() {
        this.aloitusAika = System.currentTimeMillis();
    }

    /**
     * Metodi lopettaa ajastuksen
     */
    public void lopetaAjastus() {
        this.lopetusAika = System.currentTimeMillis();
    }

    /**
     *
     * @return Palauttaa käytetyn ajan sekunneissa
     */
    public long aikaaKaytetty() {
        return (this.lopetusAika - this.aloitusAika) / 1000;
    }

    /**
     *  Metodi kutsuu ruudukon siirto()-metodia ja lisää yhden siirron jos metodi palauttaa true 
     * eli siirto oli laillinen
     * 
     * @param rivi      Siirrettävän ruudun rivi
     * @param sarake    Siirettävän ruudun sarake
     */
    public boolean siirra(int rivi, int sarake) {
        boolean onnistuiko = false;
        if (r.siirto(rivi, sarake)) {
            onnistuiko = true;
            siirrot++;
        }
        return onnistuiko;
    }

    @Override
    public String toString() {
        return r.toString();
    }

    /**
     *  Pyytää ruudukon ratkaistu()-metodia ja palauttaa true jos peli on raktaistu eli oikeassa järjestyksessä
     * @return
     */
    public boolean kaynnissa() {
        if (r.ratkaistu()) {
            return false;
        }
        return true;
    }

}

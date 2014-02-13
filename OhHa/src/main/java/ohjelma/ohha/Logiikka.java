package ohjelma.ohha;


/**
 *
 * @author WidestM
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
     * Metodi luo ruudukon alustaa sen, testaa ratkaistavuuden, pyörittää
     * looppia kunnes pelilauta on ratkaistavaa muotoa
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
    public void siirra(int rivi, int sarake) {
        if (r.siirto(rivi, sarake)) {
            siirrot++;
        }
        
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

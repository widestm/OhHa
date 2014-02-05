package ohjelma.ohha;

/**
 *  Rajapinta jonka toteuttavat erilaiset käyttöliittymät
 * @author WidestM
 */
public interface Kayttoliittyma {

    /**
     * Siirtää ruutua ruudukossa 
     * 
     * @param rivi      Siirrettävän ruudun rivi
     * @param sarake    Siirrettävän ruudun sarake
     */
    public void siirra(int rivi, int sarake);
}

package ohjelma.ohha;

import java.util.Scanner;

/**
 *
 * @author WidestM
 */
public class TekstiKayttoliittyma implements Kayttoliittyma {

    private Logiikka logi;
    private Scanner luk;

    /**
     *
     * @param ruudukko Luokka saa mainilta käyttöönsä ruudukon
     */
    public TekstiKayttoliittyma(Ruudukko ruudukko) {
        this.logi = new Logiikka(ruudukko);
        this.luk = new Scanner(System.in);

    }

    @Override
    public void siirra(int rivi, int sarake) {
        logi.siirra(rivi, sarake);
    }

    /**
     *  Käskytetään logiikkaa ja tulostetaan sopivaksi koettua kamaa.
     * 
     */
    public void kaynnista() {
        logi.kaynnista();

        System.out.println(logi.toString());
        System.out.println("Hei! Tervetuloa Sliding Puzzleen");
        System.out.println("Taulukon suurin arvo toimii tyhjänä ruutuna! (Tässä 16)\n");
        System.out.println("Voit siirtää vain yhtä ruutua kerralla");
        System.out.println("Jos ruudun vieressä on tyhjä ruutu se siirretään sen tilalle\n");
        
        logi.aloitaAjastus();
        while (logi.kaynnissa()) {
            System.out.println("Anna rivi: ");
            int rivi = Integer.parseInt(luk.nextLine());
            System.out.println("Anna sarake: ");
            int sarake = Integer.parseInt(luk.nextLine());
            logi.siirra(rivi, sarake);

            System.out.println("\n" + logi.toString());
        }
        logi.lopetaAjastus();
        
        System.out.println("Onneksi olkoon, ratkaisit pelin!");
        System.out.println("Käytit ratkaisemiseen " + logi.getSiirrot() + " siirtoa ja aikaa " + logi.aikaaKaytetty() + "s");
    }

}

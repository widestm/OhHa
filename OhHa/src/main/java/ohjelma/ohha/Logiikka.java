/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohjelma.ohha;

import java.util.Scanner;

/**
 *
 * @author WidestM
 */
public class Logiikka {

    private Ruudukko r;
    private Scanner luk;

    public Logiikka(Ruudukko ruudukko) {
        this.r = ruudukko;
        this.luk = new Scanner(System.in);

    }

    public void käynnistä() {
        r.taytaRuudukko();

        while (true) {
            r.sekoitaRuudukko();
            r.asetaTyhja();
            if (r.onkoRatkaistavissa()) {
                break;
            }
        }
        System.out.println(r.onkoRatkaistavissa());
        System.out.println(r.toString());
        System.out.println("Hei! Tervetuloa Sliding Puzzleen");
        System.out.println("Tyhjä ruutu on taulukon suurin arvo!");
        System.out.println("Voit siirtää vain yhtä ruutua kerralla");
        System.out.println("Jos ruudun vieressä on tyhjä ruutu se siirretään sen tilalle");
        
        while (true) {
            
            if (r.ratkaistu()) {
                System.out.println("Onneksi olkoon, ratkaisit pelin!");
                break;
            }
            System.out.println("Anna rivi: ");
            int rivi = Integer.parseInt(luk.nextLine());
            System.out.println("Anna sarake: ");
            int sarake = Integer.parseInt(luk.nextLine());
            r.siirto(rivi, sarake);
            System.out.println(r.toString());
            if (r.ratkaistu()) {
                System.out.println("Onneksi olkoon, ratkaisit pelin!");
                break;
            }

        }
    }

}

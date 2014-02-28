package slidingpuzzle.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import slidingpuzzle.logiikka.Logiikka;
import slidingpuzzle.logiikka.Ruudukko;
import java.awt.Image.*;

/**
 * Pelilauta alustaa uuden logiikka-olion ja kuvaluokan jossa on annettu kuvan
 * polku ja kaikki pelilaudan ominaisuudet
 *
 * @author Mikael Wide
 */
public class Pelilauta extends JPanel implements MouseListener {

    private static Logiikka logic;
    private final int ruudunSivu;
    private KuvanKasittelija valittuKuva;
    private final int pelinKorkeus;
    private final int pelinLeveys;
    private final int sarakeMaara;
    private final int riviMaara;
    private KuvanKasittelija kuva1;
    private KuvanKasittelija kuva2;
    private KuvanKasittelija kuva3;
    private KuvanKasittelija tyhja;
    private ImageIcon tyhjaKuva;

    public Pelilauta() {
        this.sarakeMaara = 4;
        this.riviMaara = 4;
        this.logic = new Logiikka(new Ruudukko(riviMaara, sarakeMaara, riviMaara - 1, new Random().nextInt(riviMaara)));
        this.logic.alusta();
        this.ruudunSivu = 150;
        this.pelinKorkeus = riviMaara * ruudunSivu;
        this.pelinLeveys = sarakeMaara * ruudunSivu;
        this.setPreferredSize(
                new Dimension(pelinLeveys, pelinKorkeus));
        this.setBackground(Color.black);
        this.addMouseListener(this);
        this.alustaKuvat();

        this.logic.aloitaAjastus();

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[][] taulu = logic.getRuudukko().getTaulukko();
        if (logic.kaynnissa()) {
            for (int i = 0; i < taulu.length; i++) {
                for (int j = 0; j < taulu[0].length; j++) {
                    int x = j * ruudunSivu;
                    int y = i * ruudunSivu;
                    if (taulu[i][j] != taulu[0].length * taulu.length) {
                        g.drawImage(valittuKuva.haePala(taulu[i][j]), x, y, this);
                    } else {
                        g.drawImage(tyhja.haePala(1), x, y, this);

                    }
                }
            }
        } else {
            logic.lopetaAjastus();
            g.setColor(Color.white);
            g.drawImage(valittuKuva.haeAlkuperainen(), 0, 0, this);
            g.setColor(Color.white);
            g.setFont(new Font("SansSerif", Font.BOLD, 20));
            g.drawString("Voitit pelin!", 0, 50);
            g.drawString("Käytit siihen " + logic.getSiirrot() + " SIIRTOA", 0, 70);
            g.drawString("ja " + logic.aikaaKaytetty() + "s", 0, 90);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (logic.kaynnissa()) {
            int rivi = e.getY() / ruudunSivu;
            int sarake = e.getX() / ruudunSivu;

            if (!logic.siirra(rivi, sarake)) {
                Toolkit.getDefaultToolkit().beep();
            }
            this.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void kuvanValitsin(int n) {
        if (n == 1) {
            this.valittuKuva = kuva1;
        } else if (n == 2) {
            this.valittuKuva = kuva2;
        } else if (n == 3) {
            this.valittuKuva = kuva3;
        }

    }

    public void alustaKuvat() {
        this.kuva1 = new KuvanKasittelija("/images/sidthekid.jpg", pelinLeveys, pelinKorkeus, riviMaara, sarakeMaara, ruudunSivu);
        this.kuva2 = new KuvanKasittelija("/images/minions.jpg", pelinLeveys, pelinKorkeus, riviMaara, sarakeMaara, ruudunSivu);
        this.kuva3 = new KuvanKasittelija("/images/swimmingsid.jpg", pelinLeveys, pelinKorkeus, riviMaara, sarakeMaara, ruudunSivu);
        this.tyhja = new KuvanKasittelija("/images/empty.png", ruudunSivu, ruudunSivu, 1, 1, ruudunSivu);
        this.valittuKuva = kuva1;
    }

    public ImageIcon haeThumbnail(int n) {
        if (n == 1) {
            return kuva1.haeAlkuperainenThumbnail();
        } else if (n == 2) {
            return kuva2.haeAlkuperainenThumbnail();
        }
        return kuva3.haeAlkuperainenThumbnail();
    }

    public int getPelinKorkeus() {
        return pelinKorkeus;
    }

    public int getPelinLeveys() {
        return pelinLeveys;
    }

}

//          Tässä ylimääräinen koodipätkä jolla peliä voi pelata pelkillä numeroilla
//          
//
//        int[][] taulu = logic.getRuudukko().getTaulukko();
//        if (logic.kaynnissa()) {
//            for (int i = 0; i < taulu.length; i++) {
//                for (int j = 0; j < taulu[0].length; j++) {
//                    int x = j * ruudunKoko;
//                    int y = i * ruudunKoko;
//                    if (taulu[i][j] != taulu[0].length * taulu.length) {
//                        g.setColor(Color.black);
//                        g.fillRect(x + 2, y + 2, ruudunKoko - 5, ruudunKoko - 5);
//                        g.setColor(Color.GREEN);
//                        g.setFont(new Font("SansSerif", Font.BOLD, ruudunKoko / 2));
//                        g.drawString("" + taulu[i][j], x + 30, y + (3 * ruudunKoko) / 4);
//                    } else {
//                        g.setColor(Color.black);
//                        g.fillRect(x + 2, y + 2, ruudunKoko - 5, ruudunKoko - 5);
//                    }
//                }
//            }

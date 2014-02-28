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
    private final KuvanKasittelija kuvaLuokka;
    private final int pelinKorkeus;
    private final int pelinLeveys;
    private final int sarakeMaara;
    private final int riviMaara;

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
        this.setBackground(Color.DARK_GRAY);
        this.addMouseListener(this);
        this.logic.aloitaAjastus();
        this.kuvaLuokka = new KuvanKasittelija("/images/sid2.jpg", pelinLeveys, pelinKorkeus, riviMaara, sarakeMaara, ruudunSivu);
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
                        g.drawImage(kuvaLuokka.haePala(taulu[i][j]), x, y, this);
                    } else {
                        g.setColor(Color.black);
                        g.fillRect(x, y, ruudunSivu, ruudunSivu);
                    }
                }
            }
        } else {
            logic.lopetaAjastus();
            g.setColor(Color.white);
            g.drawImage(kuvaLuokka.haeAlkuperainen(), 0, 0, this);
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

}
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

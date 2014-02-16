package slidingpuzzle.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import slidingpuzzle.logiikka.Logiikka;
import slidingpuzzle.logiikka.Ruudukko;

/**
 *
 * @author Mikael Wide
 */
public class Pelilauta extends JPanel implements MouseListener{

    private static Logiikka logic;
    private final int ruudunKoko;

    public Pelilauta() {
        logic = new Logiikka(new Ruudukko(3, 3, 2, new Random().nextInt(3)));
        logic.alusta();
        this.ruudunKoko = 100;
        this.setPreferredSize(
                new Dimension(logic.getRuudukko().getLeveys() * ruudunKoko + 150, logic.getRuudukko().getKorkeus() * ruudunKoko + 150));
        this.setBackground(Color.DARK_GRAY);
        this.addMouseListener(this);
        logic.aloitaAjastus();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int[][] taulu = logic.getRuudukko().getTaulukko();
        if (logic.kaynnissa()) {
            for (int i = 0; i < taulu.length; i++) {
                for (int j = 0; j < taulu[0].length; j++) {
                    int x = j * ruudunKoko;
                    int y = i * ruudunKoko;
                    if (taulu[i][j] != taulu[0].length * taulu.length) {
                        g.setColor(Color.black);
                        g.fillRect(x + 2, y + 2, ruudunKoko - 5, ruudunKoko - 5);
                        g.setColor(Color.GREEN);
                        g.setFont(new Font("SansSerif", Font.BOLD, ruudunKoko / 2));
                        g.drawString("" + taulu[i][j], x + 30, y + (3 * ruudunKoko) / 4);
                    } else {
                        g.setColor(Color.black);
                        g.fillRect(x + 2, y + 2, ruudunKoko - 5, ruudunKoko - 5);
                        g.setColor(Color.GREEN);
                        g.setFont(new Font("SansSerif", Font.BOLD, ruudunKoko / 2));
                        g.drawString("", x + 30, y + (3 * ruudunKoko) / 4);
                    }
                }

            }
        } else {
            logic.lopetaAjastus();
            g.setColor(Color.white);
            g.fillRect(0, 0, 500, 500);
            g.setColor(Color.black);
//            String teksti = "" + logic.getSiirrot() + " siirtoa ja  " + logic.aikaaKaytetty() + "s";
//            String teksti2 = "JUMALAUTA SÄ LÄPÄSIT PELIN!\2 SIIHEN MENI VAAN " + logic.getSiirrot()
//                    + " SIIRTOA JA " + logic.aikaaKaytetty() + "s";
            g.setFont(new Font("SansSerif", Font.BOLD, 20));
            g.drawString("JUMALAUTA SÄ LÄPÄSIT PELIN!", 0, 50);
            g.drawString("SIIHEN MENI VAAN " + logic.getSiirrot() + " SIIRTOA", 0, 70);
            g.drawString("JA " + logic.aikaaKaytetty() + "s", 0, 90);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (logic.kaynnissa()) {
            int rivi = e.getY() / ruudunKoko;
            int sarake = e.getX() / ruudunKoko;

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

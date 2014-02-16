package slidingpuzzle.gui;

import java.awt.event.ActionEvent;
import slidingpuzzle.logiikka.Logiikka;

/**
 *
 * @author Mikael Wide
 */
public class Kuuntelija implements java.awt.event.ActionListener {

    private Logiikka l;
    private Pelilauta p;

    public Kuuntelija(Logiikka l, Pelilauta p) {
        this.l = l;
        this.p = p;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        l.alusta();
        p.repaint();
    }

}

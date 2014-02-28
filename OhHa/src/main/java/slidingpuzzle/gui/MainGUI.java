package slidingpuzzle.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainGUI implements Runnable {

    private JFrame frame;
    private Pelilauta pelilauta;
    private PeliPaneeli alkupaneeli;

    public MainGUI() {
        this.alkupaneeli = new PeliPaneeli();
        this.pelilauta = alkupaneeli.getPelilauta();
    }

    @Override
    public void run() {
        frame = new JFrame("SLidingPuzz");
        frame.setPreferredSize(new Dimension(700, 700));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container c) {
        CardLayout cl = new CardLayout();
        JPanel korttip = new JPanel(cl);
        korttip.add(alkupaneeli);
        korttip.add(pelilauta);
        c.add(korttip);
    }

    public JFrame getFrame() {
        return frame;
    }
}

package slidingpuzzle.gui;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainGUI implements Runnable {

    private JFrame frame;
    private Pelilauta pelilauta;
    private PeliPaneeli alkupaneeli;

    public MainGUI() {
    }

    @Override
    public void run() {
        frame = new JFrame("SLidingPuzz");
        frame.setPreferredSize(new Dimension(600, 600));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.alkupaneeli = new PeliPaneeli();
        this.pelilauta = alkupaneeli.getPelilauta();

        luoKomponentit(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void luoKomponentit(Container c) {
        c.add(alkupaneeli);
        c.add(pelilauta);
    }

    public JFrame getFrame() {
        return frame;
    }
}

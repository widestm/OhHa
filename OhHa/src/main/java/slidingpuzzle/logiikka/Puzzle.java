package slidingpuzzle.logiikka;

import slidingpuzzle.gui.Pelilauta;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import slidingpuzzle.gui.MainGUI;
import slidingpuzzle.gui.PeliPaneeli;

/**
 *
 * @author Mikael Wide
 */
public class Puzzle {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
//        Random rand = new Random();
//        Ruudukko r = new Ruudukko(4, 4, 3, rand.nextInt(4));
//        TekstiKayttoliittyma txt = new TekstiKayttoliittyma(r);
//        txt.kaynnista();
//        
//        JFrame window = new JFrame("Sliding Puzzle");
//        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        PeliPaneeli peli = new PeliPaneeli();
////        Pelilauta peli = new Pelilauta();
//        window.setContentPane(peli);
//        window.pack();  
//        window.show();
//        window.setResizable(true);
        MainGUI gui = new MainGUI();
        SwingUtilities.invokeLater(gui);
                
    }

  
}

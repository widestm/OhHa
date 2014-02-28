package slidingpuzzle.logiikka;

import java.util.Random;
import javax.swing.SwingUtilities;
import slidingpuzzle.gui.MainGUI;
import slidingpuzzle.textUI.TekstiKayttoliittyma;

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

        MainGUI gui = new MainGUI();
        SwingUtilities.invokeLater(gui);
                
    }

  
}

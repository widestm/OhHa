package ohjelma.ohha;

import java.util.Random;
import javax.swing.JFrame;

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
        JFrame window = new JFrame("Sliding Puzzle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Pelilauta peli = new Pelilauta();
        window.setContentPane(peli);
        window.pack();  // finalize layout
        window.show();  // make window visible
        window.setResizable(true);
    }

  
}

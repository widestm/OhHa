package slidingpuzzle.gui;

import java.awt.Image.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Mikael Wide
 */
public class KuvanKasittelija extends JPanel {

    private ImageIcon lahde;
    private HashMap<Integer, Image> palat;
    private final int pelinKorkeus;
    private final int pelinLeveys;
    private final int sarakeMaara;
    private final int riviMaara;
    private final int ruudunKoko;
    private ImageIcon temp;

    public KuvanKasittelija(String source, int leveys, int korkeus, int riviMaara, int sarakeMaara, int ruudunKoko) {
        this.pelinKorkeus = korkeus;
        this.pelinLeveys = leveys;
        this.sarakeMaara = sarakeMaara;
        this.riviMaara = riviMaara;
        this.ruudunKoko = ruudunKoko;
        this.palat = new HashMap<>();
        this.temp = new ImageIcon(KuvanKasittelija.class.getResource(source));
        this.skaalaaKuva();
        this.hajotaKuva();

    }

    public void hajotaKuva() {
        int n = 1;
        for (int i = 0; i < riviMaara; i++) {
            for (int j = 0; j < sarakeMaara; j++) {
                Image kuva = createImage(new FilteredImageSource(lahde.getImage().getSource(),
                        new CropImageFilter(j * ruudunKoko, i * ruudunKoko, ruudunKoko, ruudunKoko)));
                palat.put(n, kuva);
                n++;
            }
        }

    }

    public Image haePala(int palaNro) {
        return this.palat.get(palaNro);
    }

    public void skaalaaKuva() {
        if (temp.getIconHeight() != pelinKorkeus && temp.getIconWidth() != pelinLeveys) {
            lahde = new ImageIcon(temp.getImage().getScaledInstance(pelinLeveys, pelinKorkeus, Image.SCALE_SMOOTH));
        }
    }
    public Image haeAlkuperainen(){
        return this.lahde.getImage();
    }
}

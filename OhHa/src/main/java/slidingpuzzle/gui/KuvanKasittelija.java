package slidingpuzzle.gui;

import java.awt.Image.*;
import java.awt.*;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Kuvankäsittelijä skaalaa saamansa kuvan oikeaan kokoon ja jakaa sen oikean
 * kokoisiksi paloiksi
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
    private final ImageIcon temp;

    /**
     *
     * @param source Polku käytettävälle kuvalle
     * @param leveys Pelille asetettu leveys
     * @param korkeus Pelille asetettu korkeus
     * @param riviMaara Pelin rivimäärä
     * @param sarakeMaara Pelin sarakemäärä
     * @param ruudunKoko Pelissä käytettävän ruudn sivun pituus
     */
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

    /**
     * hajotaKuva() jakaa kuvan oikean kokoisiin paloihin ja lisää ne
     * hashMappiin avaimena 1-n jossa n on ruudukossa olevien alkioden määrä
     */
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

    /**
     * Metodin avulla voi hakea kuvapalaa
     *
     * @param palaNro Joku ruudukossa oleva arvo
     * @return Palauttaa kuvan
     */
    public Image haePala(int palaNro) {
        return this.palat.get(palaNro);
    }

    /**
     * Metodi skaalaa kuvan oikean kokoiseksi riippuen minkä kokoista pelilautaa
     * käytetään
     */
    public void skaalaaKuva() {
        if (temp.getIconHeight() != pelinKorkeus && temp.getIconWidth() != pelinLeveys) {
            lahde = new ImageIcon(temp.getImage().getScaledInstance(pelinLeveys, pelinKorkeus, Image.SCALE_SMOOTH));
        }
    }

    /**
     *
     * @return Palauttaa koko alkuperäisen
     */
    public Image haeAlkuperainen() {
        return this.lahde.getImage();
    }

    public ImageIcon haeAlkuperainenThumbnail() {
        ImageIcon kuva = new ImageIcon(temp.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        return kuva;
    }
}

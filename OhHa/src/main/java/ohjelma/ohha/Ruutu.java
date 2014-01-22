
package ohjelma.ohha;

/**
 *
 * @author WidestM
 */
public class Ruutu {
    private int xKoord;
    private int yKoord;
    private int numero;

    public Ruutu(int numero) {
        this.numero=numero;
    }

    public int getxKoord() {
        return xKoord;
    }

    public int getyKoord() {
        return yKoord;
    }

    public void setxKoord(int xKoord) {
        this.xKoord = xKoord;
    }

    public void setyKoord(int yKoord) {
        this.yKoord = yKoord;
    }
    
    
}

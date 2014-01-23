
package ohjelma.ohha;

/**
 *
 * @author WidestM
 */
public class Ruutu {
    private int xKoord;
    private int yKoord;
    private int ruudunTila;

    public Ruutu(int xKoord, int yKoord, int ruudunTila) {
        this.xKoord = xKoord;
        this.yKoord = yKoord;
        this.ruudunTila = ruudunTila;
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
    public int getTila(){
        return this.ruudunTila;
    }
    
    
}

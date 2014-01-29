
package ohjelma.ohha;

/**
 *
 * @author WidestM
 */
public class Ruutu {
    private int xKoord;
    private int yKoord;
    private int jNro;
    private boolean sisalto;

    public Ruutu(int xKoord, int yKoord, int jnro, boolean sisalto) {
        this.xKoord = xKoord;
        this.yKoord = yKoord;
        this.jNro = jnro;
        this.sisalto=sisalto;
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
    public int getJNro(){
        return this.jNro;
    }

    public boolean getSisalto() {
        return sisalto;
    }

    public void setSisalto(boolean sisalto) {
        this.sisalto = sisalto;
    }
    
    
}

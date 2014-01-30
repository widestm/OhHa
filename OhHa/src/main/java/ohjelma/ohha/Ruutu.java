package ohjelma.ohha;

/**
 *
 * @author WidestM
 */
public class Ruutu {

    private int xKoord;
    private int yKoord;
    private int jNro;

    public Ruutu(int xKoord, int yKoord, int jnro) {
        this.xKoord = xKoord;
        this.yKoord = yKoord;
        this.jNro = jnro;
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

    public int getJNro() {
        return this.jNro;
    }

    public void setjNro(int jNro) {
        this.jNro = jNro;
    }

}

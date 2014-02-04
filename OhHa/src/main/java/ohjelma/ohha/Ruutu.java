package ohjelma.ohha;

/**
 *
 * @author WidestM
 */
public class Ruutu {

    private int xKoord;
    private int yKoord;
    private int jNro;

    /**
     *
     * @param xKoord
     * @param yKoord
     * @param jnro
     */
    public Ruutu(int xKoord, int yKoord, int jnro) {
        this.xKoord = xKoord;
        this.yKoord = yKoord;
        this.jNro = jnro;
    }

    /**
     *
     * @return
     */
    public int getxKoord() {
        return xKoord;
    }

    /**
     *
     * @return
     */
    public int getyKoord() {
        return yKoord;
    }

    /**
     *
     * @param xKoord
     */
    public void setxKoord(int xKoord) {
        this.xKoord = xKoord;
    }

    /**
     *
     * @param yKoord
     */
    public void setyKoord(int yKoord) {
        this.yKoord = yKoord;
    }

    /**
     *
     * @return
     */
    public int getJNro() {
        return this.jNro;
    }

    /**
     *
     * @param jNro
     */
    public void setjNro(int jNro) {
        this.jNro = jNro;
    }

}

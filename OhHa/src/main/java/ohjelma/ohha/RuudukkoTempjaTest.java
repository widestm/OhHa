package ohjelma.ohha;

public class RuudukkoTempjaTest {

    int[][] ruudukko;
    int korkeus;
    int leveys;
    int tyhjaRivi;
    int tyhjaSarake;

    public RuudukkoTempjaTest() {
        korkeus = 4;
        leveys = 3;
        tyhjaRivi = 0;
        tyhjaSarake = 2;
    }

    public void tayta() {
        ruudukko = new int[korkeus][leveys];

        for (int sarake = 0; sarake < korkeus; sarake++) {
            for (int rivi = 0; rivi < leveys; rivi++) {
                ruudukko[sarake][rivi] = 1;

            }
        }
    }

    public void tulosta() {
        String tulostus = "";
        for (int i = 0; i < ruudukko.length; i++) {
            for (int j = 0; j < ruudukko[0].length; j++) {
                tulostus += ruudukko[i][j];
            }
            tulostus += "\n";
        }
        System.out.println(tulostus);
    }

    public void asetaTyhja() {
        ruudukko[tyhjaRivi][tyhjaSarake] = 0;
    }

    public boolean meneekoYliLaudan(int r, int s) {
        return false;
    }

    public void siirto(int r, int s) {
        if (r > 0 && ruudukko[r - 1][s] == 0) {                     //ylhäälle siirto
            ruudukko[r][s] = 0;
            ruudukko[r - 1][s] = 1;
        } else if (r < (korkeus - 1) && ruudukko[r + 1][s] == 0) {  //alhaalle
            ruudukko[r][s] = 0;
            ruudukko[r + 1][s] = 1;
        } else if (s > 0 && ruudukko[r][s - 1] == 0) {              //vasempaan
            ruudukko[r][s] = 0;
            ruudukko[r][s - 1] = 1;
        } else if (s < leveys - 1 && ruudukko[r][s + 1] == 0) {     //oikealle
            ruudukko[r][s] = 0;
            ruudukko[r][s + 1] = 1;
        }

    }

}

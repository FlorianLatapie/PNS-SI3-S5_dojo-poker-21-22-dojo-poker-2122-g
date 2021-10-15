package com.dojopoker.test;

import com.dojopoker.main.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dojopoker.main.VictoiresPossibles.*;

public class DoublePaireTest {

    private ComparateurMain cm = new ComparateurMain();

    @Test
    public void doublePaireVsCarteHauteTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(4));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(5));
        listeMain2.add(new Carte(7));
        listeMain2.add(new Carte(8));
        listeMain2.add(new Carte(9));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, DOUBLE_PAIRE, new Carte[] {new Carte(2), new Carte(1)}), cm.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, DOUBLE_PAIRE, new Carte[] {new Carte(2), new Carte(1)}), cm.compare(main2, main1));
    }

    @Test
    public void doublePaireVsPaireTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(4));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(8));
        listeMain2.add(new Carte(9));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, DOUBLE_PAIRE, new Carte[] {new Carte(2), new Carte(1)}), cm.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, DOUBLE_PAIRE, new Carte[] {new Carte(2), new Carte(1)}), cm.compare(main2, main1));
    }

    @Test
    public void paireEgaliteTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(4));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(1));
        listeMain2.add(new Carte(1));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(5));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(2, CARTE_LA_PLUS_HAUTE, new Carte[]{new Carte(5)}), cm.compare(main1, main2));
        Assert.assertEquals(new Gagnant(1, CARTE_LA_PLUS_HAUTE, new Carte[]{new Carte(5)}), cm.compare(main2, main1));

        List<Carte> listeMain3 = new ArrayList<>();
        listeMain3.add(new Carte(2));
        listeMain3.add(new Carte(2));
        listeMain3.add(new Carte(1));
        listeMain3.add(new Carte(1));
        listeMain3.add(new Carte(4));

        Main main3 = new Main(listeMain3);

        List<Carte> listeMain4 = new ArrayList<>();
        listeMain4.add(new Carte(1));
        listeMain4.add(new Carte(1));
        listeMain4.add(new Carte(2));
        listeMain4.add(new Carte(2));
        listeMain4.add(new Carte(5));

        Main main4 = new Main(listeMain4);

        Assert.assertEquals(new Gagnant(2, CARTE_LA_PLUS_HAUTE, new Carte[]{new Carte(5)}), cm.compare(main3, main4));
        Assert.assertEquals(new Gagnant(1, CARTE_LA_PLUS_HAUTE, new Carte[]{new Carte(5)}), cm.compare(main4, main3));

        Assert.assertEquals(new Gagnant(0, EGALITE, null), cm.compare(main1, main1));
    }

        @Test
        public void doublePaireVsDoublePaireTest() {
        List<Carte> listeMain5 = new ArrayList<>();
        listeMain5.add(new Carte(5));
        listeMain5.add(new Carte(5));
        listeMain5.add(new Carte(1));
        listeMain5.add(new Carte(1));
        listeMain5.add(new Carte(4));

        Main main5 = new Main(listeMain5);

        List<Carte> listeMain6 = new ArrayList<>();
        listeMain6.add(new Carte(3));
        listeMain6.add(new Carte(3));
        listeMain6.add(new Carte(2));
        listeMain6.add(new Carte(2));
        listeMain6.add(new Carte(5));

        Main main6 = new Main(listeMain6);

        Assert.assertEquals(new Gagnant(1, DOUBLE_PAIRE, new Carte[] {new Carte(5),new Carte(1)}), cm.compare(main5, main6));
        Assert.assertEquals(new Gagnant(2, DOUBLE_PAIRE, new Carte[] {new Carte(5),new Carte(1)}), cm.compare(main6, main5));

        List<Carte> listeMain9 = new ArrayList<>();
        listeMain9.add(new Carte(10));
        listeMain9.add(new Carte(10));
        listeMain9.add(new Carte(2));
        listeMain9.add(new Carte(2));
        listeMain9.add(new Carte(5));

        Main main9 = new Main(listeMain9);

        List<Carte> listeMain10 = new ArrayList<>();
        listeMain10.add(new Carte(10));
        listeMain10.add(new Carte(10));
        listeMain10.add(new Carte(1));
        listeMain10.add(new Carte(1));
        listeMain10.add(new Carte(4));

        Main main10 = new Main(listeMain10);

        Assert.assertEquals(new Gagnant(1, DOUBLE_PAIRE, new Carte[] {new Carte(10),new Carte(2)}), cm.compare(main9, main10));
        Assert.assertEquals(new Gagnant(2, DOUBLE_PAIRE, new Carte[] {new Carte(10),new Carte(2)}), cm.compare(main10, main9));
    }
}
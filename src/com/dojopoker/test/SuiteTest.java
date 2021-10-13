package com.dojopoker.test;

import com.dojopoker.main.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dojopoker.main.VictoiresPossibles.*;

public class SuiteTest {
    @Test
    public void suiteVsCarteHauteTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(3));
        listeMain1.add(new Carte(4));
        listeMain1.add(new Carte(5));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(5));
        listeMain2.add(new Carte(7));
        listeMain2.add(new Carte(8));
        listeMain2.add(new Carte(9));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, SUITE, new Carte[] {new Carte(1), new Carte(2), new Carte(3), new Carte(4), new Carte(5)}), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, SUITE, new Carte[] {new Carte(1), new Carte(2), new Carte(3), new Carte(4), new Carte(5)}), ComparateurMain.compare(main2, main1));

    }

    @Test
    public void suiteVsPaireTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(3));
        listeMain1.add(new Carte(4));
        listeMain1.add(new Carte(5));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(1));
        listeMain2.add(new Carte(4));
        listeMain2.add(new Carte(3));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, SUITE, new Carte[] {new Carte(1), new Carte(2), new Carte(3), new Carte(4), new Carte(5)}), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, SUITE, new Carte[] {new Carte(1), new Carte(2), new Carte(3), new Carte(4), new Carte(5)}), ComparateurMain.compare(main2, main1));
    }

    @Test
    public void suiteVsDoublePaireTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(3));
        listeMain1.add(new Carte(4));
        listeMain1.add(new Carte(5));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(4));
        listeMain2.add(new Carte(3));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, SUITE, new Carte[] {new Carte(1), new Carte(2), new Carte(3), new Carte(4), new Carte(5)}), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, SUITE, new Carte[] {new Carte(1), new Carte(2), new Carte(3), new Carte(4), new Carte(5)}), ComparateurMain.compare(main2, main1));
    }

    @Test
    public void suiteVsBrelanTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(3));
        listeMain1.add(new Carte(4));
        listeMain1.add(new Carte(5));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(4));
        listeMain2.add(new Carte(3));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, SUITE, new Carte[] {new Carte(1), new Carte(2), new Carte(3), new Carte(4), new Carte(5)}), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, SUITE, new Carte[] {new Carte(1), new Carte(2), new Carte(3), new Carte(4), new Carte(5)}), ComparateurMain.compare(main2, main1));
    }

    @Test
    public void suiteVsCarreTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(3));
        listeMain1.add(new Carte(4));
        listeMain1.add(new Carte(5));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(6));
        listeMain2.add(new Carte(6));
        listeMain2.add(new Carte(6));
        listeMain2.add(new Carte(6));
        listeMain2.add(new Carte(3));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, CARRE, new Carte[] {new Carte(6)}), ComparateurMain.compare(main2, main1));
        Assert.assertEquals(new Gagnant(2, CARRE, new Carte[] {new Carte(6)}), ComparateurMain.compare(main1, main2));

    }

    @Test
    public void suiteVsFullTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(3));
        listeMain1.add(new Carte(4));
        listeMain1.add(new Carte(5));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(3));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(2, FULL, new Carte[] {new Carte(2), new Carte(3)}), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(1, FULL, new Carte[] {new Carte(2), new Carte(3)}), ComparateurMain.compare(main2, main1));

    }

}

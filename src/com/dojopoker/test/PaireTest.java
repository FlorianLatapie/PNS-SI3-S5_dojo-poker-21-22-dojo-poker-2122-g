package com.dojopoker.test;

import com.dojopoker.main.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PaireTest {
    @Test
    public void paireVsCarteHauteTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(3));
        listeMain1.add(new Carte(4));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(5));
        listeMain2.add(new Carte(7));
        listeMain2.add(new Carte(8));
        listeMain2.add(new Carte(9));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);
        Assert.assertEquals(new Gagnant(1,VictoiresPossibles.paire, 1), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2,VictoiresPossibles.paire, 1), ComparateurMain.compare(main2, main1));
    }

    @Test
    public void paireVsPaireTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(3));
        listeMain1.add(new Carte(4));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(8));
        listeMain2.add(new Carte(9));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(2,VictoiresPossibles.paire, 2), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(1,VictoiresPossibles.paire, 2), ComparateurMain.compare(main2, main1));

        List<Carte> listeMain3 = new ArrayList<>();
        listeMain3.add(new Carte(8));
        listeMain3.add(new Carte(8));
        listeMain3.add(new Carte(1));
        listeMain3.add(new Carte(2));
        listeMain3.add(new Carte(3));

        Main main3 = new Main(listeMain3);

        List<Carte> listeMain4 = new ArrayList<>();
        listeMain4.add(new Carte(8));
        listeMain4.add(new Carte(8));
        listeMain4.add(new Carte(1));
        listeMain4.add(new Carte(2));
        listeMain4.add(new Carte(5));

        Main main4 = new Main(listeMain4);

        Assert.assertEquals(new Gagnant(2,VictoiresPossibles.carte_la_plus_haute, 5), ComparateurMain.compare(main3, main4));
        Assert.assertEquals(new Gagnant(1,VictoiresPossibles.carte_la_plus_haute, 5), ComparateurMain.compare(main4, main3));
    }

    @Test
    public void paireEgaliteTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(3));
        listeMain1.add(new Carte(4));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(1));
        listeMain2.add(new Carte(1));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(5));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(2,VictoiresPossibles.carte_la_plus_haute, 5), ComparateurMain.compare(main1, main2));
    }
}

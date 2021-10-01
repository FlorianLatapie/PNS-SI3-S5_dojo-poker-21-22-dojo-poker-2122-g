package com.dojopoker.test;

import com.dojopoker.main.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DoublePaireTest {
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
        listeMain2.add(new Carte(6));
        listeMain2.add(new Carte(7));
        listeMain2.add(new Carte(8));
        listeMain2.add(new Carte(9));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, VictoiresPossibles.double_paire, new Integer[] {2, 1}), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, VictoiresPossibles.double_paire, new Integer[] {2, 1}), ComparateurMain.compare(main2, main1));
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

        Assert.assertEquals(new Gagnant(1, VictoiresPossibles.double_paire, new Integer[] {2, 1}), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, VictoiresPossibles.double_paire, new Integer[] {2, 1}), ComparateurMain.compare(main2, main1));
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

        Assert.assertEquals(new Gagnant(2, VictoiresPossibles.double_paire, new Integer[] {2, 1, 5}), ComparateurMain.compare(main1, main2));
    }
}
package com.dojopoker.test;

import com.dojopoker.main.Carte;
import com.dojopoker.main.ComparateurCarte;
import com.dojopoker.main.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PlusHauteCarteTest {
    @Test
    public void testMain1Gagne() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(3));
        listeMain1.add(new Carte(5));
        listeMain1.add(new Carte(6));
        listeMain1.add(new Carte(8));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(5));
        listeMain2.add(new Carte(6));
        listeMain2.add(new Carte(7));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals("Main 1 gagne !", ComparateurCarte.compare(main1, main2));
    }

    @Test
    public void testMain2Gagne() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(3));
        listeMain1.add(new Carte(5));
        listeMain1.add(new Carte(6));
        listeMain1.add(new Carte(8));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(5));
        listeMain2.add(new Carte(6));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals("Main 2 gagne !", ComparateurCarte.compare(main1, main2));
    }

    @Test
    public void testMainEgalite() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(3));
        listeMain1.add(new Carte(5));
        listeMain1.add(new Carte(6));
        listeMain1.add(new Carte(10));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(5));
        listeMain2.add(new Carte(6));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals("Egalité !", ComparateurCarte.compare(main1, main2));
    }
}

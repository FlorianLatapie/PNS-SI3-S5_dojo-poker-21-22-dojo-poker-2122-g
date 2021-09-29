package com.dojopoker.test;

import com.dojopoker.main.Carte;
import com.dojopoker.main.ComparateurCarte;
import com.dojopoker.main.ComparateurMain;
import com.dojopoker.main.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


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

        Assert.assertEquals("La main 1 gagne avec carte la plus haute : 8", ComparateurMain.compare(main1, main2).toString());
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

        Assert.assertEquals("La main 2 gagne avec carte la plus haute : 10", ComparateurMain.compare(main1, main2).toString());
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

        Assert.assertEquals("Egalité", ComparateurMain.compare(main1, main2).toString());

        List<Carte> listeMain3 = new ArrayList<>();
        listeMain3.add(new Carte(2));
        listeMain3.add(new Carte(3));
        listeMain3.add(new Carte(5));
        listeMain3.add(new Carte(6));
        listeMain3.add(new Carte(10));

        Main main3 = new Main(listeMain3);

        List<Carte> listeMain4 = new ArrayList<>();
        listeMain4.add(new Carte(2));
        listeMain4.add(new Carte(3));
        listeMain4.add(new Carte(5));
        listeMain4.add(new Carte(6));
        listeMain4.add(new Carte(9));

        Main main4 = new Main(listeMain4);

        Assert.assertEquals("La main 1 gagne avec carte la plus haute : 10", ComparateurMain.compare(main3, main4).toString());
    }
}

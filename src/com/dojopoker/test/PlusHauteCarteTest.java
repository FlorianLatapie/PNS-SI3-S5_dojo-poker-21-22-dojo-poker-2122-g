package com.dojopoker.test;

import com.dojopoker.main.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class PlusHauteCarteTest {
    @Test
    public void pasDeCarteTest(){
        List<Carte> listeMain1 = new ArrayList<>();
        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(0,VictoiresPossibles.egalite, null), ComparateurMain.compare(main1, main2));
    }

    @Test
    public void main1GagneTest() {
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

        Assert.assertEquals(new Gagnant(1,VictoiresPossibles.carte_la_plus_haute, new Carte(8)), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2,VictoiresPossibles.carte_la_plus_haute, new Carte(8)), ComparateurMain.compare(main2, main1));
    }

    @Test
    public void main2GagneTest() {
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

        Assert.assertEquals(new Gagnant(1,VictoiresPossibles.carte_la_plus_haute, new Carte(10)), ComparateurMain.compare(main2, main1));
        Assert.assertEquals(new Gagnant(2,VictoiresPossibles.carte_la_plus_haute, new Carte(10)), ComparateurMain.compare(main1, main2));
    }

    @Test
    public void mainEgaliteTest() {
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

        Assert.assertEquals(new Gagnant(0,VictoiresPossibles.egalite, null), ComparateurMain.compare(main1, main2));

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

        Assert.assertEquals(new Gagnant(1,VictoiresPossibles.carte_la_plus_haute, new Carte(10)), ComparateurMain.compare(main3, main4));
        Assert.assertEquals(new Gagnant(2,VictoiresPossibles.carte_la_plus_haute, new Carte(10)), ComparateurMain.compare(main4, main3));
    }
}

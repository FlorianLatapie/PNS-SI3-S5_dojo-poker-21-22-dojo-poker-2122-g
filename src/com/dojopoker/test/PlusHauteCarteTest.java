package com.dojopoker.test;

import com.dojopoker.main.Carte;
import com.dojopoker.main.ComparateurMain;
import com.dojopoker.main.Gagnant;
import com.dojopoker.main.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dojopoker.main.VictoiresPossibles.CARTE_LA_PLUS_HAUTE;
import static com.dojopoker.main.VictoiresPossibles.EGALITE;

public class PlusHauteCarteTest {
    private ComparateurMain cm = new ComparateurMain();

    @Test
    public void pasDeCarteTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(0, EGALITE, null), cm.compare(main1, main2));
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

        Assert.assertEquals(new Gagnant(1, CARTE_LA_PLUS_HAUTE, new Carte(8)), cm.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, CARTE_LA_PLUS_HAUTE, new Carte(8)), cm.compare(main2, main1));
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

        Assert.assertEquals(new Gagnant(1, CARTE_LA_PLUS_HAUTE, new Carte(10)), cm.compare(main2, main1));
        Assert.assertEquals(new Gagnant(2, CARTE_LA_PLUS_HAUTE, new Carte(10)), cm.compare(main1, main2));

        List<Carte> listeMain3 = new ArrayList<>();
        listeMain3.add(new Carte(10, "Tr"));
        listeMain3.add(new Carte(9, "Tr"));
        listeMain3.add(new Carte(8, "Ca"));
        listeMain3.add(new Carte(4, "Tr"));
        listeMain3.add(new Carte(2, "Tr"));

        Main main3 = new Main(listeMain3);

        List<Carte> listeMain4 = new ArrayList<>();
        listeMain4.add(new Carte("A", "Ca"));
        listeMain4.add(new Carte(2, "Ca"));
        listeMain4.add(new Carte(3, "Ca"));
        listeMain4.add(new Carte(4, "Ca"));
        listeMain4.add(new Carte(5, "Tr"));

        Main main4 = new Main(listeMain4);

        Assert.assertEquals(new Gagnant(2, CARTE_LA_PLUS_HAUTE, new Carte(14)), cm.compare(main3, main4));
        Assert.assertEquals(new Gagnant(1, CARTE_LA_PLUS_HAUTE, new Carte(14)), cm.compare(main4, main3));
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

        Assert.assertEquals(new Gagnant(0, EGALITE, null), cm.compare(main1, main2));

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

        Assert.assertEquals(new Gagnant(1, CARTE_LA_PLUS_HAUTE, new Carte(10)), cm.compare(main3, main4));
        Assert.assertEquals(new Gagnant(2, CARTE_LA_PLUS_HAUTE, new Carte(10)), cm.compare(main4, main3));
    }
}

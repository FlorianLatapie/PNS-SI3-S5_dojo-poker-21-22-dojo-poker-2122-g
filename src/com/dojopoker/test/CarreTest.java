package com.dojopoker.test;

import com.dojopoker.main.Carte;
import com.dojopoker.main.ComparateurMain;
import com.dojopoker.main.Gagnant;
import com.dojopoker.main.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dojopoker.main.VictoiresPossibles.*;

public class CarreTest {

    private ComparateurMain cm = new ComparateurMain();

    @Test
    public void carreVsCarteHauteTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(4));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(6));
        listeMain2.add(new Carte(7));
        listeMain2.add(new Carte(8));
        listeMain2.add(new Carte(9));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, CARRE, new Carte[]{new Carte(1)}), cm.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, CARRE, new Carte[]{new Carte(1)}), cm.compare(main2, main1));
    }

    @Test
    public void carreVsCarreSuperieurTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(4));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(4));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(2, CARRE, new Carte[]{new Carte(2)}), cm.compare(main1, main2));
        Assert.assertEquals(new Gagnant(1, CARRE, new Carte[]{new Carte(2)}), cm.compare(main2, main1));
    }

    @Test
    public void carreVsPaireTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(4));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(1));
        listeMain2.add(new Carte(4));
        listeMain2.add(new Carte(3));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, CARRE, new Carte[]{new Carte(1)}), cm.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, CARRE, new Carte[]{new Carte(1)}), cm.compare(main2, main1));
    }

    @Test
    public void carreVsDoublePaireTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(4));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(1));
        listeMain2.add(new Carte(10));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, CARRE, new Carte[]{new Carte(1)}), cm.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, CARRE, new Carte[]{new Carte(1)}), cm.compare(main2, main1));
    }

    @Test
    public void carreEgaliteTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(4));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(1));
        listeMain2.add(new Carte(1));
        listeMain2.add(new Carte(1));
        listeMain2.add(new Carte(1));
        listeMain2.add(new Carte(5));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(2, CARTE_LA_PLUS_HAUTE, new Carte[]{new Carte(5)}), cm.compare(main1, main2));
        Assert.assertEquals(new Gagnant(1, CARTE_LA_PLUS_HAUTE, new Carte[]{new Carte(5)}), cm.compare(main2, main1));

    }


    @Test
    public void carreVsFullTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(5));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(5));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(2));
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(3));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(2, CARRE, new Carte[]{new Carte(3)}), cm.compare(main1, main2));
        Assert.assertEquals(new Gagnant(1, CARRE, new Carte[]{new Carte(3)}), cm.compare(main2, main1));

        List<Carte> listeMain9 = new ArrayList<>();
        listeMain9.add(new Carte(1));
        listeMain9.add(new Carte(1));
        listeMain9.add(new Carte(2));
        listeMain9.add(new Carte(2));
        listeMain9.add(new Carte(2));

        Main main9 = new Main(listeMain9);

        List<Carte> listeMain10 = new ArrayList<>();
        listeMain10.add(new Carte(10));
        listeMain10.add(new Carte(10));
        listeMain10.add(new Carte(10));
        listeMain10.add(new Carte(10));
        listeMain10.add(new Carte(9));

        Main main10 = new Main(listeMain10);

        Assert.assertEquals(new Gagnant(2, CARRE, new Carte[]{new Carte(10)}), cm.compare(main9, main10));
        Assert.assertEquals(new Gagnant(1, CARRE, new Carte[]{new Carte(10)}), cm.compare(main10, main9));
        Assert.assertEquals(new Gagnant(0, EGALITE, null), cm.compare(main10, main10));
    }
}

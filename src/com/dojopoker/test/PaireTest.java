package com.dojopoker.test;

import com.dojopoker.main.Carte;
import com.dojopoker.main.ComparateurCarte;
import com.dojopoker.main.Main;
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
        listeMain2.add(new Carte(6));
        listeMain2.add(new Carte(7));
        listeMain2.add(new Carte(8));
        listeMain2.add(new Carte(9));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals("Main 1 gagne ! grâce à paire : 1", ComparateurCarte.compare(main1, main2));
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

        Assert.assertEquals("Main 2 gagne ! grâce à paire vs paire : 2", ComparateurCarte.compare(main1, main2));

        Main main3 = new Main(listeMain1);
        Main main4 = new Main(listeMain2);

        Assert.assertEquals("Main 1 gagne ! grâce à paire vs paire : 2", ComparateurCarte.compare(main4, main3));
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

        Assert.assertEquals("Main 2 gagne ! carte la plus haute : ", ComparateurCarte.compare(main1, main2));
    }
}

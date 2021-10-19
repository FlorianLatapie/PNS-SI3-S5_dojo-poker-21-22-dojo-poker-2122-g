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

public class QuinteFlushTest {

    private ComparateurMain cm = new ComparateurMain();

    @Test
    public void QuinteFlushEgaliteTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1, "Tr"));
        listeMain1.add(new Carte(2, "Tr"));
        listeMain1.add(new Carte(3, "Tr"));
        listeMain1.add(new Carte(4, "Tr"));
        listeMain1.add(new Carte(5, "Tr"));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(1, "Co"));
        listeMain2.add(new Carte(4, "Co"));
        listeMain2.add(new Carte(3, "Co"));
        listeMain2.add(new Carte(2, "Co"));
        listeMain2.add(new Carte(5, "Co"));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(0, EGALITE), cm.compare(main1, main2));
    }

    @Test
    public void QuinteFlushVsQuinteFlushTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1, "Tr"));
        listeMain1.add(new Carte(2, "Tr"));
        listeMain1.add(new Carte(3, "Tr"));
        listeMain1.add(new Carte(4, "Tr"));
        listeMain1.add(new Carte(5, "Tr"));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2, "Co"));
        listeMain2.add(new Carte(3, "Co"));
        listeMain2.add(new Carte(4, "Co"));
        listeMain2.add(new Carte(5, "Co"));
        listeMain2.add(new Carte(6, "Co"));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(2, QUINTE_FLUSH, new Carte(2, "Co"), new Carte(3, "Co"), new Carte(4, "Co"), new Carte(5, "Co"), new Carte(6, "Co")), cm.compare(main1, main2));
        Assert.assertEquals(new Gagnant(1, QUINTE_FLUSH, new Carte(2, "Co"), new Carte(3, "Co"), new Carte(4, "Co"), new Carte(5, "Co"), new Carte(6, "Co")), cm.compare(main2, main1));

    }

    @Test
    public void QuinteFlushVsSuiteTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1, "Tr"));
        listeMain1.add(new Carte(2, "Tr"));
        listeMain1.add(new Carte(3, "Tr"));
        listeMain1.add(new Carte(4, "Tr"));
        listeMain1.add(new Carte(5, "Tr"));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(6, "Tr"));
        listeMain2.add(new Carte(5, "Co"));
        listeMain2.add(new Carte(4, "Ca"));
        listeMain2.add(new Carte(3, "Pi"));
        listeMain2.add(new Carte(2, "Tr"));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, QUINTE_FLUSH, new Carte(1, "Tr"), new Carte(2, "Tr"), new Carte(3, "Tr"), new Carte(4, "Tr"), new Carte(5, "Tr")), cm.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, QUINTE_FLUSH, new Carte(1, "Tr"), new Carte(2, "Tr"), new Carte(3, "Tr"), new Carte(4, "Tr"), new Carte(5, "Tr")), cm.compare(main2, main1));
    }
}

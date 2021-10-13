package com.dojopoker.test;

import com.dojopoker.main.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dojopoker.main.VictoiresPossibles.*;

public class FullTest {
    @Test
    public void fullVsCarteHauteTest(){
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(2));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(6));
        listeMain2.add(new Carte(7));
        listeMain2.add(new Carte(8));
        listeMain2.add(new Carte(9));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, FULL, new Carte[] {new Carte(2),new Carte(1)}), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, FULL, new Carte[] {new Carte(2),new Carte(1)}), ComparateurMain.compare(main2, main1));
    }

    @Test
    public void fullVsPaireTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(2));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(8));
        listeMain2.add(new Carte(9));
        listeMain2.add(new Carte(10));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, FULL, new Carte[] {new Carte(2),new Carte(1)}), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, FULL, new Carte[] {new Carte(2),new Carte(1)}), ComparateurMain.compare(main2, main1));
    }

    @Test
    public void fullVsDoublePaireTest() {
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(1));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(2));
        listeMain1.add(new Carte(2));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(3));
        listeMain2.add(new Carte(4));
        listeMain2.add(new Carte(4));
        listeMain2.add(new Carte(5));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1, FULL, new Carte[]{new Carte(2),new Carte(1)}), ComparateurMain.compare(main1, main2));
        Assert.assertEquals(new Gagnant(2, FULL, new Carte[]{new Carte(2),new Carte(1)}), ComparateurMain.compare(main2, main1));


        List<Carte> listeMain3 = new ArrayList<>();
        listeMain3.add(new Carte(3));
        listeMain3.add(new Carte(3));
        listeMain3.add(new Carte(4));
        listeMain3.add(new Carte(4));
        listeMain3.add(new Carte(4));

        Main main3 = new Main(listeMain3);

        List<Carte> listeMain4 = new ArrayList<>();
        listeMain4.add(new Carte(1));
        listeMain4.add(new Carte(1));
        listeMain4.add(new Carte(2));
        listeMain4.add(new Carte(2));
        listeMain4.add(new Carte(3));

        Main main4 = new Main(listeMain4);

        Assert.assertEquals(new Gagnant(1, FULL, new Carte[]{new Carte(4),new Carte(3)}), ComparateurMain.compare(main3, main4));
        Assert.assertEquals(new Gagnant(2, FULL, new Carte[]{new Carte(4),new Carte(3)}), ComparateurMain.compare(main4, main3));

    }

    @Test
    public void fullVsFullTest() {
        List<Carte> listeMain5 = new ArrayList<>();
        listeMain5.add(new Carte(5));
        listeMain5.add(new Carte(5));
        listeMain5.add(new Carte(1));
        listeMain5.add(new Carte(1));
        listeMain5.add(new Carte(1));

        Main main5 = new Main(listeMain5);

        List<Carte> listeMain6 = new ArrayList<>();
        listeMain6.add(new Carte(3));
        listeMain6.add(new Carte(3));
        listeMain6.add(new Carte(2));
        listeMain6.add(new Carte(2));
        listeMain6.add(new Carte(2));

        Main main6 = new Main(listeMain6);

        Assert.assertEquals(new Gagnant(2, FULL, new Carte[] {new Carte(2),new Carte(3)}), ComparateurMain.compare(main5, main6));
        Assert.assertEquals(new Gagnant(1, FULL, new Carte[] {new Carte(2),new Carte(3)}), ComparateurMain.compare(main6, main5));

        List<Carte> listeMain9 = new ArrayList<>();
        listeMain9.add(new Carte(10));
        listeMain9.add(new Carte(10));
        listeMain9.add(new Carte(2));
        listeMain9.add(new Carte(2));
        listeMain9.add(new Carte(2));

        Main main9 = new Main(listeMain9);

        List<Carte> listeMain10 = new ArrayList<>();
        listeMain10.add(new Carte(9));
        listeMain10.add(new Carte(9));
        listeMain10.add(new Carte(2));
        listeMain10.add(new Carte(2));
        listeMain10.add(new Carte(2));

        Main main10 = new Main(listeMain10);

        Assert.assertEquals(new Gagnant(1, FULL, new Carte[] {new Carte(2),new Carte(10)}), ComparateurMain.compare(main9, main10));
        Assert.assertEquals(new Gagnant(2, FULL, new Carte[] {new Carte(2),new Carte(10)}), ComparateurMain.compare(main10, main9));
        Assert.assertEquals(new Gagnant(0, EGALITE,null), ComparateurMain.compare(main10,main10));
    }
}

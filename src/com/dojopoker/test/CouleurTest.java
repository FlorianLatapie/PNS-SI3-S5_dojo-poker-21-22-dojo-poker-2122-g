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

public class CouleurTest {
    @Test
    public void couleurVsCarteLaPlusHaute(){
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(2, "Tr"));
        listeMain1.add(new Carte(3, "Tr"));
        listeMain1.add(new Carte(4, "Tr"));
        listeMain1.add(new Carte(5, "Tr"));
        listeMain1.add(new Carte(7, "Tr"));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2, "Ca"));
        listeMain2.add(new Carte(3, "Ca"));
        listeMain2.add(new Carte(8,"Ca"));
        listeMain2.add(new Carte(9, "Ca"));
        listeMain2.add(new Carte(10, "Pi"));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1,COULEUR, new Carte(2,"Tr")), ComparateurMain.compare(main1,main2));
        Assert.assertEquals(new Gagnant(2,COULEUR, new Carte(2,"Tr")), ComparateurMain.compare(main2,main1));
    }

    @Test
    public void couleurVsPaire(){
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(2, "Tr"));
        listeMain1.add(new Carte(3, "Tr"));
        listeMain1.add(new Carte(4, "Tr"));
        listeMain1.add(new Carte(5, "Tr"));
        listeMain1.add(new Carte(7, "Tr"));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2, "Ca"));
        listeMain2.add(new Carte(2, "Pi"));
        listeMain2.add(new Carte(8,"Ca"));
        listeMain2.add(new Carte(9, "Ca"));
        listeMain2.add(new Carte(10, "Pi"));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1,COULEUR, new Carte(2,"Tr")), ComparateurMain.compare(main1,main2));
        Assert.assertEquals(new Gagnant(2,COULEUR, new Carte(2,"Tr")), ComparateurMain.compare(main2,main1));
    }

    @Test
    public void couleurVsDoublePaire(){
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(2, "Tr"));
        listeMain1.add(new Carte(3, "Tr"));
        listeMain1.add(new Carte(4, "Tr"));
        listeMain1.add(new Carte(5, "Tr"));
        listeMain1.add(new Carte(7, "Tr"));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2, "Ca"));
        listeMain2.add(new Carte(2, "Pi"));
        listeMain2.add(new Carte(8,"Ca"));
        listeMain2.add(new Carte(8, "Tr"));
        listeMain2.add(new Carte(10, "Pi"));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1,COULEUR, new Carte(2,"Tr")), ComparateurMain.compare(main1,main2));
        Assert.assertEquals(new Gagnant(2,COULEUR, new Carte(2,"Tr")), ComparateurMain.compare(main2,main1));
    }

    @Test
    public void couleurVsBrelan(){
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(2, "Tr"));
        listeMain1.add(new Carte(3, "Tr"));
        listeMain1.add(new Carte(4, "Tr"));
        listeMain1.add(new Carte(5, "Tr"));
        listeMain1.add(new Carte(7, "Tr"));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2, "Ca"));
        listeMain2.add(new Carte(2, "Pi"));
        listeMain2.add(new Carte(2,"Co"));
        listeMain2.add(new Carte(9, "Ca"));
        listeMain2.add(new Carte(10, "Pi"));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1,COULEUR, new Carte(2,"Tr")), ComparateurMain.compare(main1,main2));
        Assert.assertEquals(new Gagnant(2,COULEUR, new Carte(2,"Tr")), ComparateurMain.compare(main2,main1));
    }

    @Test
    public void couleurVsFull(){
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(2, "Tr"));
        listeMain1.add(new Carte(3, "Tr"));
        listeMain1.add(new Carte(4, "Tr"));
        listeMain1.add(new Carte(5, "Tr"));
        listeMain1.add(new Carte(7, "Tr"));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2, "Ca"));
        listeMain2.add(new Carte(2, "Pi"));
        listeMain2.add(new Carte(2,"Co"));
        listeMain2.add(new Carte(9, "Ca"));
        listeMain2.add(new Carte(9, "Pi"));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(2,FULL, new Carte[]{new Carte(2), new Carte(9)}), ComparateurMain.compare(main1,main2));
        Assert.assertEquals(new Gagnant(1,FULL, new Carte[]{new Carte(2), new Carte(9)}), ComparateurMain.compare(main2,main1));
    }

    @Test
    public void couleurVsSuite(){
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(2, "Tr"));
        listeMain1.add(new Carte(3, "Tr"));
        listeMain1.add(new Carte(4, "Tr"));
        listeMain1.add(new Carte(5, "Tr"));
        listeMain1.add(new Carte(7, "Tr"));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(6, "Ca"));
        listeMain2.add(new Carte(7, "Ca"));
        listeMain2.add(new Carte(8,"Ca"));
        listeMain2.add(new Carte(9, "Ca"));
        listeMain2.add(new Carte(10, "Pi"));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(1,COULEUR, new Carte(2,"Tr")), ComparateurMain.compare(main1,main2));
        Assert.assertEquals(new Gagnant(2,COULEUR, new Carte(2,"Tr")), ComparateurMain.compare(main2,main1));
    }

    @Test
    public void couleurVsCarre(){
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(2, "Tr"));
        listeMain1.add(new Carte(3, "Tr"));
        listeMain1.add(new Carte(4, "Tr"));
        listeMain1.add(new Carte(5, "Tr"));
        listeMain1.add(new Carte(7, "Tr"));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2, "Ca"));
        listeMain2.add(new Carte(8, "Ca"));
        listeMain2.add(new Carte(8,"Tr"));
        listeMain2.add(new Carte(8, "Co"));
        listeMain2.add(new Carte(8, "Pi"));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(2,CARRE, new Carte(8)), ComparateurMain.compare(main1,main2));
        Assert.assertEquals(new Gagnant(1,CARRE, new Carte(8)), ComparateurMain.compare(main2,main1));
    }

    @Test
    public void couleurVsCouleur(){
        List<Carte> listeMain1 = new ArrayList<>();
        listeMain1.add(new Carte(2, "Tr"));
        listeMain1.add(new Carte(3, "Tr"));
        listeMain1.add(new Carte(4, "Tr"));
        listeMain1.add(new Carte(5, "Tr"));
        listeMain1.add(new Carte(7, "Tr"));

        Main main1 = new Main(listeMain1);

        List<Carte> listeMain2 = new ArrayList<>();
        listeMain2.add(new Carte(2, "Ca"));
        listeMain2.add(new Carte(7, "Ca"));
        listeMain2.add(new Carte(8,"Ca"));
        listeMain2.add(new Carte(9, "Ca"));
        listeMain2.add(new Carte(10, "Ca"));

        Main main2 = new Main(listeMain2);

        Assert.assertEquals(new Gagnant(2,CARTE_LA_PLUS_HAUTE, new Carte(10)), ComparateurMain.compare(main1,main2));
        Assert.assertEquals(new Gagnant(1,CARTE_LA_PLUS_HAUTE, new Carte(10)), ComparateurMain.compare(main2,main1));
    }


}

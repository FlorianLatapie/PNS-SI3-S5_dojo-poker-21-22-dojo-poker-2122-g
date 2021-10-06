package com.dojopoker.test;

import com.dojopoker.main.Carte;
import com.dojopoker.main.Gagnant;
import com.dojopoker.main.VictoiresPossibles;
import org.junit.Assert;
import org.junit.Test;

public class GagnantTest {
    @Test
    public void toStringTest(){
        Gagnant g = new Gagnant(1, VictoiresPossibles.carte_la_plus_haute, new Carte(1));

        Assert.assertEquals("La main 1 gagne avec carte la plus haute : 1 ", g.toString());

        Gagnant g1 = new Gagnant(0, VictoiresPossibles.egalite, null);
        Gagnant g2 = new Gagnant(0, VictoiresPossibles.egalite);

        Assert.assertEquals("Égalité", g1.toString());
        Assert.assertEquals("Égalité", g2.toString());
    }

    @Test
    public void equalsTest(){
        Gagnant g1 = new Gagnant(1,VictoiresPossibles.paire, new Carte(1));
        Gagnant g2 = new Gagnant(1,VictoiresPossibles.paire, new Carte(2));
        Gagnant g3 = new Gagnant(1,VictoiresPossibles.paire, new Carte(1));

        Assert.assertTrue(g1.equals(g3));
        Assert.assertFalse(g1.equals(g2));
        Assert.assertFalse(g1.equals(null));
    }
}

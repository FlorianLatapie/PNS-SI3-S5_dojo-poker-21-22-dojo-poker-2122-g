package com.dojopoker.test;

import com.dojopoker.main.Carte;
import com.dojopoker.main.Gagnant;
import org.junit.Assert;
import org.junit.Test;

import static com.dojopoker.main.VictoiresPossibles.*;

public class GagnantTest {
    @Test
    public void toStringTest() {
        Gagnant g = new Gagnant(1, CARTE_LA_PLUS_HAUTE, new Carte(1));

        Assert.assertEquals("La main 1 gagne avec carte la plus haute : 1 ", g.toString());

        Gagnant g1 = new Gagnant(0, EGALITE, null);
        Gagnant g2 = new Gagnant(0, EGALITE);

        Assert.assertEquals("Égalité", g1.toString());
        Assert.assertEquals("Égalité", g2.toString());
    }

    @Test
    public void equalsTest() {
        Gagnant g1 = new Gagnant(1, PAIRE, new Carte(1));
        Gagnant g2 = new Gagnant(1, PAIRE, new Carte(2));
        Gagnant g3 = new Gagnant(1, PAIRE, new Carte(1));

        Assert.assertTrue(g1.equals(g3));
        Assert.assertFalse(g1.equals(g2));
        Assert.assertFalse(g1.equals(null));
    }
}

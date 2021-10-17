package com.dojopoker.test;

import com.dojopoker.main.Carte;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Florian Latapie
 */
public class CarteTest {

    @Test
    public void equalsTest() {
        Carte c1 = new Carte(1);
        Carte c2 = new Carte(2);
        Carte c3 = new Carte(1);

        Carte cValet = new Carte("V", "Tr");
        Carte cDame = new Carte("D", "Co");
        Carte cRoi = new Carte("R", "Ca");
        Carte cAs = new Carte("A", "Pi");

        Carte ncValet = new Carte(11, "Tr");
        Carte ncDame = new Carte(12, "Co");
        Carte ncRoi = new Carte(13, "Ca");
        Carte ncAs = new Carte(14, "Pi");

        Carte cV = new Carte(11);
        Carte cD = new Carte(12);
        Carte cR = new Carte(13);
        Carte cA = new Carte(14);

        Assert.assertTrue(c1.equals(c3));
        Assert.assertFalse(c1.equals(c2));
        Assert.assertFalse(c1.equals(null));

        Assert.assertEquals(11, cValet.getValeur());
        Assert.assertEquals(12, cDame.getValeur());
        Assert.assertEquals(13, cRoi.getValeur());
        Assert.assertEquals(14, cAs.getValeur());

        Assert.assertEquals("VTr", cValet.toString());
        Assert.assertEquals("DCo", cDame.toString());
        Assert.assertEquals("RCa", cRoi.toString());
        Assert.assertEquals("APi", cAs.toString());

        Assert.assertEquals(ncValet.toString(), cValet.toString());
        Assert.assertEquals(ncDame.toString(), cDame.toString());
        Assert.assertEquals(ncRoi.toString(), cRoi.toString());
        Assert.assertEquals(ncAs.toString(), cAs.toString());

        Assert.assertEquals("V", cV.toString());
        Assert.assertEquals("D", cD.toString());
        Assert.assertEquals("R", cR.toString());
        Assert.assertEquals("A", cA.toString());
    }
}

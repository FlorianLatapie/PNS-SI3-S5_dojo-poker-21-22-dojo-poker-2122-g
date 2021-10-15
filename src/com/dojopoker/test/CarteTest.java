package com.dojopoker.test;

import com.dojopoker.main.Carte;
import com.dojopoker.main.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarteTest {

    @Test
    public void equalsTest(){
        Carte c1 = new Carte(1);
        Carte c2 = new Carte(2);
        Carte c3 = new Carte(1);

        Carte cValet=new Carte("V", "Pi");
        Carte cDame=new Carte("D", "Ca");
        Carte cRoi=new Carte("R", "Co");
        Carte cAs = new Carte("A", "Tr");

        Assert.assertTrue(c1.equals(c3));
        Assert.assertFalse(c1.equals(c2));
        Assert.assertFalse(c1.equals(null));
        Assert.assertEquals(11,cValet.getValeur());
        Assert.assertEquals(12, cDame.getValeur());
        Assert.assertEquals(13,cRoi.getValeur());
        Assert.assertEquals(14,cAs.getValeur());
        Assert.assertEquals("VPi",cValet.toString());
        Assert.assertEquals("DCa",cDame.toString());
        Assert.assertEquals("RCo",cRoi.toString());
        Assert.assertEquals("ATr",cAs.toString());
    }
}

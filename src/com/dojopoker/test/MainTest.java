package com.dojopoker.test;

import com.dojopoker.main.Carte;
import com.dojopoker.main.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void toStringTest(){
        List<Carte> cartes = new ArrayList<>();
        cartes.add(new Carte(2));
        Main m = new Main(cartes);

        Assert.assertEquals("2 ", m.toString());

        cartes.add(new Carte(3));
        Assert.assertEquals("2 3 ", m.toString());
    }

    @Test
    public void equalsTest(){
        List<Carte> cm1 = new ArrayList<>();
        cm1.add(new Carte(1));

        List<Carte> cm2 = new ArrayList<>();
        cm2.add(new Carte(2));

        List<Carte> cm3 = new ArrayList<>();
        cm3.add(new Carte(1));

        Main m1 = new Main(cm1);
        Main m2 = new Main(cm2);
        Main m3 = new Main(cm3);

        Assert.assertTrue(m1.equals(m3));
        Assert.assertFalse(m1.equals(m2));
        Assert.assertFalse(m1.equals(null));
    }
}

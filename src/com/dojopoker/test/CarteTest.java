package com.dojopoker.test;

import com.dojopoker.main.Carte;
import com.dojopoker.main.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Florian Latapie
 */
public class CarteTest {

    @Test
    public void equalsTest(){
        Carte c1 = new Carte(1);
        Carte c2 = new Carte(2);
        Carte c3 = new Carte(1);

        Assert.assertTrue(c1.equals(c3));
        Assert.assertFalse(c1.equals(c2));
        Assert.assertFalse(c1.equals(null));
    }
}

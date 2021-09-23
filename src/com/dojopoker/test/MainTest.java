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
}

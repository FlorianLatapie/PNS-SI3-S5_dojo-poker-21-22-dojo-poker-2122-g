package com.dojopoker.test;

import com.dojopoker.main.Carte;
import com.dojopoker.main.EntreeSortie;
import com.dojopoker.main.Main;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class EntreeSortieTest {

    @Test
    public void reccupereMainTest(){
        List<Carte> cartesAttendues = new ArrayList<>();
        cartesAttendues.add(new Carte(1));
        cartesAttendues.add(new Carte(1));
        cartesAttendues.add(new Carte(1));
        cartesAttendues.add(new Carte(1));
        cartesAttendues.add(new Carte(1));
        Main attendu = new Main(cartesAttendues);

        Assert.assertEquals(attendu, EntreeSortie.reccupereMain("1 1 1 1 1"));

        Assert.assertNull(EntreeSortie.reccupereMain("1"));
    }
}
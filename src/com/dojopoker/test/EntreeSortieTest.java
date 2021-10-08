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
    public void reccupereMainTest() throws Exception {
        List<Carte> cartesAttendues = new ArrayList<>();
        cartesAttendues.add(new Carte(1));
        cartesAttendues.add(new Carte(1));
        cartesAttendues.add(new Carte(1));
        cartesAttendues.add(new Carte(1));
        cartesAttendues.add(new Carte(1));
        Main attendu = new Main(cartesAttendues);

        EntreeSortie es = new EntreeSortie();

        Assert.assertEquals(attendu, es.reccupereMain("1 1 1 1 1"));
    }

    @Test (expected = Exception.class)
    public void exceptionReccupereMainTest() throws Exception {
        EntreeSortie es = new EntreeSortie();
        es.reccupereMain("1");
    }
}

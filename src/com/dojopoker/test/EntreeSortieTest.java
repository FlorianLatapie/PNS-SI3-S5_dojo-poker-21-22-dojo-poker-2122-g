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
        cartesAttendues.add(new Carte(2,"Tr"));
        cartesAttendues.add(new Carte(3, "Pi"));
        cartesAttendues.add(new Carte(4, "Pi"));
        cartesAttendues.add(new Carte(5, "Ca"));
        cartesAttendues.add(new Carte(6, "Co"));
        Main attendu = new Main(cartesAttendues);

        EntreeSortie es = new EntreeSortie();

        Assert.assertEquals(attendu, es.reccupereMain("2Tr 3Pi 4Pi 5Ca 6Co"));
    }

    @Test (expected = Exception.class)
    public void reccupereMainImpossibleTest() throws Exception {
        EntreeSortie es = new EntreeSortie();
        es.reccupereMain("2Tr 2Tr 4Pi 5Ca 6Co");
    }

    @Test
    public void deuxMainsImpossibleTest() throws Exception {
        EntreeSortie es = new EntreeSortie();
        Main main1 = es.reccupereMain("10Pi 9Ca 8Co VPi 6Co");
        Main main2 = es.reccupereMain("3Tr VPi 2Ca 4Co 5Co");
        Main main3 = es.reccupereMain("3Tr RPi 2Ca 4Co 5Co");
        Assert.assertEquals(false, es.deuxMainsUniques(main1, main2));
        Assert.assertEquals(true, es.deuxMainsUniques(main1, main3));
    }

    @Test (expected = Exception.class)
    public void exceptionReccupereMainTest() throws Exception {
        EntreeSortie es = new EntreeSortie();
        es.reccupereMain("1");
    }
}

package com.dojopoker.test;

import com.dojopoker.main.Carte;
import com.dojopoker.main.Gagnant;
import com.dojopoker.main.PaquetCarte;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dojopoker.main.VictoiresPossibles.PAIRE;

public class PaquetCarteTest {

    private PaquetCarte paquet = new PaquetCarte();

    @Test
    public void creerPaquetTest(){
        List<String> paquetValide = List.of("2Tr", "2Ca", "2Co", "2Pi", "3Tr", "3Ca","3Co","3Pi","4Tr","4Ca","4Co","4Pi",
                                    "5Tr","5Ca","5Co","5Pi","6Tr","6Ca","6Co","6Pi","7Tr","7Ca","7Co","7Pi","8Tr","8Ca",
                                    "8Co","8Pi","9Tr","9Ca","9Co","9Pi", "10Tr", "10Ca", "10Co", "10Pi","VTr","VCa","VCo",
                                    "VPi","DTr","DCa","DCo","DPi", "RTr","RCa","RCo","RPi","ATr","ACa","ACo","APi");
        List<String> paquetAValider = new ArrayList<>();
        for(Carte carte : paquet.getPaquet()){
            paquetAValider.add(carte.toString());
        }

        Assert.assertEquals(paquetValide,paquetAValider);
    }

    @Test
    public void carteAuHasardTest(){
        PaquetCarte paquetTest = new PaquetCarte();
        paquetTest.carteAuHasard();
        Assert.assertEquals(51,paquetTest.getPaquet().size());
        paquetTest.carteAuHasard();
        Assert.assertEquals(50,paquetTest.getPaquet().size());
    }
}

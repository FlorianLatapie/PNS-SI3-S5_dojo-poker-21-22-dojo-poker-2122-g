package com.dojopoker.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PaquetCarte {
    private List<Carte> paquet;

    public PaquetCarte(){
        paquet = new ArrayList<>();
        creerPaquet();
    }

    private List<Carte> creerPaquet(){
        for(int i=2; i<=14; i++){
            Carte c = new Carte(i, "Tr");
            paquet.add(c);
            c = new Carte(i, "Ca");
            paquet.add(c);
            c = new Carte(i, "Co");
            paquet.add(c);
            c = new Carte(i, "Pi");
            paquet.add(c);
        }
        return paquet;
    }

    public Carte carteAuHasard(){
        Carte carte = paquet.get(new Random().nextInt(paquet.size()));
        paquet.remove(carte);
        return carte;
    }

    public List<Carte> getPaquet(){
        return paquet;
    }

}

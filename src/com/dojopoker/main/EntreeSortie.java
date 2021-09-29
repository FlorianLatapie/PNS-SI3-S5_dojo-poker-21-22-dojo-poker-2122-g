package com.dojopoker.main;

import java.util.ArrayList;
import java.util.List;

public class EntreeSortie {

    private static List<Carte> tableauStringVersListCarte(String[] saisie){
        List<Carte> retour = new ArrayList<>();
        for(String carte : saisie){
            int i = Integer.parseInt(carte);
            retour.add(new Carte(i));
        }
        return retour;
    }

    public static Main reccupereMain(String nextLine) {
        String[] saisies = nextLine.split(" ");

        if (saisies.length != 5){
            return null; // exception à ajouter ici
        }
        List<Carte> cartes = tableauStringVersListCarte(saisies);

        return new Main(cartes);
    }
}
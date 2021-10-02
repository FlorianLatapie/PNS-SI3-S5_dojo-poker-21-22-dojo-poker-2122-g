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

    public static Main reccupereMain(String entree) throws Exception {
        String[] saisies = entree.split(" ");

        if (saisies.length != 5){
            throw new Exception("Le nombre de cartes saisies est différent de 5");
        }
        List<Carte> cartes = tableauStringVersListCarte(saisies);

        return new Main(cartes);
    }
}
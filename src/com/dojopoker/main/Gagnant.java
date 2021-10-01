package com.dojopoker.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gagnant {
    private int joueur;
    private int valeurRaisonVictoire;
    private String raisonVictoire;
    private List<Integer> cartesGagnantes;
    private VictoiresPossibles victoire;



    public Gagnant(int joueur, VictoiresPossibles victoire, Integer... cartesGagnantes) {
        this.joueur = joueur;
        this.valeurRaisonVictoire = valeurRaisonVictoire;
        this.cartesGagnantes = new ArrayList<>();
        if (cartesGagnantes != null) {
            for (int i = 0; i < cartesGagnantes.length; i++) {
                this.cartesGagnantes.add(cartesGagnantes[i]);
            }
        }
        this.victoire = victoire;
    }


    private String cartesGagantsToString() {
        StringBuilder retour = new StringBuilder();
        int i;
        if (!cartesGagnantes.isEmpty()) {
            for (i = 0; i < cartesGagnantes.size() - 1; i++) {
                if (cartesGagnantes.get(i) != null) {
                    retour.append(cartesGagnantes.get(i) + " ");
                }
            }
            retour.append(cartesGagnantes.get(i));
        }
        return retour.toString();
    }

    @Override
    public String toString() {
        if (this.joueur == 0) {
            return "Egalité";
        } else {
            return "La main " + joueur + " gagne avec " + victoire.getValToString() + " : " + cartesGagantsToString();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Gagnant) {
            Gagnant gagnantAComparer = (Gagnant) obj;
            return this.joueur == gagnantAComparer.joueur
                    && this.victoire.equals(gagnantAComparer.victoire)
                    && this.cartesGagantsToString().equals(gagnantAComparer.cartesGagantsToString());
        }
        return false;
    }
}
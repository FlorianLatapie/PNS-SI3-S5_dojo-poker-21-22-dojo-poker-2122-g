package com.dojopoker.main;

import java.util.ArrayList;
import java.util.List;

public class Gagnant {
    private int joueur;
    private List<Carte> cartesGagnantes;
    private VictoiresPossibles victoire;

    public Gagnant(int joueur, VictoiresPossibles victoire, Carte... cartesGagnantes) {
        this.joueur = joueur;
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
            for (i = 0; i < cartesGagnantes.size() ; i++) {
                retour.append(cartesGagnantes.get(i) + " ");
            }
        }
        return retour.toString();
    }

    @Override
    public String toString() {
        if (this.joueur == 0) {
            return "Égalité";
        } else if (this.victoire.equals(VictoiresPossibles.COULEUR)) {
            return "La main " + joueur + " gagne avec " + victoire.getValToString() + " : " + cartesGagnantes.get(0).getCouleur();
        } else if (this.victoire.equals(VictoiresPossibles.QUINTE_FLUSH)){
            return "La main " + joueur + " gagne avec " + victoire.getValToString() + " : " + cartesGagantsToString() + cartesGagnantes.get(0).getCouleur();
        } else{
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
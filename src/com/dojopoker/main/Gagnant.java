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

    public enum VictoiresPossibles {
        egalite(0, "Egalite"),
        carte_la_plus_haute(1, "carte la plus haute"),
        paire(2, "une paire"),
        double_paire(3, "double paire"),
        brelan(4, "brelan"),
        suite(5, "suite"),
        couleur(6, "couleur"),
        full(7, "full"),
        carre(8, "carré"),
        quinte_flush(9, "quinte flush");

        private int val;
        private String valToString;

        VictoiresPossibles(int val, String valToString) {
            this.valToString = valToString;
            this.val = val;
        }

    }

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
        for (i = 0; i < cartesGagnantes.size() - 1; i++) {
            if (cartesGagnantes.get(i) != null) {
                retour.append(cartesGagnantes.get(i) + " ");
            }
        }
        retour.append(cartesGagnantes.get(i));
        return retour.toString();
    }

    @Override
    public String toString() {
        if (this.joueur == 0) {
            return "Egalité";
        } else {
            return "La main " + joueur + " gagne avec " + victoire.valToString + " : " + cartesGagantsToString();
        }
    }
}
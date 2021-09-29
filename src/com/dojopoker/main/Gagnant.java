package com.dojopoker.main;

import java.util.List;

public class Gagnant {
    private int joueur;
    private String raisonVictoire;
    private int cartesGagnantes;

    public Gagnant(int joueur, String raisonVictoire, int cartesGagnantes){
        this.joueur = joueur;
        this.raisonVictoire = raisonVictoire;
        this.cartesGagnantes = cartesGagnantes;
    }

    @Override
    public String toString(){
        if (this.joueur == 0){
            return "Egalité";
        } else {
            return "La main "+ joueur +" gagne avec "+raisonVictoire+" : " + cartesGagnantes;
        }
    }
}
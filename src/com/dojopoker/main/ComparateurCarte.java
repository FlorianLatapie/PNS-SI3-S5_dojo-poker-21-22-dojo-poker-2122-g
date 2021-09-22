package com.dojopoker.main;

public class ComparateurCarte {

    public static String compare(Carte carteA, Carte carteB){

        // carte la plus haute
        if (carteA.valeur > carteB.valeur){
            return "A gagne";
        }
        else {
            return "B gagne";
        }
    }
}

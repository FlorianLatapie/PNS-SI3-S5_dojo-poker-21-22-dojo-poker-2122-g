package com.dojopoker.main;

public class ComparateurCarte {

    public static String compare(Main mainA, Main mainB){

        // carte la plus haute
        if (mainA.cartes.get(0).valeur > mainB.cartes.get(0).valeur){
            return "A gagne par carte la plus haute";
        }
        else {
            return "B gagne par carte la plus haute";
        }
    }
}

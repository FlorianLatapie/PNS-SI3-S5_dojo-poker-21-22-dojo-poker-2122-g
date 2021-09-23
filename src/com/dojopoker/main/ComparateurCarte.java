package com.dojopoker.main;

public class ComparateurCarte {

    public static String compare(Main mainA, Main mainB){

        // carte la plus haute
        if (mainA.cartes.get(0).valeur > mainB.cartes.get(0).valeur){
            return "A gagne par carte la plus haute";
        }
        else if(mainA.cartes.get(0).valeur == mainB.cartes.get(0).valeur){
            return "Cartes égales";
        }
        else {
            return "B gagne par carte la plus haute";
        }
    }

    public static String compareTotalDesMains(Main main1, Main main2){
        String res;
        int resMain1 = 0, resMain2 = 0;

        for(int i=0; i<main1.getLenghtMain(); i++){
            if (main1.cartes.get(i).valeur > main2.cartes.get(i).valeur){
                resMain1++;
            }
            else if (main1.cartes.get(i).valeur < main2.cartes.get(i).valeur){
                resMain2++;
            }
        }

        if(resMain1 == resMain2){
            res = "Egalité !";
        }
        else if (resMain1 > resMain2){
            res = "Main 1 gagne !";
        } else {
            res = "Main 2 gagne !";
        }

        return res;
    }
}

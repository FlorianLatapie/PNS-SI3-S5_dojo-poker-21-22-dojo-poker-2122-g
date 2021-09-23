package com.dojopoker.main;

public class ComparateurCarte {

    public static String compare(Main main1, Main main2){

        return compareTotalDesMains(main1, main2);
    }

    private static String compareTotalDesMains(Main main1, Main main2){
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
            return "Egalité !";
        }
        else if (resMain1 > resMain2){
            return "Main 1 gagne !";
        } else {
            return "Main 2 gagne !";
        }
    }
}

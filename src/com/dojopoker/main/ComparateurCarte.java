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

    public static String compareTotalDesMains(Main main1, Main main2){
        String res;

        if((contientPaire(main1) || contientPaire(main2))){
            res=comparePaires(main1,main2);
        }

        else{
            res=sommeValeurs(main1,main2);
        }



        return res;
    }

    public static String sommeValeurs(Main main1, Main main2){
        int resMain1 = 0, resMain2 = 0;
        String res;

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

    public static String comparePaires(Main main1, Main main2){
        String res;


        if(contientPaire(main1) && contientPaire(main2)){
            if(valeurPaire(main1)>valeurPaire(main2)){
                res="Main 1 gagne !";
            }
            else if(valeurPaire(main1)<valeurPaire(main2)){
                res="Main 2 gagne !";
            }
            else{
                res="Egalite !";
            }
        }

        else if(contientPaire(main1)){
            res="Main 1 gagne !";
        }
        else{
            res="Main 2 gagne !";
        }
        return res;
    }

    public static boolean contientPaire(Main main1){
        boolean res = false;

        for(int i = 0; i<main1.getLenghtMain(); i++){
            for(int j = 0; j< main1.getLenghtMain(); j++){
                if(i!=j){
                    if(main1.cartes.get(i).valeur==main1.cartes.get(j).valeur) {
                        res = true;
                    }
                }
            }
        }

        return res;
    }

    public static int valeurPaire(Main main){
        int res = 0;

        for(int i = 0; i<main.getLenghtMain(); i++){
            for(int j = 0; j< main.getLenghtMain(); j++){
                if(i!=j){
                    if(main.cartes.get(i).valeur==main.cartes.get(j).valeur) {
                        res = main.cartes.get(i).valeur;
                    }
                }
            }
        }

        return res;
    }
}

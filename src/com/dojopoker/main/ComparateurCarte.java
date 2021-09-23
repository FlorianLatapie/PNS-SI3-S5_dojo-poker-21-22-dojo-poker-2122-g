package com.dojopoker.main;

public class ComparateurCarte {

    public static String compare(Main main1, Main main2){
        String res;

        if((contientPaire(main1) || contientPaire(main2))){
            res=comparePaires(main1,main2);
        } else{
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
            } else if (main1.cartes.get(i).valeur < main2.cartes.get(i).valeur){
                resMain2++;
            }
        }

        if(resMain1 == resMain2) {
            res = "Egalité !";
        } else if (resMain1 > resMain2){
            res = "Main 1 gagne !";
        } else {
            res = "Main 2 gagne !";
        }

        return res;
    }

    public static String comparePaires(Main main1, Main main2){
        if(contientPaire(main1) && contientPaire(main2)){
            if(valeurPaire(main1)>valeurPaire(main2)){
                return "Main 1 gagne ! grâce à paire vs paire : "+ valeurPaire(main1);
            }
            else if(valeurPaire(main1)<valeurPaire(main2)){
                return "Main 2 gagne ! grâce à paire vs paire : "+ valeurPaire(main2);
            }
            else{
                return "Egalite ! de paire";
            }
        }else if(contientPaire(main1)){
            return "Main 1 gagne ! grâce à paire : "+ valeurPaire(main1);
        }else{
            return "Main 2 gagne ! grâce à paire : "+ valeurPaire(main1);
        }
    }

    public static boolean contientPaire(Main main1){
        for(int i = 0; i<main1.getLenghtMain(); i++){
            for(int j = 0; j< main1.getLenghtMain(); j++){
                if(i!=j){
                    if(main1.cartes.get(i).valeur==main1.cartes.get(j).valeur) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int valeurPaire(Main main){
        for(int i = 0; i<main.getLenghtMain(); i++){
            for(int j = 0; j< main.getLenghtMain(); j++){
                if(i!=j){
                    if(main.cartes.get(i).valeur==main.cartes.get(j).valeur) {
                        return main.cartes.get(i).valeur;
                    }
                }
            }
        }
        return 0;
    }
}

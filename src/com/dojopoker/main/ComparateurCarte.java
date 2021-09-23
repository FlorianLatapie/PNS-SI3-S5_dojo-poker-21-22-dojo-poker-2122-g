package com.dojopoker.main;

public class ComparateurCarte {
    private ComparateurCarte(){}

    public static String compare(Main main1, Main main2) {
        String res;

        if((contientPaire(main1) || contientPaire(main2))){
            res=comparePaires(main1,main2);
        } else{
            res= compareCarteLaPlusHaute(main1,main2);
        }
        return res;
    }

    public static String compareCarteLaPlusHaute(Main main1, Main main2){
        int resMain1 = 0, resMain2 = 0;

        for(int i = 0; i<main1.getCartesSize() ; i++){
            if (main1.cartes.get(i).valeur > main2.cartes.get(i).valeur){
                resMain1++;
            } else if (main1.cartes.get(i).valeur < main2.cartes.get(i).valeur){
                resMain2++;
            }
        }

        if(resMain1 == resMain2) {
            return "Egalité !";
        } else if (resMain1 > resMain2){
            return "Main 1 gagne ! carte la plus haute : " ;
        } else {
            return "Main 2 gagne ! carte la plus haute : " ;
        }
    }

    public static String comparePaires(Main main1, Main main2) {
        if(contientPaire(main1) && contientPaire(main2)){
            if(valeurPaire(main1)>valeurPaire(main2)){
                return "Main 1 gagne ! grâce à paire vs paire : "+ valeurPaire(main1);
            }
            else if(valeurPaire(main1)<valeurPaire(main2)){
                return "Main 2 gagne ! grâce à paire vs paire : "+ valeurPaire(main2);
            }
            else{
                return compareCarteLaPlusHaute(main1, main2);
            }
        }else if(contientPaire(main1)){
            return "Main 1 gagne ! grâce à paire : "+ valeurPaire(main1);
        }else{
            return "Main 2 gagne ! grâce à paire : "+ valeurPaire(main1);
        }
    }

    public static boolean contientPaire(Main main1){
        for(int i = 0; i<main1.getCartesSize(); i++){
            for(int j = 0; j< main1.getCartesSize(); j++){
                if(i!=j && main1.cartes.get(i).valeur==main1.cartes.get(j).valeur) {
                        return true;
                    }
                }
            }
        return false;
    }

    public static int valeurPaire(Main main) {
        for(int i = 0; i<main.getCartesSize(); i++){
            for(int j = 0; j< main.getCartesSize(); j++){
                if(i!=j && main.cartes.get(i).valeur==main.cartes.get(j).valeur) {
                        return main.cartes.get(i).valeur;
                    }
                }
            }
        return -1;
    }
}

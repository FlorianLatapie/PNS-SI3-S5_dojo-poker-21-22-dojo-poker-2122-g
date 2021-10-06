package com.dojopoker.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComparateurCarte {
    private ComparateurCarte() {}

    static int contientPaire(Main main) {
        for (int i = 0; i < main.getCartesSize(); i++) {
            for (int j = 0; j < main.getCartesSize(); j++) {
                if (i != j && main.getCartes().get(i).getValeur() == main.getCartes().get(j).getValeur()) {
                    return main.getCartes().get(i).getValeur();
                }
            }
        }
        return 0;
    }

    static int contientBrelan(Main main) {
        for(int i = 0; i < main.getCartesSize(); i++) {
            for(int j = 0; j < main.getCartesSize(); j++) {
                for(int h = 0; h < main.getCartesSize(); h++) {
                    if((i != j) && (j != h) && (i != h) && (main.getCartes().get(i).getValeur()
                       == main.getCartes().get(j).getValeur()) && (main.getCartes().get(j).getValeur()
                       == main.getCartes().get(h).getValeur())) {
                        return main.getCartes().get(i).getValeur();
                    }
                }
            }
        }
        return 0;
    }

    static int[] contientDoublePaires(Main main){

        int paire1, paire2, carteRestante;
        paire1 = contientPaire(main);

        for (int i = 0; i < main.getCartesSize(); i++) {
            for (int j = 0; j < main.getCartesSize(); j++) {
                if (i != j && main.getCartes().get(i).getValeur() == main.getCartes().get(j).getValeur() && main.getCartes().get(j).getValeur() != paire1) {

                    paire2 = main.getCartes().get(j).getValeur();

                    for(int k = 0; k < main.getCartesSize(); k++) {
                        if(main.getCartes().get(k).getValeur() != paire1 && main.getCartes().get(k).getValeur() != paire2){

                            carteRestante = main.getCartes().get(k).getValeur();

                            if(paire1 > paire2){ //classe la paire la plus forte en premier
                                return new int[] {paire1, paire2, carteRestante};
                            } else {
                                return new int[]{paire2, paire1, carteRestante};
                            }
                        }
                    }
                }
            }
        }

        return new int[] {0, 0,0};
    }

    static int contientCarre(Main main) {
        return contientPlusieurs(main, 4);
    }

    static int contientPlusieurs(Main main, int occurencesATrouver) {
        Map<Integer, Integer> carteOccurences = new HashMap<>();

        for (int i = 0; i < main.getCartesSize(); i++) {
            if (carteOccurences.containsKey(main.getCartes().get(i).getValeur())) {
                // la carte existe, occurence ++
                carteOccurences.replace(main.getCartes().get(i).getValeur(), carteOccurences.get(main.getCartes().get(i).getValeur()) + 1);
            } else {
                // la carte n'est pas encore repertoriée, occurence = 1
                carteOccurences.put(main.getCartes().get(i).getValeur(), 1);
            }
        }

        for (Integer i : carteOccurences.keySet()) {
            if (carteOccurences.get(i) == occurencesATrouver) {
                return i;
            }
        }
        return 0;
    }

    static int[] contientFull(Main main){
        if(contientBrelan(main)!=0 && contientPaire(main)!=0 && contientBrelan(main)!=contientPaire(main)){
            return new int[]{contientBrelan(main),contientPaire(main)};
        }
        else{
            return new int[]{0,0};
        }
    }


    static void supprimerCartes(Main main, int valeurCarte, int nbASuppr) {
        for (int j = 0; j < nbASuppr; j++) {
            for (int i = 0; i < main.getCartesSize(); i++) {
                if (main.getCartes().get(i).getValeur() == valeurCarte) {
                    main.getCartes().remove(i);
                    break;
                }
            }
        }
    }


}

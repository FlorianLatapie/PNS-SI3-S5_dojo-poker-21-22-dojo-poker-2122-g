package com.dojopoker.main;

import java.util.*;

/*public class ComparateurCarte {
    private ComparateurCarte() {
    }

    static int contientPaire(Main main) {
        return contientPlusieurs(main, 2);
    }

    static int contientBrelan(Main main) { return contientPlusieurs(main, 3); }

    static Carte[] contientSuite(Main main) {
        int compteur = 1;
        List<Integer> liste = main.valTri();

        for(int j = 0; j < main.getCartesSize()-1; j++) {
            if (liste.get(j) == (liste.get(j+1)-1)) {
                compteur++;
            }
        }

        Carte[] tableauRetour = new Carte[liste.size()];
        for(int i=0; i < liste.size(); i++){
            tableauRetour[i]  = new Carte(liste.get(i));
        }

        if(compteur == 5) {
            return tableauRetour;
        }
        return new Carte[] { new Carte(0) };

    }

    static int[] contientDoublePaires(Main main) {

        int paire1, paire2, carteRestante;
        paire1 = contientPaire(main);

        for (int i = 0; i < main.getCartesSize(); i++) {
            for (int j = 0; j < main.getCartesSize(); j++) {
                if (i != j && main.getVal(i) == main.getVal(j) && main.getVal(j) != paire1) {

                    paire2 = main.getVal(j);

                    for (int k = 0; k < main.getCartesSize(); k++) {
                        if (main.getVal(k) != paire1 && main.getVal(k) != paire2) {

                            carteRestante = main.getVal(k);

                            return new int[]{paire2, paire1, carteRestante};
                        }
                    }
                }
            }
        }

        return new int[]{0, 0, 0};
    }

    static int contientCarre(Main main) {
        return contientPlusieurs(main, 4);
    }

    static int contientPlusieurs(Main main, int occurencesATrouver) {
        Map<Integer, Integer> carteOccurences = new HashMap<>();

        for (int i = 0; i < main.getCartesSize(); i++) {
            if (carteOccurences.containsKey(main.getVal(i))) {
                // la carte existe, occurence ++
                carteOccurences.replace(main.getVal(i), carteOccurences.get(main.getVal(i)) + 1);
            } else {
                // la carte n'est pas encore repertoriée, occurence = 1
                carteOccurences.put(main.getVal(i), 1);
            }
        }

        for (Integer i : carteOccurences.keySet()) {
            if (carteOccurences.get(i) == occurencesATrouver) {
                return i;
            }
        }
        return 0;
    }

    static Carte[] contientFull(Main main) {
        if ((contientBrelan(main) != 0 && contientPaire(main) != 0)) {
            return new Carte[]{new Carte(contientBrelan(main)), new Carte(contientPaire(main))};
        } else {
            return new Carte[]{new Carte(0)};
        }
    }

    static String contientCouleur(Main main){
        if(main.getCartesSize()!=0) {
            String couleur = main.getCouleurMain(0);

            if (!couleur.equals("Pas de couleur")) {
                for (Carte el : main.getCartes()) {
                    if (!el.getCouleur().equals(couleur)) {
                        return null;
                    }
                }
            } else {
                return null;
            }

            return couleur;
        }
        else{
            return null;
        }
    }


    static void supprimerCartes(Main main, int valeurCarte, int nbASuppr) {
        for (int j = 0; j < nbASuppr; j++) {
            for (int i = 0; i < main.getCartesSize(); i++) {
                if (main.getVal(i) == valeurCarte) {
                    main.getCartes().remove(i);
                    break;
                }
            }
        }
    }
}*/

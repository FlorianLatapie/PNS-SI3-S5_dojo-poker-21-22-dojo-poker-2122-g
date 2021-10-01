package com.dojopoker.main;

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

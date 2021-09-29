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

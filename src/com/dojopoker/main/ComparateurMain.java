package com.dojopoker.main;

public class ComparateurMain {
    private static ComparateurCarte cartes;

    public static Gagnant compare(Main main1, Main main2) {
        if ((cartes.contientPaire(main1)!=0 || cartes.contientPaire(main2)!=0)) {
            return comparePaires(main1, main2);
        } else {
            return compareCarteLaPlusHaute(main1, main2);
        }
    }

    private static Gagnant compareCarteLaPlusHaute(Main main1, Main main2) {
        int resMain1 = 0, resMain2 = 0;
        Carte lePlusHaut = new Carte(-1);

        for (int i = 0; i < main1.getCartesSize(); i++) {
            if (main1.getCartes().get(i).getValeur() > main2.getCartes().get(i).getValeur()) {
                resMain1++;
                if (main1.getCartes().get(i).getValeur() > lePlusHaut.getValeur()) {
                    lePlusHaut = main1.getCartes().get(i);
                }
            } else if (main1.getCartes().get(i).getValeur() < main2.getCartes().get(i).getValeur()) {
                resMain2++;
                if (main2.getCartes().get(i).getValeur() > lePlusHaut.getValeur()) {
                    lePlusHaut = main2.getCartes().get(i);
                }
            }
        }

        if (resMain1 == resMain2) {
            return new Gagnant(0, Gagnant.VictoiresPossibles.egalite, null);
        } else if (resMain1 > resMain2) {
            return new Gagnant(1, Gagnant.VictoiresPossibles.carte_la_plus_haute, lePlusHaut.getValeur());
        } else {
            return new Gagnant(2, Gagnant.VictoiresPossibles.carte_la_plus_haute, lePlusHaut.getValeur());
        }
    }

    private static Gagnant comparePaires(Main main1, Main main2) {
        if (cartes.contientPaire(main1)!=0 && cartes.contientPaire(main2)!=0) {
            if (cartes.contientPaire(main1) > cartes.contientPaire(main2)) {
                return new Gagnant(1, Gagnant.VictoiresPossibles.paire, cartes.contientPaire(main1));
            } else if (cartes.contientPaire(main1) < cartes.contientPaire(main2)) {
                return new Gagnant(2, Gagnant.VictoiresPossibles.paire, cartes.contientPaire(main2));
            } else {
                cartes.supprimerCartes(main1, cartes.contientPaire(main1), 2);
                cartes.supprimerCartes(main2, cartes.contientPaire(main2), 2);

                return compareCarteLaPlusHaute(main1, main2);
            }
        } else if (cartes.contientPaire(main1)!=0) {
            return new Gagnant(1, Gagnant.VictoiresPossibles.paire, cartes.contientPaire(main1));
        } else {
            return new Gagnant(2, Gagnant.VictoiresPossibles.paire, cartes.contientPaire(main2));
        }
    }


}

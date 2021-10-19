package com.dojopoker.main;

import static com.dojopoker.main.VictoiresPossibles.*;

public class ComparateurMain {

    public Gagnant compare(Main main1, Main main2) {
        int[] paireMain1 = main1.contientDoublePaires();
        int[] paireMain2 = main2.contientDoublePaires();
        Carte[] fullMain1 = main1.contientFull();
        Carte[] fullMain2 = main2.contientFull();
        Carte[] suiteMain1 = main1.contientSuite();
        Carte[] suiteMain2 = main2.contientSuite();

        if (main1.contientQuinteFlush().length == 5 || main2.contientQuinteFlush().length == 5) {
            return compareQuinteFlush(main1, main2);
        }
        else if (main1.contientCarre() != 0 || main2.contientCarre() != 0) {
            return compareCarre(main1, main2);
        } else if (fullMain1[0].getValeur() != 0 || fullMain2[0].getValeur() != 0) {
            return compareFull(main1, main2);
        } else if (main1.contientCouleur() != null || main2.contientCouleur() != null) {
            return compareCouleur(main1, main2);
        } else if (suiteMain1[0].getValeur() != 0 || suiteMain2[0].getValeur() != 0) {
            return compareSuite(main1, main2);
        } else if (main1.contientBrelan() != 0 || main2.contientBrelan() != 0) {
            return compareBrelans(main1, main2);
        } else if (paireMain1[0] != 0 && paireMain1[1] != 0 || paireMain2[0] != 0 && paireMain2[1] != 0) {
            return compareDoublePaires(main1, main2);
        } else if ((main1.contientPaire() != 0 || main2.contientPaire() != 0)) {
            return comparePaires(main1, main2);
        } else {
            return compareCarteLaPlusHaute(main1, main2);
        }
    }

    private Gagnant compareCarteLaPlusHaute(Main main1, Main main2) {
        int lePlusHautM1 = -1;
        int lePlusHautM2 = -1;
        for (int i = 0; i < main1.getCartesSize(); i++) {
            if (main1.getCartes().get(i).getValeur() > lePlusHautM1){
                lePlusHautM1 = main1.getCartes().get(i).getValeur();
            }
        }
        for (int i = 0; i < main2.getCartesSize(); i++) {
            if (main2.getCartes().get(i).getValeur() > lePlusHautM2){
                lePlusHautM2 = main2.getCartes().get(i).getValeur();
            }
        }
        if (lePlusHautM1 == lePlusHautM2) {
            return new Gagnant(0, EGALITE, null);
        } else if (lePlusHautM1 > lePlusHautM2) {
            return new Gagnant(1, CARTE_LA_PLUS_HAUTE, new Carte(lePlusHautM1));
        } else {
            return new Gagnant(2, CARTE_LA_PLUS_HAUTE, new Carte(lePlusHautM2));
        }
    }

    private Gagnant comparePaires(Main main1, Main main2) {
        if (main1.contientPaire() != 0 && main2.contientPaire() != 0) {
            if (main1.contientPaire() > main2.contientPaire()) {
                return new Gagnant(1, PAIRE, new Carte(main1.contientPaire()));
            } else if (main1.contientPaire() < main2.contientPaire()) {
                return new Gagnant(2, PAIRE, new Carte(main2.contientPaire()));
            } else {
                main1.supprimerCartes(main1.contientPaire(), 2);
                main2.supprimerCartes(main2.contientPaire(), 2);

                return compare(main1, main2);
            }
        } else if (main1.contientPaire() != 0) {
            return new Gagnant(1, PAIRE, new Carte(main1.contientPaire()));
        } else {
            return new Gagnant(2, PAIRE, new Carte(main2.contientPaire()));
        }
    }

    private Gagnant compareBrelans(Main main1, Main main2) {
        if (main1.contientBrelan() != 0 && main2.contientBrelan() != 0) {
            if (main1.contientBrelan() > main2.contientBrelan()) {
                return new Gagnant(1, BRELAN, new Carte(main1.contientBrelan()));
            } else if (main1.contientBrelan() < main2.contientBrelan()) {
                return new Gagnant(2, BRELAN, new Carte(main2.contientBrelan()));
            } else {
                main1.supprimerCartes(main1.contientBrelan(), 3);
                main2.supprimerCartes(main2.contientBrelan(), 3);

                return compare(main1, main2);
            }
        } else if (main1.contientBrelan() != 0) {
            return new Gagnant(1, BRELAN, new Carte(main1.contientBrelan()));
        } else {
            return new Gagnant(2, BRELAN, new Carte(main2.contientBrelan()));
        }

    }

    private Gagnant compareSuite(Main main1, Main main2) {
        Carte[] suiteMain1 = main1.contientSuite();
        Carte[] suiteMain2 = main2.contientSuite();
        if (suiteMain1[0].getValeur() != 0 && suiteMain2[0].getValeur() != 0) {
            if (suiteMain1[4].getValeur() > suiteMain2[4].getValeur()) {
                return new Gagnant(1, SUITE, suiteMain1);
            } else if (suiteMain1[4].getValeur() < suiteMain2[4].getValeur()) {
                return new Gagnant(2, SUITE, suiteMain2);
            } else {
                //return new Gagnant(0, egalite);
                for (int i = 0; i < suiteMain1.length; i++) {
                    main1.supprimerCartes(suiteMain1[i].getValeur(), 1);
                }
                for (int i = 0; i < suiteMain2.length; i++) {
                    main2.supprimerCartes(suiteMain1[i].getValeur(), 1);
                }
                return compare(main1, main2);
            }
        } else if (suiteMain1[0].getValeur() != 0) {
            return new Gagnant(1, SUITE, suiteMain1);
        } else {
            return new Gagnant(2, SUITE, suiteMain2);
        }
    }

    private Gagnant compareQuinteFlush(Main main1, Main main2) {
        Carte[] quinteFlushMain1 = main1.contientQuinteFlush();
        Carte[] quinteFlushMain2 = main2.contientQuinteFlush();

        if (quinteFlushMain1[0].getValeur() != 0 && quinteFlushMain2[0].getValeur() != 0
            && main1.contientCouleur() != null && main2.contientCouleur() != null) {

            if (quinteFlushMain1[4].getValeur() > quinteFlushMain2[4].getValeur()) {
                return new Gagnant(1, QUINTE_FLUSH, quinteFlushMain1);
            } else if (quinteFlushMain1[4].getValeur() < quinteFlushMain2[4].getValeur()) {
                return new Gagnant(2, QUINTE_FLUSH, quinteFlushMain2);
            } else {
                for (int i = 0; i < quinteFlushMain1.length; i++) {
                    main1.supprimerCartes(quinteFlushMain1[i].getValeur(), 1);
                }
                for (int i = 0; i < quinteFlushMain2.length; i++) {
                    main2.supprimerCartes(quinteFlushMain1[i].getValeur(), 1);
                }
                return compare(main1, main2);
            }
        } else if (quinteFlushMain1[0].getValeur() != 0) {
            return new Gagnant(1, QUINTE_FLUSH, quinteFlushMain1);
        } else
            return new Gagnant(2, QUINTE_FLUSH, quinteFlushMain2);
    }

    private Gagnant compareDoublePaires(Main main1, Main main2) {
        int[] paireMain1 = main1.contientDoublePaires();
        int[] paireMain2 = main2.contientDoublePaires();
        if (paireMain1[0] != 0 && paireMain1[1] != 0 && paireMain2[0] != 0 && paireMain2[1] != 0) {
            if (paireMain1[0] > paireMain2[0]) {
                return new Gagnant(1, DOUBLE_PAIRE, new Carte[]{new Carte(paireMain1[0]), new Carte(paireMain1[1])});
            } else if (paireMain1[0] < paireMain2[0]) {
                return new Gagnant(2, DOUBLE_PAIRE, new Carte[]{new Carte(paireMain2[0]), new Carte(paireMain2[1])});
            } else {
                if (paireMain1[1] > paireMain2[1]) {
                    return new Gagnant(1, DOUBLE_PAIRE, new Carte[]{new Carte(paireMain1[0]), new Carte(paireMain1[1])});
                } else if (paireMain1[1] < paireMain2[1]) {
                    return new Gagnant(2, DOUBLE_PAIRE, new Carte[]{new Carte(paireMain2[0]), new Carte(paireMain2[1])});
                } else {
                    main1.supprimerCartes(paireMain1[0], 2);
                    main1.supprimerCartes(paireMain1[1], 2);
                    main2.supprimerCartes(paireMain2[0], 2);
                    main2.supprimerCartes(paireMain2[1], 2);
                    return compare(main1, main2);
                }
            }
        } else if (paireMain1[0] != 0 && paireMain1[1] != 0 && paireMain2[0] == 0 && paireMain2[1] == 0) {
            return new Gagnant(1, DOUBLE_PAIRE, new Carte[]{new Carte(paireMain1[0]), new Carte(paireMain1[1])});
        } else {
            return new Gagnant(2, DOUBLE_PAIRE, new Carte[]{new Carte(paireMain2[0]), new Carte(paireMain2[1])});
        }
    }

    private Gagnant compareCarre(Main main1, Main main2) {
        if (main1.contientCarre() != 0 && main2.contientCarre() != 0) {
            if (main1.contientCarre() > main2.contientCarre()) {
                return new Gagnant(1, CARRE, new Carte(main1.contientCarre()));
            } else if (main1.contientCarre() < main2.contientCarre()) {
                return new Gagnant(2, CARRE, new Carte(main2.contientCarre()));
            } else {
                main1.supprimerCartes(main1.contientCarre(), 4);
                main2.supprimerCartes(main2.contientCarre(), 4);

                return compare(main1, main2);
            }
        } else if (main1.contientCarre() != 0) {
            return new Gagnant(1, CARRE, new Carte(main1.contientCarre()));
        } else {
            return new Gagnant(2, CARRE, new Carte(main2.contientCarre()));
        }

    }

    private Gagnant compareFull(Main main1, Main main2) {
        Carte[] fullMain1 = main1.contientFull();
        Carte[] fullMain2 = main2.contientFull();

        if (fullMain1[0].getValeur() != 0 && fullMain2[0].getValeur() != 0) {
            if (fullMain1[0].getValeur() > fullMain2[0].getValeur()) {
                return new Gagnant(1, FULL, fullMain1);
            } else if (fullMain2[0].getValeur() > fullMain1[0].getValeur()) {
                return new Gagnant(2, FULL, fullMain2);
            } else {
                if (fullMain1[1].getValeur() > fullMain2[1].getValeur()) {
                    return new Gagnant(1, FULL, fullMain1);
                } else if (fullMain2[1].getValeur() > fullMain1[1].getValeur()) {
                    return new Gagnant(2, FULL, fullMain2);
                } else {
                    //ATTENTION! CAS D'EGALITE NORMALEMENT IMPOSSIBLE
                    main1.supprimerCartes(fullMain1[0].getValeur(), 3);
                    main1.supprimerCartes(fullMain1[1].getValeur(), 2);
                    main2.supprimerCartes(fullMain2[0].getValeur(), 3);
                    main2.supprimerCartes(fullMain2[1].getValeur(), 2);
                    return compare(main1, main2);
                }
            }
        } else if (fullMain1[0].getValeur() != 0 && fullMain2[0].getValeur() == 0) {
            return new Gagnant(1, FULL, fullMain1);
        } else {
            return new Gagnant(2, FULL, fullMain2);
        }
    }

    private Gagnant compareCouleur(Main main1, Main main2) {
        if (main1.contientCouleur() != null && main2.contientCouleur() != null) {
            return compareCarteLaPlusHaute(main1, main2);
        } else if (main1.contientCouleur() != null && main2.contientCouleur() == null) {
            return new Gagnant(1, COULEUR, new Carte(2, main1.contientCouleur()));
        } else {
            return new Gagnant(2, COULEUR, new Carte(2, main2.contientCouleur()));
        }
    }
}

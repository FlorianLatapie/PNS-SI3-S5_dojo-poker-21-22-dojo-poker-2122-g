package com.dojopoker.main;

import static com.dojopoker.main.VictoiresPossibles.*;

public class ComparateurMain {
    private static ComparateurCarte cartes;

    public static Gagnant compare(Main main1, Main main2) {
        int[] paireMain1 = cartes.contientDoublePaires(main1);
        int[] paireMain2 = cartes.contientDoublePaires(main2);
        Carte[] fullMain1 = cartes.contientFull(main1);
        Carte[] fullMain2 = cartes.contientFull(main2);
        Carte[] suiteMain1 = cartes.contientSuite(main1);
        Carte[] suiteMain2 = cartes.contientSuite(main2);

        /*if (cartes.contientQinteFlush(main1) != 0 || cartes.contientQinteFlush(main2) != 0) {
            return compareQinteFlush(main1, main2);
        }
        else */
        if (cartes.contientCarre(main1) != 0 || cartes.contientCarre(main2) != 0) {
            return compareCarre(main1, main2);
        } else if (fullMain1[0].getValeur() != 0 || fullMain2[0].getValeur() != 0) {
            return compareFull(main1, main2);
        }/*
        else if (cartes.contientCouleur(main1) != 0 || cartes.contientCouleur(main2) != 0) {
            return compareCouleur(main1, main2);
        }*/ else if (suiteMain1[0].getValeur() != 0 || suiteMain2[0].getValeur() != 0) {
            return compareSuite(main1, main2);
        } else if (cartes.contientBrelan(main1) != 0 || cartes.contientBrelan(main2) != 0) {
            return compareBrelans(main1, main2);
        } else if (paireMain1[0] != 0 && paireMain1[1] != 0 || paireMain2[0] != 0 && paireMain2[1] != 0) {
            return compareDoublePaires(main1, main2);
        } else if ((cartes.contientPaire(main1) != 0 || cartes.contientPaire(main2) != 0)) {
            return comparePaires(main1, main2);
        } else {
            return compareCarteLaPlusHaute(main1, main2);
        }
    }

    private static Gagnant compareCarteLaPlusHaute(Main main1, Main main2) {
        int resMain1 = 0, resMain2 = 0;
        Carte lePlusHaut = new Carte(-1);

        for (int i = 0; i < main1.getCartesSize(); i++) {
            if (main1.getVal(i) > main2.getVal(i)) {
                resMain1++;
                if (main1.getVal(i) > lePlusHaut.getValeur()) {
                    lePlusHaut = main1.getCartes().get(i);
                }
            } else if (main1.getVal(i) < main2.getVal(i)) {
                resMain2++;
                if (main2.getVal(i) > lePlusHaut.getValeur()) {
                    lePlusHaut = main2.getCartes().get(i);
                }
            }
        }

        if (resMain1 == resMain2) {
            return new Gagnant(0, EGALITE);
        } else if (resMain1 > resMain2) {
            return new Gagnant(1, CARTE_LA_PLUS_HAUTE, new Carte(lePlusHaut.getValeur()));
        } else {
            return new Gagnant(2, CARTE_LA_PLUS_HAUTE, new Carte(lePlusHaut.getValeur()));
        }
    }

    private static Gagnant comparePaires(Main main1, Main main2) {
        if (cartes.contientPaire(main1) != 0 && cartes.contientPaire(main2) != 0) {
            if (cartes.contientPaire(main1) > cartes.contientPaire(main2)) {
                return new Gagnant(1, PAIRE, new Carte(cartes.contientPaire(main1)));
            } else if (cartes.contientPaire(main1) < cartes.contientPaire(main2)) {
                return new Gagnant(2, PAIRE, new Carte(cartes.contientPaire(main2)));
            } else {
                cartes.supprimerCartes(main1, cartes.contientPaire(main1), 2);
                cartes.supprimerCartes(main2, cartes.contientPaire(main2), 2);

                return ComparateurMain.compare(main1, main2);
            }
        } else if (cartes.contientPaire(main1)!=0) {
            return new Gagnant(1, PAIRE, new Carte(cartes.contientPaire(main1)));
        } else {
            return new Gagnant(2, PAIRE, new Carte(cartes.contientPaire(main2)));
        }
    }

    private static Gagnant compareBrelans(Main main1, Main main2) {
        if (cartes.contientBrelan(main1) != 0 && cartes.contientBrelan(main2) != 0) {
            if (cartes.contientBrelan(main1) > cartes.contientBrelan(main2)) {
                return new Gagnant(1, BRELAN, new Carte(cartes.contientBrelan(main1)));
            } else if (cartes.contientBrelan(main1) < cartes.contientBrelan(main2)) {
                return new Gagnant(2, BRELAN, new Carte(cartes.contientBrelan(main2)));
            } else {
                cartes.supprimerCartes(main1, cartes.contientBrelan(main1), 3);
                cartes.supprimerCartes(main2, cartes.contientBrelan(main2), 3);

                return ComparateurMain.compare(main1, main2);
            }
        } else if (cartes.contientBrelan(main1) != 0) {
            return new Gagnant(1, BRELAN, new Carte(cartes.contientBrelan(main1)));
        } else {
            return new Gagnant(2, BRELAN, new Carte(cartes.contientBrelan(main2)));
        }

    }

    private static Gagnant compareSuite(Main main1, Main main2) {
        Carte[] suiteMain1 = cartes.contientSuite(main1);
        Carte[] suiteMain2 = cartes.contientSuite(main2);
        if (suiteMain1[0].getValeur() != 0 && suiteMain2[0].getValeur() != 0) {
            if (suiteMain1[4].getValeur() > suiteMain2[4].getValeur()) {
                return new Gagnant(1, SUITE, suiteMain1);
            } else if (suiteMain1[4].getValeur() < suiteMain2[4].getValeur()) {
                return new Gagnant(2, SUITE, suiteMain2);
            } else {
                //return new Gagnant(0, egalite);
                for (int i = 0; i < suiteMain1.length; i++) {
                    ComparateurCarte.supprimerCartes(main1, suiteMain1[i].getValeur(), 1);
                }
                for (int i = 0; i < suiteMain2.length; i++) {
                    ComparateurCarte.supprimerCartes(main2, suiteMain1[i].getValeur(), 1);
                }
                return ComparateurMain.compare(main1, main2);
            }
        } else if (suiteMain1[0].getValeur() != 0) {
            return new Gagnant(1, SUITE, suiteMain1);
        } else {
            return new Gagnant(2, SUITE, suiteMain2);
        }
    }

    private static Gagnant compareDoublePaires(Main main1, Main main2) {
        int[] paireMain1 = cartes.contientDoublePaires(main1);
        int[] paireMain2 = cartes.contientDoublePaires(main2);

        if(paireMain1[0] != 0 && paireMain1[1] != 0 && paireMain2[0] != 0 && paireMain2[1] != 0){
            if(paireMain1[0] > paireMain2[0]) {
                return new Gagnant(1, DOUBLE_PAIRE, new Carte[] {new Carte(paireMain1[0]), new Carte(paireMain1[1])});
            } else if (paireMain1[0] < paireMain2[0]) {
                return new Gagnant(2, DOUBLE_PAIRE, new Carte[] {new Carte(paireMain2[0]), new Carte(paireMain2[1])});
            } else {
                if(paireMain1[1] > paireMain2[1]){
                    return new Gagnant(1, DOUBLE_PAIRE, new Carte[] {new Carte(paireMain1[0]), new Carte(paireMain1[1])});
                } else if(paireMain1[1] < paireMain2[1]){
                    return new Gagnant(2, DOUBLE_PAIRE, new Carte[] {new Carte(paireMain2[0]), new Carte(paireMain2[1])});
                } else {
                    if(paireMain1[2] > paireMain2[2]){
                        return new Gagnant(1, CARTE_LA_PLUS_HAUTE, new Carte[] {new Carte(paireMain1[2])});
                    } else if(paireMain1[2] < paireMain2[2]){
                        return new Gagnant(2, CARTE_LA_PLUS_HAUTE, new Carte[] {new Carte(paireMain2[2])});
                    } else {
                        //return new Gagnant(0, egalite);
                        for (int i = 0; i < paireMain1.length; i++) {
                            if (i <= 1) {
                                ComparateurCarte.supprimerCartes(main1, paireMain1[i], 1);
                            }
                            ComparateurCarte.supprimerCartes(main1, paireMain1[i], 1);
                        }
                        for (int i = 0; i < paireMain2.length; i++) {
                            if (i <= 1) {
                                ComparateurCarte.supprimerCartes(main1, paireMain2[i], 1);
                            }
                            ComparateurCarte.supprimerCartes(main1, paireMain2[i], 1);
                        }
                        return ComparateurMain.compare(main1, main2);
                    }
                }
            }
        } else if(paireMain1[0] != 0 && paireMain1[1] != 0 && paireMain2[0] == 0 && paireMain2[1] == 0){
            return new Gagnant(1, DOUBLE_PAIRE, new Carte[] {new Carte(paireMain1[0]), new Carte(paireMain1[1])});
        } else {
            return new Gagnant(2, DOUBLE_PAIRE, new Carte[] {new Carte(paireMain2[0]), new Carte(paireMain2[1])});
        }
    }

    private static Gagnant compareCarre(Main main1, Main main2) {
        if (cartes.contientCarre(main1) != 0 && cartes.contientCarre(main2) != 0) {
            if (cartes.contientCarre(main1) > cartes.contientCarre(main2)) {
                return new Gagnant(1, CARRE, new Carte(cartes.contientCarre(main1)));
            } else if (cartes.contientCarre(main1) < cartes.contientCarre(main2)) {
                return new Gagnant(2, CARRE, new Carte(cartes.contientCarre(main2)));
            } else {
                cartes.supprimerCartes(main1, cartes.contientCarre(main1), 4);
                cartes.supprimerCartes(main2, cartes.contientCarre(main2), 4);

                return ComparateurMain.compare(main1, main2);
            }
        } else if (cartes.contientCarre(main1) != 0) {
            return new Gagnant(1, CARRE, new Carte(cartes.contientCarre(main1)));
        } else {
            return new Gagnant(2, CARRE, new Carte(cartes.contientCarre(main2)));
        }

    }

    private static Gagnant compareFull(Main main1, Main main2) {
        Carte[] fullMain1 = cartes.contientFull(main1);
        Carte[] fullMain2 = cartes.contientFull(main2);

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
                    //return new Gagnant(0, egalite);
                    for (int i = 0; i < fullMain1.length; i++) {
                        if (i <= 1) {
                            ComparateurCarte.supprimerCartes(main1, fullMain1[i].getValeur(), 1);
                        }
                        ComparateurCarte.supprimerCartes(main1, fullMain1[i].getValeur(), 1);
                        ComparateurCarte.supprimerCartes(main1, fullMain1[i].getValeur(), 1);
                    }
                    for (int i = 0; i < fullMain2.length; i++) {
                        if (i <= 1) {
                            ComparateurCarte.supprimerCartes(main1, fullMain2[i].getValeur(), 1);
                        }
                        ComparateurCarte.supprimerCartes(main1, fullMain2[i].getValeur(), 1);
                        ComparateurCarte.supprimerCartes(main1, fullMain2[i].getValeur(), 1);
                    }
                    return ComparateurMain.compare(main1, main2);
                }
            }
        } else if (fullMain1[0].getValeur() != 0 && fullMain2[0].getValeur() == 0) {
            return new Gagnant(1, FULL, fullMain1);
        } else {
            return new Gagnant(2, FULL, fullMain2);
        }
    }
}

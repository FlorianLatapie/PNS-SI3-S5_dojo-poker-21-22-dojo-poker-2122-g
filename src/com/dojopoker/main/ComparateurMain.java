package com.dojopoker.main;

import java.util.ArrayList;
import java.util.Collections;

public class ComparateurMain {
    private static ComparateurCarte cartes;

    public static Gagnant compare(Main main1, Main main2) {
        int[] paireMain1 = cartes.contientDoublePaires(main1);
        int[] paireMain2 = cartes.contientDoublePaires(main2);
        int[] fullMain1 = cartes.contientFull(main1);
        int[] fullMain2 = cartes.contientFull(main2);

        /*if (cartes.contientQinteFlush(main1) != 0 || cartes.contientQinteFlush(main2) != 0) {
            return compareQinteFlush(main1, main2);
        }
        else */
        if (cartes.contientCarre(main1) != 0 || cartes.contientCarre(main2) != 0) {
            return compareCarre(main1, main2);
        } else if (fullMain1[0] != 0 || fullMain2[0] != 0) {
            return compareFull(main1, main2);
        }/*
        else if (cartes.contientCouleur(main1) != 0 || cartes.contientCouleur(main2) != 0) {
            return compareCouleur(main1, main2);
        }
        else if (cartes.contientSuite(main1) != 0 || cartes.contientSuite(main2) != 0) {
            return compareSuite(main1, main2);
        }
        */ else if (cartes.contientBrelan(main1) != 0 || cartes.contientBrelan(main2) != 0) {
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
            return new Gagnant(0, VictoiresPossibles.egalite, null);
        } else if (resMain1 > resMain2) {
            return new Gagnant(1, VictoiresPossibles.carte_la_plus_haute, lePlusHaut.getValeur());
        } else {
            return new Gagnant(2, VictoiresPossibles.carte_la_plus_haute, lePlusHaut.getValeur());
        }
    }

    private static Gagnant comparePaires(Main main1, Main main2) {
        if (cartes.contientPaire(main1) != 0 && cartes.contientPaire(main2) != 0) {
            if (cartes.contientPaire(main1) > cartes.contientPaire(main2)) {
                return new Gagnant(1, VictoiresPossibles.paire, cartes.contientPaire(main1));
            } else if (cartes.contientPaire(main1) < cartes.contientPaire(main2)) {
                return new Gagnant(2, VictoiresPossibles.paire, cartes.contientPaire(main2));
            } else {
                cartes.supprimerCartes(main1, cartes.contientPaire(main1), 2);
                cartes.supprimerCartes(main2, cartes.contientPaire(main2), 2);

                return compareCarteLaPlusHaute(main1, main2);
            }
        } else if (cartes.contientPaire(main1) != 0) {
            return new Gagnant(1, VictoiresPossibles.paire, cartes.contientPaire(main1));
        } else {
            return new Gagnant(2, VictoiresPossibles.paire, cartes.contientPaire(main2));
        }
    }

    private static Gagnant compareBrelans(Main main1, Main main2) {
        if (cartes.contientBrelan(main1) != 0 && cartes.contientBrelan(main2) != 0) {
            if (cartes.contientBrelan(main1) > cartes.contientBrelan(main2)) {
                return new Gagnant(1, VictoiresPossibles.brelan, cartes.contientBrelan(main1));
            } else if (cartes.contientBrelan(main1) < cartes.contientBrelan(main2)) {
                return new Gagnant(2, VictoiresPossibles.brelan, cartes.contientBrelan(main2));
            } else {
                cartes.supprimerCartes(main1, cartes.contientBrelan(main1), 3);
                cartes.supprimerCartes(main2, cartes.contientBrelan(main2), 3);

                return compareCarteLaPlusHaute(main1, main2);
            }
        } else if (cartes.contientBrelan(main1) != 0) {
            return new Gagnant(1, VictoiresPossibles.brelan, cartes.contientBrelan(main1));
        } else {
            return new Gagnant(2, VictoiresPossibles.brelan, cartes.contientBrelan(main2));
        }

    }

    private static Gagnant compareDoublePaires(Main main1, Main main2) {
        int[] paireMain1 = cartes.contientDoublePaires(main1);
        int[] paireMain2 = cartes.contientDoublePaires(main2);

        if (paireMain1[0] != 0 && paireMain1[1] != 0 && paireMain2[0] != 0 && paireMain2[1] != 0) {
            if (paireMain1[0] > paireMain2[0]) {
                return new Gagnant(1, VictoiresPossibles.double_paire, new Integer[]{paireMain1[0], paireMain1[1]});
            } else if (paireMain1[0] < paireMain2[0]) {
                return new Gagnant(2, VictoiresPossibles.double_paire, new Integer[]{paireMain2[0], paireMain2[1]});
            } else {
                if (paireMain1[1] > paireMain2[1]) {
                    return new Gagnant(1, VictoiresPossibles.double_paire, new Integer[]{paireMain1[0], paireMain1[1]});
                } else if (paireMain1[1] < paireMain2[1]) {
                    return new Gagnant(2, VictoiresPossibles.double_paire, new Integer[]{paireMain2[0], paireMain2[1]});
                } else {
                    if (paireMain1[2] > paireMain2[2]) {
                        return new Gagnant(1, VictoiresPossibles.carte_la_plus_haute, new Integer[]{paireMain1[2]});
                    } else if (paireMain1[2] < paireMain2[2]) {
                        return new Gagnant(2, VictoiresPossibles.carte_la_plus_haute, new Integer[]{paireMain2[2]});
                    } else {
                        return new Gagnant(0, VictoiresPossibles.egalite, null);
                    }
                }
            }
        } else if (paireMain1[0] != 0 && paireMain1[1] != 0 && paireMain2[0] == 0 && paireMain2[1] == 0) {
            return new Gagnant(1, VictoiresPossibles.double_paire, new Integer[]{paireMain1[0], paireMain1[1]});
        } else {
            return new Gagnant(2, VictoiresPossibles.double_paire, new Integer[]{paireMain2[0], paireMain2[1]});
        }
    }

    private static Gagnant compareCarre(Main main1, Main main2) {
        if (cartes.contientCarre(main1) != 0 && cartes.contientCarre(main2) != 0) {
            if (cartes.contientCarre(main1) > cartes.contientCarre(main2)) {
                return new Gagnant(1, VictoiresPossibles.carre, cartes.contientCarre(main1));
            } else if (cartes.contientCarre(main1) < cartes.contientCarre(main2)) {
                return new Gagnant(2, VictoiresPossibles.carre, cartes.contientCarre(main2));
            } else {
                cartes.supprimerCartes(main1, cartes.contientCarre(main1), 4);
                cartes.supprimerCartes(main2, cartes.contientCarre(main2), 4);

                return compareCarteLaPlusHaute(main1, main2);
            }
        } else if (cartes.contientCarre(main1) != 0) {
            return new Gagnant(1, VictoiresPossibles.carre, cartes.contientCarre(main1));
        } else {
            return new Gagnant(2, VictoiresPossibles.carre, cartes.contientCarre(main2));
        }

    }

    private static Gagnant compareFull(Main main1, Main main2) {
        int[] fullMain1 = cartes.contientFull(main1);
        int[] fullMain2 = cartes.contientFull(main2);

        System.out.println(fullMain1);
        System.out.println(fullMain2);

        if (fullMain1[0] != 0 && fullMain2[0] != 0) {
            if (fullMain1[0] > fullMain2[0]) {
                return new Gagnant(1, VictoiresPossibles.full, new Integer[]{fullMain1[0], fullMain1[1]});
            } else if (fullMain2[0] > fullMain1[0]) {
                return new Gagnant(2, VictoiresPossibles.full, new Integer[]{fullMain2[0], fullMain2[1]});
            } else {
                if (fullMain1[1] > fullMain2[1]) {
                    return new Gagnant(1, VictoiresPossibles.full, new Integer[]{fullMain1[0], fullMain1[1]});
                } else if (fullMain2[1] > fullMain1[1]) {
                    return new Gagnant(2, VictoiresPossibles.full, new Integer[]{fullMain2[0], fullMain2[1]});
                } else {
                    //ATTENTION! CAS D'EGALITE NORMALEMENT IMPOSSIBLE
                    return new Gagnant(0, VictoiresPossibles.egalite, null);
                }
            }
        } else if (fullMain1[0] != 0 && fullMain2[0] == 0) {
            return new Gagnant(1, VictoiresPossibles.full, new Integer[]{fullMain1[0], fullMain1[1]});
        } else {
            return new Gagnant(2, VictoiresPossibles.full, new Integer[]{fullMain2[0], fullMain2[1]});
        }


    }


}

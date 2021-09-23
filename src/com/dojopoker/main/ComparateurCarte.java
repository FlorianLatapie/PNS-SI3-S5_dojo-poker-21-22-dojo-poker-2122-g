package com.dojopoker.main;

public class ComparateurCarte {
    private ComparateurCarte() {
    }

    public static String compare(Main main1, Main main2) {
        if ((contientPaire(main1) || contientPaire(main2))) {
            return comparePaires(main1, main2);
        } else {
            return compareCarteLaPlusHaute(main1, main2);
        }
    }

    public static String compareCarteLaPlusHaute(Main main1, Main main2) {
        int resMain1 = 0, resMain2 = 0;
        int lePlusHaut = -1;

        for (int i = 0; i < main1.getCartesSize(); i++) {
            if (main1.cartes.get(i).valeur > main2.cartes.get(i).valeur) {
                resMain1++;
                if (main1.cartes.get(i).valeur > lePlusHaut) {
                    lePlusHaut = main1.cartes.get(i).valeur;
                }
            } else if (main1.cartes.get(i).valeur < main2.cartes.get(i).valeur) {
                resMain2++;
                if (main2.cartes.get(i).valeur > lePlusHaut) {
                    lePlusHaut = main2.cartes.get(i).valeur;
                }
            }
        }

        if (resMain1 == resMain2) {
            return "Egalité !";
        } else if (resMain1 > resMain2) {
            return "Main 1 gagne ! carte la plus haute : " + lePlusHaut;
        } else {
            return "Main 2 gagne ! carte la plus haute : " + lePlusHaut;
        }
    }

    public static String comparePaires(Main main1, Main main2) {
        if (contientPaire(main1) && contientPaire(main2)) {
            if (valeurPaire(main1) > valeurPaire(main2)) {
                return "Main 1 gagne ! grâce à paire vs paire : " + valeurPaire(main1);
            } else if (valeurPaire(main1) < valeurPaire(main2)) {
                return "Main 2 gagne ! grâce à paire vs paire : " + valeurPaire(main2);
            } else {
                supprimerCartes(main1, valeurPaire(main1), 2);
                supprimerCartes(main2, valeurPaire(main2), 2);

                return compareCarteLaPlusHaute(main1, main2);
            }
        } else if (contientPaire(main1)) {
            return "Main 1 gagne ! grâce à paire : " + valeurPaire(main1);
        } else {
            return "Main 2 gagne ! grâce à paire : " + valeurPaire(main2);
        }
    }

    public static boolean contientPaire(Main main1) {
        for (int i = 0; i < main1.getCartesSize(); i++) {
            for (int j = 0; j < main1.getCartesSize(); j++) {
                if (i != j && main1.cartes.get(i).valeur == main1.cartes.get(j).valeur) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int valeurPaire(Main main) {
        for (int i = 0; i < main.getCartesSize(); i++) {
            for (int j = 0; j < main.getCartesSize(); j++) {
                if (i != j && main.cartes.get(i).valeur == main.cartes.get(j).valeur) {
                    return main.cartes.get(i).valeur;
                }
            }
        }
        return -1;
    }

    private static void supprimerCartes(Main main, int valeurCarte, int nbASuppr) {
        int paire = valeurPaire(main);
        for (int j = 0; j < nbASuppr; j++) {
            for (int i = 0; i < main.getCartesSize(); i++) {
                if (main.getCartes().get(i).valeur == paire) {
                    main.getCartes().remove(i);
                    break;
                }
            }
        }
    }
}

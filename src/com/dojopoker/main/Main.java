package com.dojopoker.main;

import java.util.*;

public class Main {
    private List<Carte> cartes;

    public Main(List<Carte> cartes) {
        this.cartes = cartes;
    }

    List<Carte> getCartes() {
        return this.cartes;
    }

    int getCartesSize() {
        return this.cartes.size();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Main) {
            Main mainAComparer = (Main) obj;
            return this.cartes.equals(mainAComparer.cartes);
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder retour = new StringBuilder();
        for (Carte carte : cartes) {
            retour.append(carte.toString() + " ");
        }
        return retour.toString();
    }

    public Integer getVal(int i) {
        return this.cartes.get(i).getValeur();
    }

    public String getCouleurMain(int i) {
        return this.cartes.get(i).getCouleur();
    }

    public List<Integer> valTri() {
        List<Integer> liste = new ArrayList<>();
        for (int i = 0; i < this.getCartesSize(); i++) {
            liste.add(this.getVal(i));
        }
        Collections.sort(liste);
        return liste;
    }

    @Override
    public Main clone() {
        List<Carte> cartesTmp = new ArrayList<>();
        for (int i = 0; i < this.getCartesSize(); i++) {
            cartesTmp.add(this.getCartes().get(i));
        }
        return new Main(cartesTmp);
    }

    int contientPlusieurs(int occurencesATrouver) {
        Map<Integer, Integer> carteOccurences = new HashMap<>();

        for (int i = 0; i < this.getCartesSize(); i++) {
            if (carteOccurences.containsKey(this.getVal(i))) {
                // la carte existe, occurence ++
                carteOccurences.replace(this.getVal(i), carteOccurences.get(this.getVal(i)) + 1);
            } else {
                // la carte n'est pas encore repertoriée, occurence = 1
                carteOccurences.put(this.getVal(i), 1);
            }
        }

        for (Integer i : carteOccurences.keySet()) {
            if (carteOccurences.get(i) == occurencesATrouver) {
                return i;
            }
        }
        return 0;
    }

    int contientPaire() {
        return contientPlusieurs(2);
    }

    int contientBrelan() {
        return contientPlusieurs(3);
    }

    int contientCarre() {
        return contientPlusieurs(4);
    }

    Carte[] contientSuite() {
        int compteur = 1;
        List<Integer> liste = this.valTri();

        for (int j = 0; j < this.getCartesSize() - 1; j++) {
            if (liste.get(j) == (liste.get(j + 1) - 1)) {
                compteur++;
            }
        }

        Carte[] tableauRetour = new Carte[liste.size()];
        for (int i = 0; i < liste.size(); i++) {
            tableauRetour[i] = new Carte(liste.get(i));
        }

        if (compteur == 5) {
            return tableauRetour;
        }
        return new Carte[]{new Carte(0)};

    }

    Carte[] contientQuinteFlush() {
        Carte[] suite = contientSuite();
        String couleur = contientCouleur();
        if (contientSuite().length == 5 && contientCouleur() != null) {
            Carte[] listeRetour = new Carte[5];
            for (int i = 0; i < 5; i++) {
                listeRetour[i] = new Carte(suite[i].getValeur(), couleur);
            }
            return listeRetour;
        }
        return new Carte[]{new Carte(0)};
    }

    int[] contientDoublePaires() {
        Main mainTmp = this.clone();

        int paire1 = mainTmp.contientPaire();
        mainTmp.supprimerCartes(paire1, 2);
        int paire2 = mainTmp.contientPaire();
        mainTmp.supprimerCartes(paire2, 2);

        if (paire1 != 0 && paire2 != 0) {
            return new int[]{paire2, paire1};
        } else {
            return new int[]{0, 0};
        }
    }

    Carte[] contientFull() {
        if ((contientBrelan() != 0 && contientPaire() != 0)) {
            return new Carte[]{new Carte(contientBrelan()), new Carte(contientPaire())};
        } else {
            return new Carte[]{new Carte(0)};
        }
    }

    String contientCouleur() {
        if (this.getCartesSize() != 0) {
            String couleur = this.getCouleurMain(0);

            if (!couleur.equals("Pas de couleur")) {
                for (Carte carte : this.getCartes()) {
                    if (!carte.getCouleur().equals(couleur)) {
                        return null;
                    }
                }
            } else {
                return null;
            }
            return couleur;
        } else {
            return null;
        }
    }

    void supprimerCartes(int valeurCarte, int nbASuppr) {
        for (int j = 0; j < nbASuppr; j++) {
            for (int i = 0; i < this.getCartesSize(); i++) {
                if (this.getVal(i) == valeurCarte) {
                    this.getCartes().remove(i);
                    break;
                }
            }
        }
    }
}

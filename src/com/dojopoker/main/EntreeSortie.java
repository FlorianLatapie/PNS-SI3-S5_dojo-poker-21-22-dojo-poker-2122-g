package com.dojopoker.main;

import java.util.ArrayList;
import java.util.List;

public class EntreeSortie {
    private List<String> couleursPossibles;
    private List<String> valeursPossibles;
    private List<Carte> cartesPresentes;

    public EntreeSortie() {
        couleursPossibles = new ArrayList<>();
        valeursPossibles = new ArrayList<>();
        cartesPresentes = new ArrayList<>();
        initListes();
    }

    private void initListes() {
        couleursPossibles.add("Tr");
        couleursPossibles.add("Ca");
        couleursPossibles.add("Co");
        couleursPossibles.add("Pi");
        valeursPossibles.add("2");
        valeursPossibles.add("3");
        valeursPossibles.add("4");
        valeursPossibles.add("5");
        valeursPossibles.add("6");
        valeursPossibles.add("7");
        valeursPossibles.add("8");
        valeursPossibles.add("9");
        valeursPossibles.add("10");
        valeursPossibles.add("V");
        valeursPossibles.add("D");
        valeursPossibles.add("R");
        valeursPossibles.add("A");
    }

    private List<Carte> tableauStringVersListCarte(String[] saisie) throws Exception {
        List<Carte> retour = new ArrayList<>();

        for (String carte : saisie) {
            String couleur;
            String valeur;
            if (carte.length() == 4 || carte.length() == 3) {
                couleur = carte.substring(carte.length() - 2);
                valeur = carte.substring(0, carte.length() - 2);
            } else {
                throw new Exception("Impossible de séparer la valeur de la couleur pour " + carte);
            }
            if (couleursPossibles.contains(couleur) && valeursPossibles.contains(valeur)) {
                Carte carteAjouter = new Carte(valeur, couleur);
                if (!cartesPresentes.contains(carteAjouter)) {
                    retour.add(carteAjouter);
                    cartesPresentes.add(carteAjouter);
                } else {
                    throw new Exception("La carte " + valeur + couleur + " a dejà été saisie précedement");
                }
            } else {
                throw new Exception("La carte " + valeur + couleur + " n'est pas acceptée, veuillez recommencer");
            }
        }
        return retour;
    }

    public Main reccupereMain(String entree) throws Exception {
        String[] saisies = entree.split(" ");

        if (saisies.length != 5) {
            throw new Exception("Le nombre de cartes saisies est différent de 5");
        }
        List<Carte> cartes = tableauStringVersListCarte(saisies);

        return new Main(cartes);
    }
}
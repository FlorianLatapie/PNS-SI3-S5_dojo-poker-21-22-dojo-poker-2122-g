package com.dojopoker.main;

import java.util.ArrayList;
import java.util.List;

public class EntreeSortie {
    private List<String> couleursPossibles = new ArrayList<>();
    private List<String> valeursPossibles = new ArrayList<>();

    public EntreeSortie() {
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
        List<Carte> cartePresente = new ArrayList<>();

        for (String carte : saisie) {
            String couleur;
            String valeur;
            try {
                couleur = carte.substring(carte.length() - 2);
                valeur = carte.substring(0, carte.length() - 2);
            } catch (Exception e) {
                throw new Exception("Impossible de séparer la valeur de la couleur.");
            }
            if (couleursPossibles.contains(couleur) && valeursPossibles.contains(valeur)) {
                Carte carteAjouter = new Carte(valeur, couleur);
                if(!cartePresente.contains(carteAjouter)){
                    retour.add(carteAjouter);
                    cartePresente.add(carteAjouter);
                } else {
                    throw new Exception("La carte " + valeur + couleur + " a dejà été saisie précedement");
                }
            } else {
                throw new Exception("La carte " + valeur + couleur + " n'est pas acceptée, veuillez recommencer");
            }
        }
        return retour;
    }

    public boolean deuxMainsUniques(Main main1, Main main2){
        for(Carte carte : main1.getCartes()){
            if(main2.getCartes().contains(carte)){
                return false;
            }
        }
        return true;
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
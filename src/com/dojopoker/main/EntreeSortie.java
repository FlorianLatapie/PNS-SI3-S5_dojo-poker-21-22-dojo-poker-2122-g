package com.dojopoker.main;

import java.util.ArrayList;
import java.util.List;

public class EntreeSortie {
    private List<String> couleursPossibles = new ArrayList<>();
    private List<String> valeursPossibles = new ArrayList<>();

    public EntreeSortie(){
        initListes();
    }

    private void initListes(){
        couleursPossibles.add("Tr");couleursPossibles.add("Ca");couleursPossibles.add("Co");couleursPossibles.add("Pi");
        valeursPossibles.add("2");valeursPossibles.add("3");valeursPossibles.add("4");valeursPossibles.add("5");valeursPossibles.add("6");valeursPossibles.add("7");valeursPossibles.add("8");valeursPossibles.add("9");valeursPossibles.add("V");valeursPossibles.add("D");valeursPossibles.add("R");valeursPossibles.add("A");
    }

    private List<Carte> tableauStringVersListCarte(String[] saisie){
        List<Carte> retour = new ArrayList<>();
        for(String carte : saisie) {
            /*String valeur = carte.substring(carte.length()-2);
            String couleur = carte.substring(0, carte.length()-2);

            if(couleursPossibles.contains(couleur) && valeursPossibles.contains(valeur)){
                retour.add(new Carte(valeur, couleur));
            } else {
                throw new Exception("La carte "valeur+couleur+" n'est pas acceptée, veuillez recommencer");
            }*/
            int i = Integer.parseInt(carte);
            retour.add(new Carte(i));
        }
        return retour;
    }

    public Main reccupereMain(String entree) throws Exception {
        String[] saisies = entree.split(" ");

        if (saisies.length != 5){
            throw new Exception("Le nombre de cartes saisies est différent de 5");
        }
        List<Carte> cartes = tableauStringVersListCarte(saisies);

        return new Main(cartes);
    }
}
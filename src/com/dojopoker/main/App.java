package com.dojopoker.main;

import java.util.NoSuchElementException;

public class App {
    public static void main(String[] args) {
        try {
            MoteurJeu mj = new MoteurJeu();
            // Joueurs j = new Joueurs();
            // System.out.println(j.nvPartie());
            mj.lancerJeu();

            main(args);// on relance automatiquement le jeu à la fin
        } catch (Exception e) {
            if (e instanceof NoSuchElementException) return; // pour les erreurs de fin de fichier en test unitaire
            System.out.println("Une erreur s'est produite, veuillez recommencer\n" + e.getMessage());
            main(args);
        }
    }
}
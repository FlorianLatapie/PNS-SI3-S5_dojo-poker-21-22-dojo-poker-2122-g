package com.dojopoker.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueurs {
    private Main mainJoueur;
    private PaquetCarte paquet = new PaquetCarte();
    private List<Joueurs> liste = new ArrayList<Joueurs>();

    public Joueurs() {
        List<Carte> listeMain = new ArrayList<Carte>();
        listeMain.add(paquet.carteAuHasard());
        listeMain.add(paquet.carteAuHasard());

        this.mainJoueur = new Main(listeMain);
    }

    public String toString() {
        return this.mainJoueur.toString();
    }

    public List<Joueurs> nvPartie() {
        for(int i = 0; i < 4; i++) {
            liste.add(new Joueurs());
        }
        return liste;
    }
}

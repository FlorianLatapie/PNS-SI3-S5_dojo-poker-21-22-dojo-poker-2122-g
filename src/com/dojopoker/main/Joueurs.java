package com.dojopoker.main;

import java.util.ArrayList;
import java.util.List;

public class Joueurs {
    private Main mainJoueur;
    private PaquetCarte paquet = new PaquetCarte();
    private List<Joueurs> liste = new ArrayList<>();
    private Main cartesMilieu;

    public Joueurs() {
        List<Carte> listeMain = new ArrayList<>();
        listeMain.add(paquet.carteAuHasard());
        listeMain.add(paquet.carteAuHasard());

        this.mainJoueur = new Main(listeMain);
    }

    public String toString() {
        return "Joueurs "+this.mainJoueur.toString();
    }

    public List<Joueurs> nvPartie() {
        for(int i = 0; i < 4; i++) {
            liste.add(new Joueurs());
        }
        return liste;
    }

    public Main flop() {
        List<Carte> listeCarte = new ArrayList<>();
        listeCarte.add(paquet.carteAuHasard());
        listeCarte.add(paquet.carteAuHasard());
        listeCarte.add(paquet.carteAuHasard());

        cartesMilieu = new Main(listeCarte);
        return cartesMilieu;
    }
}

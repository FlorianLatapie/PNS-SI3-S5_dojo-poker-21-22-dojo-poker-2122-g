package com.dojopoker.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joueurs {
    private Main mainJoueur;
    private MoteurJeu mj = new MoteurJeu();
    private List<Carte> paquet = mj.creerPaquet();
    private List<Joueurs> liste = new ArrayList<Joueurs>();
    private Random rand = new Random();

    public Joueurs() {
        List<Carte> listeMain = new ArrayList<Carte>();
        int carte1 = rand.nextInt(52);
        listeMain.add(paquet.get(carte1));
        paquet.remove(carte1);

        int carte2 = rand.nextInt(51);
        listeMain.add(paquet.get(carte2));
        paquet.remove(carte2);

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

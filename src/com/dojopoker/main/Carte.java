package com.dojopoker.main;

public class Carte {
    int valeur;
    //String couleur;

    public Carte(int valeur /*, String couleur*/){
        this.valeur = valeur;
        //this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "Carte{" + "valeur=" + valeur + '}';
    }
}

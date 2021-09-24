package com.dojopoker.main;

public class Carte {
    private int valeur;
    //private Stringcouleur;

    public Carte(int valeur /*, String couleur*/){
        this.valeur = valeur;
        //this.couleur = couleur;
    }

    int getValeur() {
        return valeur;
    }

    /*String getCouleur() {
        return couleur;
    }*/

    @Override
    public String toString() {
        return  valeur + ""// + couleur
                ;
    }
}

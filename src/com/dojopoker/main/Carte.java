package com.dojopoker.main;

public class Carte {
    private int valeur;
    //String private couleur;

    public Carte(int valeur /*, String couleur*/){
        this.valeur = valeur;
        //this.couleur = couleur;
    }

    public int getValeur() {
        return valeur;
    }

    /*public String getCouleur() {
        return couleur;
    }*/

    @Override
    public String toString() {
        return  valeur + ""// + couleur
                ;
    }
}

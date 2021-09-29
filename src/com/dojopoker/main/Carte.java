package com.dojopoker.main;

public class Carte {
    private int valeur;
    //private String couleur;

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
    public boolean equals(Object obj){
        if (obj instanceof Carte) {
            Carte carteAComparer = (Carte)obj;
            return this.valeur == carteAComparer.valeur /* && this.couleur == carteAComparer.couleur*/;
        }
        return false;
    }

    @Override
    public String toString() {
        return  valeur + ""// + couleur
                ;
    }
}

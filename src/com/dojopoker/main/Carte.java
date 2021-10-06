package com.dojopoker.main;

public class Carte {
    private int valeur;
    private String valeurAff;
    private String couleur;

    public Carte(int valeur /*, String couleur*/){
        this.valeurAff = valeur+"";
        switch (valeur){
            case 11:
                this.valeurAff = "V";
                break;
            case 12:
                this.valeurAff = "D";
                break;
            case 13:
                this.valeurAff = "R";
                break;
            case 14:
                this.valeurAff = "A";
                break;
            default:
                this.valeur = valeur;
        }
        //this.couleur = couleur;
    }

    public Carte(String valeur/*, String couleur*/){
        this.valeurAff = valeur;
        switch (valeur){
            case "V":
                this.valeur = 11;
                break;
            case "D":
                this.valeur = 12;
                break;
            case "R":
                this.valeur = 13;
                break;
            case "A":
                this.valeur = 14;
                break;
            default:
                this.valeur = Integer.parseInt(valeur);
        }
        //this.couleur = couleur;
    }

    int getValeur() {
        return valeur;
    }

    String getCouleur() {
        return couleur;
    }

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
        return  valeurAff + ""// + couleur
                ;
    }
}

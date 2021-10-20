package com.dojopoker.main;

import static com.dojopoker.main.Couleur.*;

public class Carte {
    private int valeur;
    private String valeurAff;
    private Couleur couleur;
    private boolean possedeCouleur;

    private void intValToValAff(int valeur) {
        switch (valeur) {
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
    }

    private void stringCoulToCouleur(String couleur) {
        switch (couleur) {
            case "Tr":
                this.couleur = TREFLE;
                this.possedeCouleur = true;
                break;
            case "Co":
                this.couleur = COEUR;
                this.possedeCouleur = true;
                break;
            case "Ca":
                this.couleur = CARREAU;
                this.possedeCouleur = true;
                break;
            case "Pi":
                this.couleur = PIQUE;
                this.possedeCouleur = true;
                break;
            default:
                this.couleur = PAS_DE_COULEUR;
                this.possedeCouleur = false;
        }
    }

    private void stringValToIntVal(String valeur) {
        switch (valeur) {
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
    }

    public Carte(int valeur, Couleur couleur) {
        this.valeurAff = valeur + "";
        this.intValToValAff(valeur);
        this.couleur = couleur;
        this.possedeCouleur = true;
    }

    public Carte(int valeur, String couleur) {
        this.valeurAff = valeur + "";
        intValToValAff(valeur);
        stringCoulToCouleur(couleur);
    }

    public Carte(String valeur, String couleur) {
        this.valeurAff = valeur;
        stringValToIntVal(valeur);
        stringCoulToCouleur(couleur);
    }

    public Carte(String valeur, Couleur couleur) {
        this.valeurAff = valeur;
        stringValToIntVal(valeur);
        this.couleur = couleur;
        this.possedeCouleur = true;
    }

    public Carte(int valeur) {
        this.valeurAff = valeur + "";
        intValToValAff(valeur);
        this.couleur = PAS_DE_COULEUR;
        this.possedeCouleur = false;
    }

    public int getValeur() {
        return valeur;
    }

    Couleur getCouleur() {
        return couleur;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Carte) {
            Carte carteAComparer = (Carte) obj;
            return this.valeur == carteAComparer.valeur && this.couleur.equals(carteAComparer.couleur);
        }
        return false;
    }

    @Override
    public String toString() {
        if (possedeCouleur) {
            return valeurAff + "" + couleur.getCouleurToString();
        } else {
            return valeurAff;
        }
    }
}

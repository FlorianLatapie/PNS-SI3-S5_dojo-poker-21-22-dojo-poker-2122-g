package com.dojopoker.main;


public enum Couleur {
    CARREAU("Ca"),
    COEUR("Co"),
    PIQUE("Pi"),
    TREFLE("Tr"),
    PAS_DE_COULEUR("Pas de couleur");

    private String val;

    Couleur(String couleur) {
        this.val = couleur;
    }

    public String getCouleurToString() {
        return val;
    }
}

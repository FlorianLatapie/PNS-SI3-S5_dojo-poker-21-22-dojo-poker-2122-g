package com.dojopoker.main;

public enum VictoiresPossibles {
    EGALITE(0, "Egalite"),
    CARTE_LA_PLUS_HAUTE(1, "carte la plus haute"),
    PAIRE(2, "une paire"),
    DOUBLE_PAIRE(3, "double paire"),
    BRELAN(4, "brelan"),
    SUITE(5, "suite"),
    COULEUR(6, "couleur"),
    FULL(7, "full"),
    CARRE(8, "carré"),
    QUINTE_FLUSH(9, "quinte flush");

    private int val;
    private String valToString;

    VictoiresPossibles(int val, String valToString) {
        this.valToString = valToString;
        this.val = val;
    }

    public String getValToString() {
        return valToString;
    }
}


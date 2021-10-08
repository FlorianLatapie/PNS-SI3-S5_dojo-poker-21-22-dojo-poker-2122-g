package com.dojopoker.main;

public enum VictoiresPossibles {
    egalite(0, "Egalite"),
    carte_la_plus_haute(1, "carte la plus haute"),
    paire(2, "une paire"),
    double_paire(3, "double paire"),
    brelan(4, "brelan"),
    suite(5, "suite"),
    couleur(6, "couleur"),
    full(7, "full"),
    carre(8, "carré"),
    quinte_flush(9, "quinte flush");

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


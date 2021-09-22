package com.dojopoker.main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Carte> cartes;

    public Main(Carte ... cartes){
        this.cartes = new ArrayList<>();
        this.cartes.addAll(List.of(cartes));
    }

    public String toString(){
        String retour = "";
        for (Carte carte: cartes) {
            retour += carte.toString() + " ";
        }
        return retour;
    }
}

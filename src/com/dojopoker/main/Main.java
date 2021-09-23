package com.dojopoker.main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Carte> cartes;

    public Main(List<Carte> cartes){
        this.cartes = cartes;
    }

    public int getLenghtMain(){
        return this.cartes.size();
    }

    @Override
    public String toString() {
        String retour = "";
        for (Carte carte: cartes) {
            retour += carte.toString() + " ";
        }
        return retour;
    }
}

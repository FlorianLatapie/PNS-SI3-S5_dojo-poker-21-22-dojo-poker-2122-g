package com.dojopoker.main;

import java.util.List;

public class Main {
    private List<Carte> cartes;

    public Main(List<Carte> cartes){
        this.cartes = cartes;
    }

    List<Carte> getCartes(){
        return this.cartes;
    }

    int getCartesSize(){
        return this.cartes.size();
    }


    @Override
    public String toString() {
        StringBuilder retour = new StringBuilder();
        for (Carte carte: cartes) {
            retour.append(carte.toString() + " ");
        }
        return retour.toString();
    }
}

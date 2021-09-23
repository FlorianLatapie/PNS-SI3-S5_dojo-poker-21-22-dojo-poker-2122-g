package com.dojopoker.main;

import java.util.List;

public class Main {
    List<Carte> cartes;

    public Main(List<Carte> cartes){
        this.cartes = cartes;
    }

    public List<Carte> getCartes(){
        return this.cartes;
    }

    public int getCartesSize(){
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

package com.dojopoker.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez main 1 : ");
        String mainJ1 = scanner.nextLine();
        System.out.print("Entrez main 2 : ");
        String mainJ2 = scanner.nextLine();

        String[] saisiesJ1 = mainJ1.split(" ");
        String[] saisiesJ2 = mainJ2.split(" ");

        List<Carte> cartesJ1 = parse(saisiesJ1);
        List<Carte> cartesJ2 = parse(saisiesJ2);

        if(cartesJ1.size() == 5 && cartesJ2.size() == 5){
            Main main1 = new Main(cartesJ1);
            Main main2 = new Main(cartesJ2);
            System.out.println(ComparateurCarte.compare(main1, main2));
        } else {
            System.out.println("Les mains saisies doivent contenir 5 cartes chacune");
        }
    }

    private static List<Carte> parse(String[] saisie){
        List<Carte> retour = new ArrayList<>();
        for(String carte : saisie){
            int i = Integer.parseInt(carte);
            retour.add(new Carte(i));
        }
        return retour;
    }
}

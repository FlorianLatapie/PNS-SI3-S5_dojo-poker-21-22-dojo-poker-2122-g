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

        List<Carte> cartesJ1 = new ArrayList<>();
        List<Carte> cartesJ2 = new ArrayList<>();

        for(String carte : saisiesJ1){
            int i = Integer.parseInt(carte);
            cartesJ1.add(new Carte(i));
        }

        for(String carte : saisiesJ2){
            int i = Integer.parseInt(carte);
            cartesJ2.add(new Carte(i));
        }

        if(cartesJ1.size() == 5 && cartesJ2.size() == 5){
            Main main1 = new Main(cartesJ1);
            Main main2 = new Main(cartesJ2);
            System.out.println(ComparateurCarte.compareTotalDesMains(main1, main2));

        } else {
            System.out.println("Les mains saisies doivent contenir 5 cartes chacune");
        }
    }
}

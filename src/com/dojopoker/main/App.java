package com.dojopoker.main;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Entrez main A : ");
        int entreeUtilisateurA = scanner.nextInt();
        System.out.println("Entrez main B : ");
        int entreeUtilisateurB = scanner.nextInt();

        Carte mainA = new Carte(entreeUtilisateurA);
        Carte mainB = new Carte(entreeUtilisateurB);

        System.out.println(
                ComparateurCarte.compare(mainA, mainB)
        );


    }
}

package com.dojopoker.main;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Entrez main 1 : ");
            Main main1 = EntreeSortie.reccupereMain(scanner.nextLine());
            System.out.print("Entrez main 2 : ");
            Main main2 = EntreeSortie.reccupereMain(scanner.nextLine());

            System.out.println(ComparateurMain.compare(main1, main2));
            main(args);
        }catch (Exception e){
            System.out.println("Une erreur s'est produite, veuillez recommencer");
            main(args);
        }
    }
}
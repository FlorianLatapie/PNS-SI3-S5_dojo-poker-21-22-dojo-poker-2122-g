package com.dojopoker.main;

import java.util.Scanner;

public class MoteurJeu {
    private ComparateurMain cm = new ComparateurMain();

    public void lancerJeu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        EntreeSortie es = new EntreeSortie();

        System.out.print("Entrez main 1 : ");
        Main main1 = es.reccupereMain(scanner.nextLine());
        System.out.print("Entrez main 2 : ");
        Main main2 = es.reccupereMain(scanner.nextLine());

        Gagnant m = cm.compare(main1, main2);
        System.out.println(m.toString());
    }

}

package com.dojopoker.test;

import com.dojopoker.main.MoteurJeu;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;

public class MoteurJeuTest {
    @Test
    public void lancerJeuTest() throws Exception {
        final FileInputStream fips = new FileInputStream(new File("src/com/dojopoker/test/input.txt"));
        System.setIn(fips);

        MoteurJeu mj = new MoteurJeu();
        mj.lancerJeu();
    }
}

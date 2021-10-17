package com.dojopoker.test;

import com.dojopoker.main.App;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AppTest {
    @Test
    public void mainTest() throws FileNotFoundException {
        final FileInputStream fips = new FileInputStream(new File("src/com/dojopoker/test/input.txt"));
        System.setIn(fips);
        App.main(null);

    }

    @Test
    public void erreurMainTest() throws FileNotFoundException {
        final FileInputStream fips = new FileInputStream(new File("src/com/dojopoker/test/input2.txt"));
        System.setIn(fips);
        App.main(null);

    }
}

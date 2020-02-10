/*
    Name: Jared Manusig
    Email: Jmanus2@uic.edu
    Project 2 || Professor Hallenbeck
    Description: Test file for BaccaratGame.java
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    BaccaratGame g = new BaccaratGame();

    @Test
    void testConstructor(){
        assertEquals("BaccaratGame",
                g.getClass().getName(), "did not initialize proper object");
    }
}

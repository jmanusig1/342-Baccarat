/*
    Name: Jared Manusig
    Email: Jmanus2@uic.edu
    Project 2 || Professor Hallenbeck
    Description: Test file for BaccaratGameLogic.java
 */


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    BaccaratGameLogic g = new BaccaratGameLogic();

    @Test
    void testConstructor(){
        assertEquals("BaccaratGameLogic",
                g.getClass().getName(), "did not initialize proper object");
    }

    @Test
    void testWhoWonOne(){
        ArrayList<Card> handOne = new ArrayList<Card>();
        ArrayList<Card> handTwo = new ArrayList<Card>();

        handOne.add(new Card("", 4, ""));
        handOne.add(new Card("", 6, ""));

        handTwo.add(new Card("", 4, ""));
        handTwo.add(new Card("", 4, ""));

        assertEquals("Bank", g.whoWon(handOne,handTwo), "Who Won does not work");
    }

    @Test
    void testWhoWonTwo(){
        ArrayList<Card> handOne = new ArrayList<Card>();
        ArrayList<Card> handTwo = new ArrayList<Card>();

        handOne.add(new Card("", 4, ""));
        handOne.add(new Card("", 6, ""));

        handTwo.add(new Card("", 4, ""));
        handTwo.add(new Card("", 6, ""));

        assertEquals("Draw", g.whoWon(handOne,handTwo), "Who Won does not work");
    }

    @Test
    void testHandTotalOne(){
        ArrayList<Card> handOne = new ArrayList<Card>();

        handOne.add(new Card("", 4, ""));
        handOne.add(new Card("", 3, ""));

        assertEquals(7, g.handTotal(handOne), "Hand Total gives wrong total");
    }

    @Test
    void testHandTotalTwo(){
        ArrayList<Card> handOne = new ArrayList<Card>();

        handOne.add(new Card("", 4, ""));
        handOne.add(new Card("", 6, ""));

        assertEquals(0, g.handTotal(handOne), "Hand Total gives wrong total");
    }

    @Test
    void testBankerDrawOne(){
        ArrayList<Card> handOne = new ArrayList<Card>();
        ArrayList<Card> handTwo = new ArrayList<Card>();

        handOne.add(new Card("", 4, ""));
        handOne.add(new Card("", 6, ""));

        handTwo.add(new Card("", 4, ""));
        handTwo.add(new Card("", 4, ""));

        Card pc = new Card("", 4, "");

        assertFalse(g.evaluateBankerDraw(handTwo, pc), "Banker should not draw");
    }

    @Test
    void testBankerDrawTwo(){
        ArrayList<Card> handOne = new ArrayList<Card>();
        ArrayList<Card> handTwo = new ArrayList<Card>();

        handOne.add(new Card("", 4, ""));
        handOne.add(new Card("", 6, ""));

        handTwo.add(new Card("", 4, ""));
        handTwo.add(new Card("", 6, ""));

        Card pc = new Card("", 4, "");

        assertTrue(g.evaluateBankerDraw(handTwo, pc), "Banker should draw");
    }

    @Test
    void testPlayerDrawOne(){
        ArrayList<Card> handOne = new ArrayList<Card>();


        handOne.add(new Card("", 4, ""));
        handOne.add(new Card("", 3, ""));



        Card pc = new Card("", 4, "");

        assertFalse(g.evaluatePlayerDraw(handOne), "Player should not draw");
    }

    @Test
    void testPlayerDrawTwo(){
        ArrayList<Card> handOne = new ArrayList<Card>();


        handOne.add(new Card("", 4, ""));
        handOne.add(new Card("", 6, ""));


        Card pc = new Card("", 4, "");

        assertTrue(g.evaluatePlayerDraw(handOne), "Player should draw");
    }






}

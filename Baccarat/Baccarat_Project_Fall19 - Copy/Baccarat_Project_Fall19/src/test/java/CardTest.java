/*
    Name: Jared Manusig
    Email: Jmanus2@uic.edu
    Project 2 || Professor Hallenbeck
    Description: Test file for Cardjava
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CardTest {

    Card c = new Card();

    @Test
    void testConstructor(){
        assertEquals("Card",
                c.getClass().getName(), "did not initialize proper object");
    }

    @Test
    void testConstructorTwo(){
        c = new Card("Jack", 4, "Wumbo");
        assertEquals("Card",
                c.getClass().getName(), "did not initialize proper object");
    }

    @Test
    void testGetSuiteOne(){
        c = new Card("Clubs", 4, "Wumbo");
        assertEquals("Clubs",
                c.getSuite(), "does not give correct suite");
    }
    @Test
    void testGetSuiteTwo(){
        c = new Card("Hearts", 4, "Wumbo");
        assertEquals("Hearts",
                c.getSuite(), "does not give correct suite");
    }

    @Test
    void testGetValueOne(){
        c = new Card("Clubs", 4, "Wumbo");
        assertEquals(4,
                c.getValue(), "does not give correct value");
    }
    @Test
    void testGetValueTwo(){
        c = new Card("Clubs", 11, "Wumbo");
        assertEquals(11,
                c.getValue(), "does not give correct suite");
    }

    @Test
    void testGetUrlOne(){
        c = new Card("Clubs", 4, "Wumbo");
        assertEquals("Wumbo",
                c.getURL(), "does not give correct suite");
    }

    @Test
    void testGetUrlTwo(){
        c = new Card("Clubs", 4, "Wumbology");
        assertEquals("Wumbology",
                c.getURL(), "does not give correct suite");
    }


}

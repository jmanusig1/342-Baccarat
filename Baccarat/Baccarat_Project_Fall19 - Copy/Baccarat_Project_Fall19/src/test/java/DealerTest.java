/*
    Name: Jared Manusig
    Email: Jmanus2@uic.edu
    Project 2 || Professor Hallenbeck
    Description: Test file for BaccaratDealer.java
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class DealerTest {

	BaccaratDealer d = new BaccaratDealer();

	@Test
	void testConstructor() {
		assertEquals("BaccaratDealer",
				d.getClass().getName(), "did not initialize proper object");
	}

	@Test
	void testGenerateDeckSize(){
		//test deck size is 52
		d.generateDeck();
		assertEquals(d.deckSize(), 52, "Deck did not generate 52 cards");
	}

	@Test
	void testGenerateDeckSizeTwo(){
		//test deck size is 52 even after generating and drawing a card
		d.generateDeck();
		d.drawOne();
		d.generateDeck();
		assertEquals(d.deckSize(), 52, "Deck did not generate 52 cards");
	}

	@Test
	void testDealHand(){
		//check if it will deal a hand even if the deck is empty
		ArrayList<Card> hand = d.dealHand();
		assertEquals(false, hand.isEmpty(), "Hand does not give a hand");
	}

	@Test
	void testDealHandDeck(){
		//check if it will deal a hand even if the deck is empty
		d.generateDeck();
		ArrayList<Card> hand = d.dealHand();
		assertEquals(d.deckSize(), 50, "Hand does not give a hand");
	}


	@Test
	void testDealSize(){
		//check if it will deal a hand of 2
		ArrayList<Card> hand = d.dealHand();
		assertEquals(2, hand.size(), "Hand does not give right size hand");
	}

	@Test
	void testDraw(){
		//it will check if we get a card
		Card one = d.drawOne();
		assertNotNull(one, "DrawOne does not give a card");
	}

	@Test
	void testDrawTwo(){
		//it will check if the size is propely -1
		d.generateDeck();
		Card one = d.drawOne();
		assertEquals(d.deckSize(), 51, "DrawOne does not decrement the deck");
	}

	@Test
	void testShuffle(){
		//it will check if the deck actually shuffles
		d.generateDeck();
		Card one = d.drawOne();
		d.shuffleDeck();
		assertNotEquals(one, d.drawOne(), "Did not shuffle the deck");
	}

	@Test
	void testShuffleTwo(){
		//it will check if the size is proper
		d.shuffleDeck();
		assertEquals(d.deckSize(), 52, "Changes size of deck from 52");
	}

	@Test
	void testFullDeckSize(){
		//it will check if the size is proper
		d.shuffleDeck();
		assertEquals(d.deckSize(), 52, "deckSize does not return ");
	}

	@Test
	void testFullDeckSizeTwo(){
		//check if deck size changes after 1 draw
		d.drawOne();
		assertEquals(d.deckSize(),  51, "deckSize does not return ");
	}










}

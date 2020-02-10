/*
    Name: Jared Manusig
    Email: Jmanus2@uic.edu
    Project 2 Baccarat || Professor Hallenbeck
    Description: A class that holds the game logic for the Bacarrat
                 Game dealer.
 */


import java.util.ArrayList;
import java.util.Collections;

public class BaccaratDealer {

    //a private Arraylist that holds a deck of playing cards
    private ArrayList<Card> deck;

    //function checks if the deck is empty, and generates a new deck if so
    private void checkEmpty(){
        //check if the deck is empty. If so, generate new deck.
        if(deck.isEmpty()) {
            this.generateDeck();
            //shuffle the deck after generating a new deck
            this.shuffleDeck();
        }
    }

    //empty constructor
    BaccaratDealer() {
        deck = new ArrayList<Card>();
    }

    public void generateDeck(){

        deck.clear();

        //list of strings of suites
        String[] suites = new String[]{"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] suiteL = new String[]{"C", "D", "H", "S"};
        String[] face = new String[] {"J", "Q", "K"};
        //loop through the list
        for(int i = 2; i < 11; i++){
            for(int j = 0; j < 4; j++){
                deck.add(new Card(suites[j], i, "JPEG/" + i + suiteL[j] + ".jpg"));
            }
        }

        for(int i = 11; i < 14; i++){
            for(int j = 0; j < 4; j++){
                deck.add(new Card(suites[j], i, "JPEG/" + face[i - 11] + suiteL[j] + ".jpg"));
            }
        }

        for(int i = 0; i < 4; i ++){
            deck.add(new Card(suites[i], 1, "JPEG/" + "A" + suiteL[i] + ".jpg"));
        }

    }

    //function returns a hand of two cards
    public ArrayList<Card> dealHand() {
        //ArrayList to return the hand of the player/banker
        ArrayList<Card> hand = new ArrayList<Card>();

        //loop to deal 2 hand using the draw one Function
        for(int i = 0; i < 2; i++)
            hand.add(drawOne());

        return hand;
    }

    //function draws one card from the deck
    public Card drawOne(){
        //first check if the deck is empty
        this.checkEmpty();
        //get from the top of the deck
        Card oneCard = deck.get(0);
        //remove the top card
        deck.remove(0);
        //return the card
        return oneCard;
    }

    //function creates a new deck and shuffles it
    public void shuffleDeck(){
        //create a new deck
        this.generateDeck();
        //shuffle the deck
        Collections.shuffle(deck);
    }

    //function returns the number of cards in the deck
    public int deckSize(){
        return deck.size();
    }

}

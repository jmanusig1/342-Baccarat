/*
    Name: Jared Manusig
    Email: Jmanus2@uic.edu
    Project 2 Baccarat || Professor Hallenbeck
    Description: A class that creates an instance of a playing card
                 and holds the suite and value of a card instance.
 */



public class Card {
    //private variables to hold the card suite and value
    private String suite;
    private int value;
    private String cardURL;

    public Card(){
        suite = "None";
        value = 0;
        cardURL = "None";
    }

    //constructor for the Card class that takes the suite and value as parameter
    public Card(String theSuite, int theValue, String url){
        suite = theSuite;
        value = theValue;
        cardURL = url;
    }

    //method that return the suite
    public String getSuite(){
        return suite;
    }

    //method that returns the value
    public int getValue() {
        return value;
    }

    public String getURL() { return cardURL; }
}

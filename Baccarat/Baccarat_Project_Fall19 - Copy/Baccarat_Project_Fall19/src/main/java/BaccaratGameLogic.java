/*
    Name: Jared Manusig
    Email: Jmanus2@uic.edu
    Project 2 Baccarat || Professor Hallenbeck
    Description: A class that holds the game logic for the Bacarrat
                 Game.
 */


import java.util.ArrayList;

public class BaccaratGameLogic {

    //method that returns who won based on the hands
    public String whoWon(ArrayList<Card> hand1, ArrayList<Card> hand2){

        //get the player/bank hand totals
        int playerHand = handTotal(hand1);
        int bankHand = handTotal(hand2);

        //evaluate who won
        if(playerHand > bankHand)
            return("Player");
        if(bankHand > playerHand)
            return("Bank");
        return ("Draw");
    }

    //method return the value of the hand that the player holds
    public int handTotal(ArrayList<Card> hand){
        //total hold the hand total
        int total = 0;

        //loop through the cards in the hand
        for(Card c : hand){
            //if the card is 10 or face, do nothing
            if(c.getValue() > 9)
                continue;
            //otherwise, add the value to the total
            else
                total += c.getValue();
        }

        //if the total is greater than 9, subtract 10
        if(total > 9)
            total -= 10;

        //return updated total
        return total;
    }

    //method if the banker should be dealt a third card
    public boolean evaluateBankerDraw(ArrayList<Card> hand, Card
            playerCard){
        //get value of the first two cards
        int value = handTotal(hand);
        //the value of the player card
        int pVal = playerCard.getValue();

        //if the value is 0, then banker must draw
        if(value <= 2)
            return true;
        //otherwise, the next case is if the total <= 6
        if(value <= 6){
            //check if no hand was drawn (given by "None")
            if(playerCard.getSuite().equals("None")) {
                //check if the bank hand == 5 or lower
                if (value <= 5)
                    return true;
            }
            //if player card is 8 or higher or a 1
            if(pVal >= 8 || pVal == 1){
                //bank hand needs to be less than 4
                if(value <= 3)
                    return true;
            }
            //check if player card is 6, 7
            if(pVal >= 6){
                //bank hand needs to be 6 or lower
                if(value <= 6)
                    return true;
            }
            //check if the drawn card is 4, 5
            if(pVal >= 4){
                //bank hand needs to be 5 or lower
                if(value <= 5)
                    return true;
            }
            //check if drawn card is 2, 3
            if(pVal >= 2){
                //bank needs to be 4 or lower
                if(value <= 4)
                    return true;
            }
        }
        //otherwise, Banker cannot draw another card
        return false;
    }

    //method if the player should be dealt a third card
    public boolean evaluatePlayerDraw(ArrayList<Card> hand){
        //get the value of the first two cards in hand
        int value = handTotal(hand);
        //check the value of the cards
        if(value >= 6)
            return false;
        return true;
    }


}

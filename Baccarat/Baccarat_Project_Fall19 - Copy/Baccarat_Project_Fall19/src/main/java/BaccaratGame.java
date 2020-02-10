/*
    Name: Jared Manusig
    Email: Jmanus2@uic.edu
    Project 2 || Professor Hallenbeck
    Description: A Java application that run the Baccarat Card game using Javafx and event handlers

    Resources Used:
    - Playing card images from https://acbl.mybigcommerce.com/52-playing-cards/
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.animation.PauseTransition;
import javafx.util.Duration;

import java.util.ArrayList;

public class BaccaratGame extends Application {
	//data members to hold the two hands
	private ArrayList<Card> playerHand;
	private ArrayList<Card> bankerHand;
	//instance of the dealer and logic
	private BaccaratDealer theDealer;
	private BaccaratGameLogic gameLogic;
	//the current bet being placed
	double currentBet = 0;
	//total winnings of the player
	double totalWinnings;

	//who the player will bet on
	private String betOn = "Player";

	//how many wins the player/banker have
	private int bankerWins = 0;
	private int playerWins = 0;

	public static void main(String[] args) {
		launch(args);
	}

	//method returns the amount lost/won based on current Bet
	public double evaluateWinnings() {
		//if player won, return the current bet
		if (gameLogic.whoWon(playerHand, bankerHand).equals(betOn)){
			return (currentBet);
		}
		//if banker won, return negative curent bet
		return (-currentBet);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Let's Play Baccarat!!!");

		//declare a new border pane to hold everything
		BorderPane borderPane = new BorderPane();

		//instantiate the dealer and game logic
		theDealer = new BaccaratDealer();
		gameLogic = new BaccaratGameLogic();

		//text that holds how much we will bid
		Text bidText = new Text("BIDDING\n" + currentBet);
		bidText.setFont(Font.font(null, FontWeight.BOLD, 18));

		//text to hold who we are bidding on
		Text whoBidText = new Text("Bidding on:\nPlayer");
		whoBidText.setFont(Font.font(null, FontWeight.BOLD, 18));

		//text to hold how much we have earned
		Text earningsText = new Text("Earnings: " + totalWinnings);
		earningsText.setFont(Font.font(null,  FontWeight.EXTRA_BOLD, 18));

		//create a new options menu bar
		MenuBar options = new MenuBar();
		Menu optionsMenu = new Menu("Options");


		//the menu items we need to use
		MenuItem newGame = new MenuItem("Fresh Game");
		MenuItem endMenu = new MenuItem("Exit");


		//all the bidding buttons to change how much to bid
		Button phundred = new Button("+ 100");
		Button pten = new Button("+ 10");
		Button pone = new Button("+ 1");
		Button sone = new Button("- 1");
		Button sten = new Button("- 10");
		Button shundred = new Button("- 100");
		Button setZero = new Button("Set 0");

		//all bidding buttons to change who to bet on
		Button setBanker = new Button("Bet Banker");
		Button setTie = new Button("Bet Tie");
		Button setPlayer = new Button("Bet Player");

		//button to reset the Round
		Button startGame = new Button("New Round");


		//tool bar to hold the who to bid buttons
		ToolBar bidWhoBtns = new ToolBar(
				setPlayer,
				setBanker,
				setTie
		);

		//tool bar to hold all the buttons to adjust bidding amt
		ToolBar bidBtns = new ToolBar(
				phundred,
				pten,
				pone,
				sone,
				sten,
				shundred,
				setZero
		);

		//format the toolbars
		bidBtns.setOrientation(Orientation.VERTICAL);
		bidBtns.setMaxHeight(400);

		bidWhoBtns.setOrientation(Orientation.VERTICAL);
		bidWhoBtns.setMaxHeight(400);

		/* Event handlers*/

		//handler resets the game completely
		EventHandler<ActionEvent> newGameHandler =
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						try {
							//reset all the values
							betOn = "Player";
							playerWins = 0;
							bankerWins = 0;
							currentBet = 0;
							totalWinnings = 0;
							//start new
							start(primaryStage);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				};



		//all event handlers deal with adding or subtracting an amount from the bid
		EventHandler<ActionEvent> addHundred =
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						currentBet += 100;
						bidText.setText("BIDDING\n" + currentBet);
					}
				};
		EventHandler<ActionEvent> addTen =
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						currentBet += 10;
						bidText.setText("BIDDING\n" + currentBet);
					}
				};
		EventHandler<ActionEvent> addOne =
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						currentBet += 1;
						bidText.setText("BIDDING\n" + currentBet);
					}
				};
		EventHandler<ActionEvent> subOne =
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						currentBet -= 1;
						if(currentBet < 0)
							currentBet = 0;
						bidText.setText("BIDDING\n" + currentBet);
					}
				};
		EventHandler<ActionEvent> subTen =
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						currentBet -= 10;
						if(currentBet < 0)
							currentBet = 0;
						bidText.setText("BIDDING\n" + currentBet);
					}
				};
		EventHandler<ActionEvent>  subHundred =
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						currentBet -= 100;
						if(currentBet < 0)
							currentBet = 0;
						bidText.setText("BIDDING\n" + currentBet);
					}
				};
		EventHandler<ActionEvent> zeroBet =
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						currentBet = 0;
						bidText.setText("BIDDING\n" + currentBet);
					}
				};


		//set all the buttons to their respective handlers
		phundred.setOnAction(addHundred);
		pten.setOnAction(addTen);
		pone.setOnAction(addOne);
		sone.setOnAction(subOne);
		sten.setOnAction(subTen);
		shundred.setOnAction(subHundred);
		setZero.setOnAction(zeroBet);

		//anonymous classes assignments
		setBanker.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				whoBidText.setText("Bidding on:\nBanker");
				betOn = "Bank";
			}
		});
		setPlayer.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				whoBidText.setText("Bidding on:\nPlayer");
				betOn = "Player";
			}
		});
		setTie.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				whoBidText.setText("Bidding on:\nA Tie");
				betOn =  "Draw";
			}
		});



		//Event Handler that deals with starting a new round
		EventHandler<ActionEvent> startGamehandler =
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						//first generate a deck
						theDealer.generateDeck();
						//then shuffle the deck
						theDealer.shuffleDeck();

						//deal the hands to both players
						playerHand = theDealer.dealHand();
						bankerHand = theDealer.dealHand();

						//get the card images for the player/banker hand
						Image p1 = new Image(playerHand.get(0).getURL());
						Image p2 = new Image(playerHand.get(1).getURL());

						Image c1 = new Image(bankerHand.get(0).getURL());
						Image c2 = new Image(bankerHand.get(1).getURL());

						//PLAYER HAND IMAGE VIEW//
						ImageView p1v = new ImageView();
						p1v.setImage(p1);
						//format image view
						p1v.setFitHeight(150);
						p1v.setFitWidth(125);

						ImageView p2v = new ImageView();
						p2v.setImage(p2);
						//format image view
						p2v.setFitHeight(150);
						p2v.setFitWidth(125);

						//BANKER HAND IMAGE VIEW//
						ImageView c1v = new ImageView();
						c1v.setImage(c1);
						//format image view
						c1v.setFitHeight(150);
						c1v.setFitWidth(125);

						ImageView c2v = new ImageView();
						c2v.setImage(c2);
						//format image view
						c2v.setFitHeight(150);
						c2v.setFitWidth(125);

						//holds the third card if we need it for the player
						Card thirdCard = new Card();

						// create the image views and image to hold the 3rd card
						ImageView p3v = new ImageView();
						ImageView c3v = new ImageView();
						Image p3;
						Image c3;

						//rules for a "Natural" win
						if(gameLogic.handTotal(playerHand) == 9) {

						}
						else if(gameLogic.handTotal(bankerHand) == 9){

						}
						else if(gameLogic.handTotal(playerHand) == 8 &&
								gameLogic.handTotal(bankerHand) < 8){

						}
						else if(gameLogic.handTotal(playerHand) < 8 &&
								gameLogic.handTotal(bankerHand) == 8){

						}
						//if not a natural win, then draw third card
						else{
							//check if the player should draw
							if(gameLogic.evaluatePlayerDraw(playerHand)) {
								thirdCard = theDealer.drawOne();
								playerHand.add(thirdCard);
								p3 = new Image(playerHand.get(2).getURL());
								p3v.setImage(p3);
								p3v.setFitHeight(150);
								p3v.setFitWidth(125);
							}
							//check if the banker should draw
							if(gameLogic.evaluateBankerDraw(bankerHand, thirdCard)){
								bankerHand.add(theDealer.drawOne());
								c3 = new Image(bankerHand.get(2).getURL());
								c3v.setImage(c3);
								c3v.setFitHeight(150);
								c3v.setFitWidth(125);
							}
						}

						//set the player/banker cards to an HBOX so we can show it
						HBox playerCards = new HBox(5, p1v, p2v, p3v );
						HBox bankerCards = new HBox(5, c1v, c2v, c3v);

						//get the winner
						String winner = gameLogic.whoWon(playerHand, bankerHand);

						//winning text to reflect who won the ruound
						Text wintext = new Text();
						//and format
						wintext.setFont(Font.font(null, FontWeight.BOLD, 18));

						//evaluate the winnings
						totalWinnings += evaluateWinnings();

						//if the bid is zero... then technically no one won?
						if(evaluateWinnings() == 0){
							wintext.setText("Umm, you did not bet? No winners or losers!");
						}

						//otherwise, we won
						if(evaluateWinnings() > 0){
							playerWins++;
							wintext.setText(winner + " wins! You won your bets\n" +
									"Player wins: " + playerWins + " Banker wins: " + bankerWins  );
						}

						//or banker won
						if(evaluateWinnings() < 0){
							bankerWins++;
							wintext.setText(winner + " wins! You lost your bets\n" +
									"Player wins: " + playerWins + " Banker wins: " + bankerWins  );
						}

						//reflect the earnings to the text
						earningsText.setText("Earnings: " + totalWinnings);

						//set all the cards and text into the VBOX
						VBox gameCards = new VBox(5, new Text("PLAYER HAND"), playerCards,
								new Text("BANKER HAND"),  bankerCards, wintext);

						//and set it to the center of the Game
						borderPane.setCenter(gameCards);
					}
				};

		//set the new round to the event handler
		startGame.setOnAction(startGamehandler);

		//set the event handlers to fresh and end game
		newGame.setOnAction(newGameHandler);
		endMenu.setOnAction(e-> Platform.exit());

		//add them to the menu
		optionsMenu.getItems().addAll(newGame, endMenu);
		options.getMenus().addAll(optionsMenu);

		//hbox to hold the earnings and new round
		HBox starting = new HBox(20, startGame, earningsText);
		//vbox to hold the bidding amt buttons
		VBox bidBox = new VBox(1, bidText, bidBtns);
		//vbox to hold the buttons on who to bet on
		VBox bidWhoBox = new VBox(1, whoBidText, bidWhoBtns);
		bidBox.setMaxWidth(100);

		//box of all the menus
		VBox menuBox = new VBox(options);

		//set the borderpanes for everythign
		borderPane.setBottom(starting);
		borderPane.setLeft(bidBox);
		borderPane.setTop(menuBox);
		borderPane.setRight(bidWhoBox);

		//make the color green for casino effect
		borderPane.setStyle("-fx-background-color: green");

		//build application
		Scene scene = new Scene(borderPane,600,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}


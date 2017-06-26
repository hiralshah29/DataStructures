package com.codingalgo.examples.OOD;

import java.util.Random;

public class PokerGame {
	public static void main(String[] args) {        
        Game game = new Game();
        game.dealCards();
        game.showCards();
    }//end of main
}

 class Game {
    private Player[] players;
    private Deck deck;
    //constructor initializes the deck and cards
    public Game() {
        deck = new Deck();
        players = new Player[4];
        players[0] = new Player();
        players[1] = new Player();
        players[2] = new Player();
        players[3] = new Player();
        deck.shuffle();
    }
    //deals the card to each player
    public void dealCards() {
        int count = 0;
        for (int i = 0; i < players[0].getCards().length; i++) {
            for (int j = 0; j < players.length; j++) {
                players[j].setCardAtIndex(deck.getCard(count++), i);
            }
        }
    }
    //simulates the game and shows the result
    public void showCards() {
        for (int i = 0; i < players.length; i++) {
            System.out.print("Player " + (i + 1) + ": ");
            for (int j = 0; j < players[0].getCards().length; j++) {
                System.out.print("{" + players[i].getCardAtIndex(j).toString()+"} ");
            }
            if(players[i].countPair()> 0)
                System.out.print("\nPAIR(S):" + players[i].countPair()+ "! ");
            if(players[i].isFlush())
                System.out.print("FLUSH!!\n");
            System.out.println("\n------------------------------------");
        }
    }
}//end of class

 class Player {
	    public final static int MAX_CARD = 5;
	    private Card cards[];
	    //constructor initializes 5 cards in each hand
	    public Player() {
	        cards = new Card[MAX_CARD];
	    }
	    //returns all the cards in hand
	    public Card[] getCards() {
	        return cards;
	    }
	    //get the cards at a particular position
	    public Card getCardAtIndex(int index) {
	        if (index >= 0 && index < MAX_CARD)
	            return cards[index];
	        else
	            return null;
	    }
	   //sets the card at particular position
	    public void setCardAtIndex(Card c, int index) {
	        if(index >= 0 && index < MAX_CARD)
	            cards[index] = c;
	    }
	    //counts number of matched pair
	    public int countPair() {
	        int count = 0;
	        for (int i = 0; i < cards.length; i++) {
	            for (int j = i + 1; j < cards.length; j++) {
	                if (cards[i].getFace().equals(cards[j].getFace())){
	                    count++;
	                }
	            }
	        }
	        return count;
	    }

	    //checks if it is a flush or not i.e all five cards of same suit
	    public boolean isFlush() {
	        int count = 0;
	        for (int i = 0; i < cards.length; i++) {
	            for (int j = i + 1; j < cards.length; j++) {
	                if (cards[i].getSuit().equals(cards[j].getSuit())) {
	                    count++;
	                }
	            }
	        }
	        if(count == 5)
	            return true;
	        else
	            return false;
	    }    
	}
 
 class Deck {
	    private final String faces[] = {"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	    private final String suits[]={"Hearts","Diamonds","Clubs","Spades"};
	    private Card deck[];
	    private final int TOTAL_CARDS=52;
	    private Random randNum;    
	    //no-argument constructor fills the deck of cards
	    public Deck(){        
	        deck = new Card[TOTAL_CARDS];
	        randNum = new Random();
	        for(int i=0;i<deck.length;i++){
	            deck[i] = new Card(faces[i%13],suits[i/13]);
	        }
	    }
	    
	    //shuffles the deck
	    public void shuffle(){
	        for(int i=0;i<deck.length;i++){
	            int j = randNum.nextInt(TOTAL_CARDS);
	            Card c = deck[i];
	            deck[i] = deck[j];
	            deck[j] = c;
	        }
	    }        

	    //returns the individual card in the deck
	    public Card getCard(int index){
	        return deck[index];
	    }
	}//end of class
 
 class Card {
	    private String face;
	    private String suit;
	    //two-argument constructor initializes Cards face and suit
	    public Card(String face, String suit) {
	        super();
	        this.face = face;
	        this.suit = suit;
	    }
	    //getter method to return the face value
	    public String getFace() {
	        return face;
	    }
	    //setter method to initialize the face
	    public void setFace(String face) {
	        this.face = face;
	    }
	    //getter method to return the suit value
	    public String getSuit() {
	        return suit;
	    }
	    //setter method to initialize the suit
	    public void setSuit(String suit) {
	        this.suit = suit;
	    }
	    //return String representation of Card object
	    public String toString() {
	        return face + " of " + suit;
	    }
	}//end of class
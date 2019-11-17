package Pandemic.Gameboard;

import java.util.Random;

import Pandemic.player.Player;
import Pandemic.variables.Piece;
import Pandemic.variables.Variables;
import Pandemic.Gameboard.*;
import java.util.ArrayList;


public class SimulatePandemic
{
    public static void main(String[] args)
	{
	  System.out.println("starting new game");
	  SimulatePandemic testgame;
	  Player jesus;
	  Player unabomber;
	  Player jack;
	  Player deadpool;

	  unabomber = new Player("Unabomber","MEDIC");
	  jesus = new Player("Jesus","OPERATIONS_EXPERT");
	  jack = new Player("Jack the Ripper","SCIENTIST");
	  deadpool = new Player ("Zodiac Killer","QUARANTINE_SPECIALIST");
	  Player[] currentPlayers;
	  currentPlayers = new Player[4];
	  currentPlayers[0] = jesus;
	  currentPlayers[1] = jack;
	  currentPlayers[2] = unabomber;
	  currentPlayers[3] = deadpool;
	  
	  testgame = new SimulatePandemic(currentPlayers);
	
	  testgame.playGame();
    }

    // The Game Board contains all the objects of the game.
    public GameBoard gameBoard;
    
    // An array of the players who are playing
    public Player[] gamePlayers;
    
    // boolean attributes which indicate if the game is won or lost.
    public static boolean gameOver;
    public static boolean gameWon;
    public static boolean gameLost;
    
    /**
     * adjustable features of the game that is set up, including
     * numberColours - number of colours of disease played with. (default 4 colour)
     * requiredForCure- the number of cards which must be discarded to cure a disease (we set 4 instead of 5).
     * infectionRateSetting - the arrary of values needed for the infection rate.  (implenent in GameBoard @increaseEpidemic)
     * maximumOutbreaks - the maximum number of outbreaks that can happen before the game is lost. (8)
     * cardsDrawnInitally - the number of cards drawn between the players at the start of the game.
     * maximumHandSize - The maximum handsize of the players. (doesn't implement in this edition)
     */ 

    

    /**
     * This constructor for a Pandemic game creates a new instance of a GameBoard object called GameBoard with the given adjustable features of the game.
     * It requires an array of players to be provided.
     */
    public SimulatePandemic(Player[] currentGamePlayers)
    {
        System.out.println("Setting up a new game of pandemic with the below features.");
        System.out.println( 4 + " Colours of disease.");
        System.out.println( 4 + " cards of the same colour must be discarded at a research station to cure a disease.");
        System.out.println( 4 + " is the maximum number of epidemics.");
        System.out.println("Any more than " + 8 + " outbreaks and the game will be lost");
        System.out.println("The initial infection step will see " + 9 + " cities infected ");
        System.out.println("Between all players a maximum of " + 8 + " cards are drawn at start of the game");
        System.out.println("There are " + 5 + " research stations which can be placed, and " + 1 + 
                            " (min 1) are placed at the start of the game");
        
                                  
        // initialise instance variables
        //for 4 player the initial hand size is 2 cards
        int startingHandSize ;
        
        gameBoard = new GameBoard();
        gamePlayers = currentGamePlayers;
        
        // sets the players to the gameboard
        sitPlayersDown();
        gameBoard.startGame();
        startingHandSize = calcHandSize();
        drawHands(startingHandSize);
        placePieces();
        gameOver = false;        
    }
    
    public void playGame()
    {
        int i;
        int turns = 0;
        while (gameOver == false)
        {
            i = gamePlayers.length;
            while (i > 0 && !gameOver)
            {
                i = i -1;
                while (gamePlayers[i].getPlayerAction() > 0 && !gameOver){
                
                    //here is where an action should happen
                    // System.out.println("Chance for action here!");
                	/*
                	 * Here  you choose between 2 options
                	 * 1) modify the dummy AI methods 
                	 * 2) Create smart enough new methods to win the game
                	 */
                    gamePlayers[i].makeDecision();
                    checkGameOver();
               }
               if (!checkGameOver()) {
                   System.out.println(gamePlayers[i].getPlayerName() + " completed 4 actions");
                   gamePlayers[i].drawCard(2);
                   gameBoard.infectCityPhase(gameBoard.getInfectionRate());
               }
               checkGameOver();
            }
            
            turns++;
            if (!checkGameOver())
            {
                System.out.println("Ending turn " + turns + " everybody has had a go.");
            }
            resetAllPlayerAction();
        }
    }
    
   
   
    public boolean checkGameOver()
    {
        if (checkGameWon())
        {
            for (int i = 0 ; i < 5 ; i++)
            {
                System.out.println(" YOU WIN!!! ");
            }

            gameOver = true;
        }
        checkGameLost();
        return gameOver;
    }
    
    // checks if the game is lost
    public void checkGameLost()
    {
        if (gameBoard.getOutbreakCount()>Variables.MAX_NUMBER_OF_OUTBREAK)
        {
            System.out.println(" game over, too many outbreaks! ");
            gameLost = true;
            gameOver = true; 
            looserPrint();            
        }
        else if (gameBoard.emptyDeck())
        {
            System.out.println(" That's it game over, no more cards. ");
            gameLost = true;
            gameOver = true;
            looserPrint();
        }        
        //the condition of not have any other cubes to set 
        //is implemented in @GameBoard.checkCubesRemain and @NoMoreCubes
    }
    
    // Prints looser
    public static void looserPrint()
    {
        for (int i = 0 ; i < 5 ; i++)
        {
            System.out.println(" THE CIVILATION IS DEAD!");
        }
        
    }
    
    // sets all players actions back to 4
    public void resetAllPlayerAction()
    {
        int i = gamePlayers.length;
        while (i > 0)
        {
            i--;
            gamePlayers[i].resetPlayerAction();
        }
    }
    
    
    public void placePieces()
    {
        int i = gamePlayers.length;
        while (i > 0)
        {
            // placing pieces
            // System.out.println("Placing a piece for " + gamePlayers[i-1].getPlayerName());
            gameBoard.playerPieces[i-1] = new Piece(gamePlayers[i-1], gameBoard, Variables.atlanta);
            // System.out.println("making sure they know the piece is their piece!");
            gamePlayers[i-1].setPlayerPiece(gameBoard.playerPieces[i-1]);
            i = i -1;
        }
    }
    
    // calculates initial hand size based on number of players
    public int calcHandSize()
    {
        int i = gamePlayers.length;
        int toReturn=0;
        if (i==2) {toReturn= 4;}
        else if (i==3) {toReturn= 3;}
        else if (i==4) {toReturn= 2;}
        return toReturn;
    }
    
    //draw cards for each player
    public void drawHands(int handSize)
    {
        int i = gamePlayers.length;
        while (i > 0)
        {
            System.out.println("drawing hand for " + gamePlayers[i-1].getPlayerName());
            gamePlayers[i-1].drawCard(handSize);
            i = i -1;
        }
    }
    
    public boolean checkGameWon()
    {
        boolean isWon=true;
        for (int i = 0 ; i <gameBoard.diseases.size() ; i ++)
        {
            isWon = isWon && gameBoard.diseases.get(i).getCured();
        }
        gameWon= isWon;
        return isWon;
    }
        

    public void sitPlayersDown()
    {
        int i = gamePlayers.length;
        while (i > 0)
        {
            System.out.println(gamePlayers[i-1].getPlayerName() + " has joined the game");
            gamePlayers[i-1].setGameBoard(gameBoard);
            i = i -1;
        }
    }
}

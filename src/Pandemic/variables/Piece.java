package Pandemic.variables;


import java.util.ArrayList;

import Pandemic.Gameboard.GameBoard;
import Pandemic.cities.*;
import Pandemic.player.Player;

public class Piece
{
    public Player owner;
    public GameBoard gameBoard;
    public City location;


    /**
     * Constructor of class piece
     */
    public Piece(Player newOwner, GameBoard pieceBoard, City curLocation)
    {
        owner = newOwner;
        gameBoard = pieceBoard;
        location = curLocation;
    }
    
    
    public void setLocation(City newLocation) { location = newLocation;}
    
    public City getLocation() {   return location;  }
    
    public ArrayList<City> getLocationConnections()
    {
    	return location.getNeighbors();
    }           
}
package Pandemic.Gameboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Pandemic.cities.City;
import Pandemic.deck.InfectDeck;
import Pandemic.deck.PlayerDeck;
import Pandemic.variables.Disease;
import Pandemic.variables.Piece;
import Pandemic.variables.Variables;

/***
 * This is a attempt to construct a naive Pandemic Board game edition.*
 ***/

public class GameBoard {
	
    
    // A city used for unused research centers
    public City unplaced = new City();

    // the number of cards needed to discover a cure
    public int neededForCure;
    
    // the array of the infection rate indicator.
    public int infectionRate;
    
    // the position on the array of the marker.
    public int currentRate=1;
    
    // The number of outbreaks.
    public int outbreakCount;
    
    //----------------------------------------------------/////////
    // An array containing all the players pieces.
    public Piece[] playerPieces;    
    
    public PlayerDeck playerDeck ;
    public InfectDeck infectDeck ;
    public InfectDeck CitiesMap  ;
    
    // A ArrayList made up of player cards.
    public ArrayList<Object> playerPile = new ArrayList<Object>() ;    
    
    // A ArrayList made up of discarded player cards.
    public ArrayList<Object> playerDiscardPile  = new ArrayList<Object>();   
    
    // The same for the infect cards
    public ArrayList<City>   infectPile = new ArrayList<City>();
    
    // The same for the infect cards
    public ArrayList<City>   infectDiscardPile = new ArrayList<City>() ;
        
    // An array containing all the city objects used in the game.
 	public ArrayList<City>   cities = new ArrayList<City>();
 	
 	//an array use for special ability of QUARANTINE_SPECIALIST
 	public ArrayList<City>   checkCities = new ArrayList<City>();
 	
    // counters for each of the pools of cubes.
    public int redCubes = 24;
    public int blueCubes = 24;
    public int yellowCubes = 24;
    public int blackCubes = 24;
    
    // An arraylist containing all the research centers
    //public ResearchCentre[] researchCentres;
    
    // An arraylist containing all the diseases used in the game.
    public ArrayList<Disease> diseases = new ArrayList<Disease>();
    
    public int numberColours;
        
    // This gives a list of all the colors which could be used.
    String[] possibleColour = {"Red","Blue","Yellow","Black"};
    
    public GameBoard()
    {
        infectionRate = Variables.INFECTION_RATE;
        setDiseases();
        System.out.println("Setting up the map");
        System.out.println("Setting up the decks");
        playerDeck = new PlayerDeck();
        infectDeck = new InfectDeck();
        CitiesMap  = new InfectDeck();
   
        playerPile = playerDeck.getPlayerPile();
        playerDiscardPile = playerDeck.getPlayerDiscardPile();  
        infectPile = infectDeck.getInfectPile();
        infectDiscardPile = infectDeck.getInfectDiscardPile();
        //list of all the cities keep it intact
        cities     = CitiesMap.getInfectPile(); 

        Collections.shuffle(cities);
        //setup the ResearchCentres
        placeInitialResearchCentres();
        playerPieces = new Piece[4];
        //outbreakCount = 0;
        neededForCure = 4; 
        //construct the neighbors for every city
        setupNeighbors();
        
    }
    
    //set-up neighbors cities for every city
    public void setupNeighbors() {
    	Variables.sanfransisco.setNeighbors(true);
    	Variables.chicago.setNeighbors(true);
    	Variables.atlanta.setNeighbors(true);
    	Variables.montreal.setNeighbors(true);
    	Variables.newyork.setNeighbors(true);
    	Variables.washington.setNeighbors(true);
    	Variables.madrid.setNeighbors(true);
    	Variables.london.setNeighbors(true);
    	Variables.paris.setNeighbors(true);
    	Variables.essen.setNeighbors(true);
    	Variables.milan.setNeighbors(true);
    	Variables.stpeterburg.setNeighbors(true);
    	Variables.losangeles.setNeighbors(true);
    	Variables.mexicocity.setNeighbors(true);
    	Variables.miami.setNeighbors(true);
    	Variables.bogota.setNeighbors(true);    	
    	Variables.lima.setNeighbors(true);
    	Variables.santiago.setNeighbors(true);
    	Variables.buenosaires.setNeighbors(true);
    	Variables.saopaulo.setNeighbors(true);
    	Variables.lagos.setNeighbors(true);
    	Variables.kinshasa.setNeighbors(true);
    	Variables.johannesburg.setNeighbors(true);
    	Variables.khartoum.setNeighbors(true);    	
    	Variables.algiers.setNeighbors(true);
    	Variables.istanbul.setNeighbors(true);
    	Variables.cairo.setNeighbors(true);
    	Variables.moscow.setNeighbors(true);
    	Variables.baghdad.setNeighbors(true);
    	Variables.tehran.setNeighbors(true);
    	Variables.riyadh.setNeighbors(true);
    	Variables.karachi.setNeighbors(true);
    	Variables.mumbai.setNeighbors(true);    	
    	Variables.delhi.setNeighbors(true);
    	Variables.chennai.setNeighbors(true);
    	Variables.kolkata.setNeighbors(true);
    	Variables.bangkok.setNeighbors(true);
    	Variables.jakarta.setNeighbors(true);
    	Variables.hochiminhcity.setNeighbors(true);    	
    	Variables.hongkong.setNeighbors(true);
    	Variables.shanghai.setNeighbors(true);
    	Variables.beijing.setNeighbors(true);
    	Variables.seoul.setNeighbors(true);
    	Variables.tokyo.setNeighbors(true);
    	Variables.osaka.setNeighbors(true);
    	Variables.taipei.setNeighbors(true);    	
    	Variables.manila.setNeighbors(true);
    	Variables.sydney.setNeighbors(true);   	    	
    }
    
    public List<City> getResearchCentre(){return Variables.GET_CITIES_WITH_RESEARCH_STATION();}
    
    public int getNumberColours(){ return 4; }
    
    public int getNeededForCure() { return neededForCure;}
    
    public String getGameState() { return current3CubeCities(); }
    
    // returns all the cities with 3 cubes
    public ArrayList<City> get3CubeCities()
    {
    	ArrayList<City> toReturn = new ArrayList<City>();
        for (int i = 0 ; i < cities.size() ; i ++)
        {
            if (cities.get(i).getMaxCube() == 3)
            {
            	//System.out.println("The:"+cities.get(i).getName() + " 3 cubes");
                toReturn.add(cities.get(i));                
            }
        }       
        return toReturn;
    }

    // returns all the cities with 2 cubes
    public ArrayList<City> get2CubeCities()
    {
    	ArrayList<City> toReturn = new ArrayList<City>();
        for (int i = 0 ; i < cities.size() ; i ++)
        {
            if (cities.get(i).getMaxCube() == 2)
            {
            	//System.out.println("The:"+cities.get(i).getName() + " 2 cubes");
            	toReturn.add(cities.get(i));
            }
        }       
        return toReturn;
    }
    
    // returns all the cities with 1 cubes
    public ArrayList<City> get1CubeCities()
    {
    	ArrayList<City> toReturn = new ArrayList<City>();
        for (int i = 0 ; i < cities.size() ; i ++)
        {
            if (cities.get(i).getMaxCube() == 1)
            {
            	//System.out.println("The:"+cities.get(i).getName() + " 1 cubes");
            	toReturn.add(cities.get(i));
            }
        }       
        return toReturn;
    }
	
    public ArrayList<City> getResearchLocations()
    {
    	ArrayList<City> toReturn = new ArrayList<City>();
        for (int i = 0 ; i < Variables.CITY_WITH_RESEARCH_STATION.size(); i++)
        {	
        	//get location of the city with Research_station
            toReturn.add(Variables.CITY_WITH_RESEARCH_STATION.get(i));
        } 
        return toReturn;
    }
    
    public String current3CubeCities()
    {
        String toReturn = "";
        ArrayList<City> toUse = get3CubeCities();
        for (int i = 0; i < toUse.size(); i ++)
        {
            toReturn = toReturn + toUse.get(i).getName() + " ";
        }
        return toReturn + " these cities have 3 cubes";
    }
    
    //returns an integer equal to the number of cities with X cubes in
    public int countXCubeCities(ArrayList<City> cityArray, int numberCubes)
    {
        int toReturn = 0;
        for (int i = 0; i < cities.size(); i++)
        {
            //System.out.println("looking for cities with" + numberCubes + "cubes");
            if (cities.get(i).getMaxCube() == numberCubes)
            {
                //System.out.println("found a city with" + numberCubes+ "cubes!");
                toReturn++;
            }            
        }
        return toReturn;
    }
	
    public int getInfectionRate(){return Variables.INFECTION_RATE; }
    
    public int getOutbreakCount(){return Variables.OUTBREAK_MARKER; }
    
    // Increments the outbreak counter
    public void incrementOutbreak(){ Variables.OUTBREAK_MARKER++;}
    
    //add a card to PlayerDiscardPile
    public void addPlayerCardDiscard(City toAdd){  playerDiscardPile.add(toAdd);}
    
    /*set the initial Infected cities
    *you may initialize this methods 
    *with any methods you created
    *this methods called from @SimulatePandemic class
    **/
    public void startGame() {  initialInfect(); }   
   
    
    // Sets up the initial outbreaks of disease for a given number of each city.
    //the 9 cities that will initially start with fix amount of infection
    public void initialInfect()
    {
        Collections.shuffle(infectPile);
        Collections.shuffle(cities);
        int x;
        for (int i = 0 ; i< Variables.NUM_INITIALLY_INFECTED; i++)
        {
        	if(i<3) {
        		// Draws a card to put 3 cubes placed on it
        		City toInfect=infectPile.get(0);
        		System.out.println("Placing " + 3 + " cube on " + toInfect.getName());      
        		for (x=0;x<cities.size();x++) { 
        			if (cities.get(x).getName().equals(toInfect.getName())) {
        				break;
        			}
        		}
        		//System.out.println("City infect City is: "+ cities.get(x));
        		//System.out.println("with colour: " +toInfect.getColour());
        		
        		//infect with 3 cubes
        		cities.get(x).addCube(toInfect.getColour());
        		cities.get(x).addCube(toInfect.getColour());
        		cities.get(x).addCube(toInfect.getColour());   
        		//System.out.println("maxCube:"+cities.get(x).getMaxCube());
        		
        		infectDiscardPile.add(toInfect);//discard the city to @infectDiscardPile
        		infectPile.remove(0);
        		//descrease the available cubes of this colour
        		removeCube(toInfect.getColour());
        		removeCube(toInfect.getColour());
        		removeCube(toInfect.getColour());
        		
        	}	
        	else if(i>=3 && i<6){
        		// Draws a card to have 2 cubes placed on it
          	  	City toInfect=infectPile.get(0);
                System.out.println("Placing " + 2 + " cube on " + toInfect.getName());
        		for (x=0;x<cities.size();x++) {    				
        			if (cities.get(x).getName().equals(toInfect.getName())) {
        				break;
        			}
        		}
        		//infect with 2 cubes
                cities.get(x).addCube(toInfect.getColour());
        		cities.get(x).addCube(toInfect.getColour());   
        		//System.out.println("maxCube:"+cities.get(x).getMaxCube());
        		
        		infectDiscardPile.add(toInfect);//discard the city to @infectDiscardPile
        		infectPile.remove(0);
        		
        		//descrease the available cubes of this colour
        		removeCube(toInfect.getColour());
        		removeCube(toInfect.getColour());
        	}
        	else {
        		// Draws a card to have 1 cubes placed on it
          	    City toInfect=infectPile.get(0);
                System.out.println("Placing " + 1 + " cube on " + toInfect.getName());
        		for (x=0;x<cities.size();x++) {    				
        			if (cities.get(x).getName().equals(toInfect.getName())) {
        				break;
        			}
        		}
        		//infect with 1 cubes
                cities.get(x).addCube(toInfect.getColour());
                //System.out.println("maxCube:"+cities.get(x).getMaxCube());
          	    
                infectDiscardPile.add(toInfect);//discard the city to @infectDiscardPile
          	    infectPile.remove(0);
          	    
          	    //descrease the available cubes of this colour
          	    removeCube(toInfect.getColour());
        	}
        }        
    }   
    
    
    // This method will infect a given number of cities based on the given infection rate.
    @SuppressWarnings("unchecked")
	public void infectCityPhase(int infectionRate)
    {
        int i,z;
        
        z=0;
        for (z=0;z<playerPieces.length;z++)//for finding pieces of QUARANTINE_SPECIALIST
        {
        	if (playerPieces[z].owner.getPlayerRole().equals("QUARANTINE_SPECIALIST"))
        	 break;
        }
        i = 0;
        while (i< infectionRate) {
            i = i + 1;
            City cityToInfect = infectPile.get(0);
            
            checkCities = (ArrayList<City>) playerPieces[z].getLocationConnections().clone();
            //check all connected city for QUARANTINE_SPECIALIST
            if (!checkCities.contains(cityToInfect)) {
            	System.out.println("INFECTING " + cityToInfect.getName() + " with 1 " + cityToInfect.getColour() + " cubes.");
            	infectCity(cityToInfect);
            }
        }
        checkCities.clear();
        
    }
    
    //Infects a given city with a cube of the given colour
    public void infectCity(City infectCity)
    {    	
    	if (checkCubesRemain(infectCity.getColour())) {	    	 
    		 int x;// Finds the position of the city to be infected in the cities array.
    		 for (x=0;x<cities.size();x++) {    				
    			 if (cities.get(x).getName().equals(infectCity.getName())) {
    				//System.out.println("I have found " + infectCity.getName() + " and it is at position " + x + " within the cities array");
     				break;
     			}
    		 }
	         if (cities.get(x).addCube(infectCity.getColour()))
	         {
	             System.out.println("OUTBREAK");
	             incrementOutbreak();
	         }
	         //removes a cube of the appropriate colour from the game boards pool.
	         removeCube(infectCity.getColour());
	         // System.out.println("Just removed a " + infectCity.getColour() + " from the pool");
	         infectDiscardPile.add(infectCity);
	     	 infectPile.remove(infectCity);  
    	}
    	else {    		NoMoreCubes();	}
    	
    	  	
    }
    
    
    
    public void resetDistances()
    {
        for (int i = 0 ; i < cities.size() ; i ++)
        {
            cities.get(i).setDistance(9999999);
        }
    }
	
    // takes a cube away from the pool of cubes.
    public void removeCube(String Cubecolour)
    {
        if (Cubecolour.equals("Red"))
        {
            redCubes = redCubes - 1;
        }
        else if (Cubecolour.equals("Blue"))
        {
            blueCubes = blueCubes - 1;
        }
        else if (Cubecolour.equals("Yellow"))
        {
            yellowCubes = yellowCubes - 1;
        }
        else if (Cubecolour.equals("Black"))
        {
            blackCubes = blackCubes - 1;
        }        
    }
    
   // add a cube to the pool of cubes.
    public void addCube(String Cubecolour)
    {
        if (Cubecolour.equals("Red"))
        {
            redCubes = redCubes + 1;
        }
        else if (Cubecolour.equals("Blue"))
        {
            blueCubes = blueCubes + 1;
        }
        else if (Cubecolour.equals("Yellow"))
        {
            yellowCubes = yellowCubes + 1;
        }
        else if (Cubecolour.equals("Black"))
        {
            blackCubes = blackCubes + 1;
        }        
    }

    // checks the game isn't lost because disease cubes have run out 
    public boolean checkCubesRemain(String colour)
    {
    	boolean toReturn = false;
    	if (colour=="Blue" && blueCubes>0) {return toReturn=true;}
    	else if (colour=="Yellow" && yellowCubes>0) {return toReturn=true;}
    	else if (colour=="Black" && blackCubes>0) {return toReturn=true;}
    	else if (colour=="Red" && redCubes>0) {return toReturn=true;}
		return toReturn;
    }
    
    //check if the playerDeck is empty
    public boolean emptyDeck ()
    {
        int cardsLeft;
        cardsLeft = playerPile.size();
        if (cardsLeft == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    //check if cube pool is empty
    public void NoMoreCubes() {
    	System.out.println("Just a bunch of losers");
		System.out.println("You lost the game ");
		System.out.println("No more cubes to put on board");
		SimulatePandemic.gameLost = true;
		SimulatePandemic.gameOver = true; 
		SimulatePandemic.looserPrint();    
    	
    }
    	
    // moves the infection rate marker by 1.
    public void increaseEpidemic()
    {
    	switch(currentRate) {
	    	case 1:
	    		currentRate=2;
	    		break;
	    	case 2:
	    		currentRate=3;
	    		break;
	    	case 3:
	    		Variables.INFECTION_RATE++;
	    		currentRate=4;
	    		System.out.println("Increasing the rate of infection");
	    		break;
	    	case 4:
	    		currentRate=5;
	    		break;
	    	case 5:
	    		Variables.INFECTION_RATE++;
	    		currentRate=6;
	    		System.out.println("Increasing the rate of infection");
	    		break;
	    	case 6:
	    		currentRate=7;
	    		break;
	    	}        
    }
    
    //draws the bottom card of the infection deck, and places 3 cubes on it.
    public void infectEpidemic()
    {
        City toInfect;
        toInfect = infectPile.get(infectPile.size()-1);
        System.out.println(toInfect.getName() + " has now been infected with 3 cubes.");
        int x;
        for (x=0;x<cities.size();x++) {    				
			if (cities.get(x).getName().equals(toInfect.getName())) {
				break;
			}
		}
		//infect with 3 cubes
        cities.get(x).addCube(toInfect.getColour());
		cities.get(x).addCube(toInfect.getColour());   
		cities.get(x).addCube(toInfect.getColour());   
        
        //descrease the available cubes of this colour
  	    removeCube(toInfect.getColour());
  	    removeCube(toInfect.getColour());
  	    removeCube(toInfect.getColour());
  	    
  	    infectDiscardPile.add(toInfect);
  	    infectPile.remove(toInfect);
    }
    
    // shuffles the infection discard pile 
    // and put on top of the infection pile
    public void intensifyEpidemic()
    {
        Collections.shuffle(infectDiscardPile);
        infectPile.addAll(0, infectDiscardPile);
        infectDiscardPile.clear();//empty
    }
    
    public void resolveEpidemic()
    {
        // moves the infection rate marker by 1, and updates the rate.
        increaseEpidemic();
        // draws the bottom card of the infection deck, and places 3 cubes on it
        infectEpidemic();
        // shuffles the infection discard pile onto the top of the infection deck
        intensifyEpidemic();
    }
    
    /**
     * Constructor for objects of class GameBoard
     */
    public void setDiseases()
    {
        for(int i=0;i<4;i++) {
        	diseases.add(new Disease("Red"));
        	diseases.add(new Disease("Black"));
        	diseases.add(new Disease("Yellow"));
        	diseases.add(new Disease("Blue"));
        }
    }
    
    public boolean cureDisease(String colour)
    {
        Disease toCure = getDisease(colour);
        if (!toCure.getCured())
        {
            toCure.setCured(true);
            System.out.println(toCure.getColour() + " Disease Cured." );
            return true;
        }
        System.out.println("already cured!");
        return false;

    }
    
    public Disease getDisease(String colour)
    {
        for (int i = 0; i < diseases.size() ; i ++)
        {
            if (diseases.get(i).getColour().equals(colour))
            {
                return diseases.get(i);
            }
        }
        return null;
    }
    
   
    public void placeInitialResearchCentres()
    {
        System.out.println("Setting initial station in Atlanta");
        for (int i = 0 ; i < cities.size() ; i ++)
        {
        	if (cities.get(i).equals(Variables.atlanta)) {
        		Variables.CITY_WITH_RESEARCH_STATION.add(cities.get(i));
        		System.out.println("setting a new station in " + cities.get(i).getName());
        	}            
        }
    }
    
    public boolean checkResearchStation(City toCheck)
    {
    	if (Variables.CITY_WITH_RESEARCH_STATION.contains(toCheck)) {return true;}
    	else {return false;}
    }

    
    
    
}

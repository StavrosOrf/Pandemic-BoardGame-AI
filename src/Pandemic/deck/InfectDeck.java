package Pandemic.deck;

import java.util.ArrayList;
import Pandemic.cities.*;


public class InfectDeck {

	public ArrayList<City> InfectPile = new ArrayList<City>();
	public ArrayList<City> InfectDiscardPile = new ArrayList<City>();
	
	//CREATE A Infect Deck with 48 cities
	//each one of 48 cities in table graph
	public InfectDeck(){		
		InfectPile.add( new SanFransisco(0,0,0,0,0));
		InfectPile.add( new Chicago(0,0,0,0,0));
		InfectPile.add( new Atlanta(0,0,0,0,0));
		InfectPile.add( new Montreal(0,0,0,0,0));
		InfectPile.add( new NewYork(0,0,0,0,0));
		InfectPile.add( new Washington(0,0,0,0,0));
		InfectPile.add( new Madrid(0,0,0,0,0)) ;
		InfectPile.add( new London(0,0,0,0,0));
		InfectPile.add( new Paris(0,0,0,0,0));
		InfectPile.add( new Essen(0,0,0,0,0));
		InfectPile.add( new Milan(0,0,0,0,0));
		InfectPile.add( new StPetersburg(0,0,0,0,0));
		InfectPile.add( new LosAngeles(0,0,0,0,0));
		InfectPile.add( new MexicoCity(0,0,0,0,0));
		InfectPile.add( new Miami(0,0,0,0,0));
		InfectPile.add( new Bogota(0,0,0,0,0));
		InfectPile.add( new Lima(0,0,0,0,0));
		InfectPile.add( new Santiago(0,0,0,0,0));
		InfectPile.add( new BuenosAires(0,0,0,0,0));
		InfectPile.add( new SaoPaulo(0,0,0,0,0));
		InfectPile.add( new Lagos(0,0,0,0,0));
		InfectPile.add( new Kinshasa(0,0,0,0,0));
		InfectPile.add( new Johannesburg(0,0,0,0,0));
		InfectPile.add( new Khartoum(0,0,0,0,0));
		InfectPile.add( new Algiers(0,0,0,0,0));
		InfectPile.add( new Istanbul(0,0,0,0,0));
		InfectPile.add( new Cairo(0,0,0,0,0));
		InfectPile.add( new Moscow(0,0,0,0,0));
		InfectPile.add( new Baghdad(0,0,0,0,0));
		InfectPile.add( new Tehran(0,0,0,0,0));
		InfectPile.add( new Riyadh(0,0,0,0,0));
		InfectPile.add( new Karachi(0,0,0,0,0));
		InfectPile.add( new Mumbai(0,0,0,0,0));
		InfectPile.add( new Delhi(0,0,0,0,0));
		InfectPile.add( new Chennai(0,0,0,0,0));
		InfectPile.add( new Kolkata(0,0,0,0,0));
		InfectPile.add( new Bangkok(0,0,0,0,0));
		InfectPile.add( new Jakarta(0,0,0,0,0));
		InfectPile.add( new HoChiMinhCity(0,0,0,0,0));
		InfectPile.add( new HongKong(0,0,0,0,0));
		InfectPile.add( new Shanghai(0,0,0,0,0));
		InfectPile.add( new Beijing(0,0,0,0,0));
		InfectPile.add( new Seoul(0,0,0,0,0));
		InfectPile.add( new Tokyo(0,0,0,0,0));
		InfectPile.add( new Osaka(0,0,0,0,0));
		InfectPile.add( new Taipei(0,0,0,0,0));
		InfectPile.add( new Manila(0,0,0,0,0));
		InfectPile.add( new Sydney(0,0,0,0,0));
	}

	//getters and setters
	public ArrayList<City> getInfectPile() {return InfectPile;	}

	public void setInfectPile(ArrayList<City> infectPile) {InfectPile = infectPile;}

	public ArrayList<City> getInfectDiscardPile() {	return InfectDiscardPile;}

	public void setInfectDiscardPile(ArrayList<City> infectDiscardPile) {
		InfectDiscardPile = infectDiscardPile;
	}

}

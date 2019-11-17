package Pandemic.deck;

import java.util.ArrayList;
import Pandemic.cities.*;


public class PlayerDeck {

	public ArrayList<Object> PlayerPile = new ArrayList<>();
	public ArrayList<Object> PlayerDiscardPile = new ArrayList<>();
	public boolean isEpidemic 			= true;
	

	//PlayerDeck with 48 cities and 4 epidemic cards
	public PlayerDeck(){		
		//add 4-6 epidemic cards and 5 event cards
		PlayerPile.add( new SanFransisco(0,0,0,0,0));
		PlayerPile.add( new Chicago(0,0,0,0,0));
		PlayerPile.add( new Atlanta(0,0,0,0,0));
		PlayerPile.add( new Montreal(0,0,0,0,0));
		PlayerPile.add( new NewYork(0,0,0,0,0));
		PlayerPile.add( new Washington(0,0,0,0,0));
		PlayerPile.add( new Madrid(0,0,0,0,0)) ;
		PlayerPile.add( new London(0,0,0,0,0));
		PlayerPile.add( new Paris(0,0,0,0,0));
		PlayerPile.add( new Essen(0,0,0,0,0));
		PlayerPile.add( new Milan(0,0,0,0,0));		
		PlayerPile.add( new StPetersburg(0,0,0,0,0));
		PlayerPile.add( new LosAngeles(0,0,0,0,0));
		PlayerPile.add( new MexicoCity(0,0,0,0,0));
		PlayerPile.add( new Miami(0,0,0,0,0));
		PlayerPile.add( isEpidemic);
		PlayerPile.add( new Bogota(0,0,0,0,0));
		PlayerPile.add( new Lima(0,0,0,0,0));
		PlayerPile.add( new Santiago(0,0,0,0,0));
		PlayerPile.add( new BuenosAires(0,0,0,0,0));
		PlayerPile.add( new SaoPaulo(0,0,0,0,0));
		PlayerPile.add( new Lagos(0,0,0,0,0));
		PlayerPile.add( new Kinshasa(0,0,0,0,0));
		PlayerPile.add( new Johannesburg(0,0,0,0,0));
		PlayerPile.add( new Khartoum(0,0,0,0,0));
		PlayerPile.add( new Algiers(0,0,0,0,0));
		PlayerPile.add( new Istanbul(0,0,0,0,0));
		PlayerPile.add( new Cairo(0,0,0,0,0));
		PlayerPile.add( new Moscow(0,0,0,0,0));
		PlayerPile.add( new Baghdad(0,0,0,0,0));
		PlayerPile.add( new Tehran(0,0,0,0,0));
		PlayerPile.add( new Riyadh(0,0,0,0,0));
		PlayerPile.add( new Karachi(0,0,0,0,0));
		PlayerPile.add( isEpidemic);
		PlayerPile.add( new Mumbai(0,0,0,0,0));
		PlayerPile.add( new Delhi(0,0,0,0,0));
		PlayerPile.add( new Chennai(0,0,0,0,0));
		PlayerPile.add( new Kolkata(0,0,0,0,0));
		PlayerPile.add( isEpidemic);
		PlayerPile.add( new Bangkok(0,0,0,0,0));
		PlayerPile.add( new Jakarta(0,0,0,0,0));
		PlayerPile.add( new HoChiMinhCity(0,0,0,0,0));
		PlayerPile.add( new HongKong(0,0,0,0,0));
		PlayerPile.add( new Shanghai(0,0,0,0,0));
		PlayerPile.add( new Beijing(0,0,0,0,0));
		PlayerPile.add( new Seoul(0,0,0,0,0));
		PlayerPile.add( new Tokyo(0,0,0,0,0));
		PlayerPile.add( new Osaka(0,0,0,0,0));
		PlayerPile.add( new Taipei(0,0,0,0,0));
		PlayerPile.add( new Manila(0,0,0,0,0));
		PlayerPile.add( isEpidemic);
		PlayerPile.add( new Sydney(0,0,0,0,0));
	}


	//setters and getters
	public ArrayList<Object> getPlayerPile() {return PlayerPile;}

	public void setPlayerPile(ArrayList<Object> playerPile) {PlayerPile = playerPile;}

	public ArrayList<Object> getPlayerDiscardPile() {return PlayerDiscardPile;}

	public void setPlayerDiscardPile(ArrayList<Object> playerDiscardPile) {
		PlayerDiscardPile = playerDiscardPile;
	}
	
}

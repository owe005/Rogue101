package inf101.rogue101.game;

import inf101.rogue101.objects.*;

public class ItemFactory {

	public static IItem createItem(char symbol) {
		switch(symbol) {
		case '#':
			return new Wall();
		case 'R':
			return new Rabbit();
		case 'C':
			return new Carrot();
		case '@':
			return new Player();
		case 'S':
			return new Spider();
		case 'A':
			return Amulet.getInstance();
		case '*':
			return new Portal();
			
			//Oppg. 3.1 I likhet med de som allerede er lagd så har jeg følgt mønsteret.
		case '>':
			return new ArrowPointer();
		case 'B':
			return new Bomb();
		case 'M':
			return new FinalBoss();
		case 'Z':
			return new Pistol();
		case 'G':
			return new Gold();
		case '.':
			return new Dust();
		case ' ':
			//End
		default : 	
			throw new IllegalArgumentException("createItem: Don't know how to create a '" + symbol + "'");
		}
	}
}

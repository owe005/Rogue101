package inf101.rogue101.objects;


import java.util.Collections;
import java.util.List;

import inf101.gfx.textmode.Printer;
import inf101.grid.GridDirection;
import inf101.rogue101.game.IGameView;
import javafx.scene.paint.Color;

/**
 * Kaniner i spillet Rogue 101. 
 * Kaniner hopper rundt i labyrinten på jakt etter gulrøtter. 
 * De har god luktesans og kan lukte gulrøtter på lang avstand. 
 * 
 * De forbrenner energi raskt og må være effektiv 
 * 
 * @author Knut Anders Stokke
 * @author Martin Vatshelle
 *
 */

public class Rabbit implements IActor {
	/**
	 * char representation of this type 
	 */
	public static final char SYMBOL = 'R';
	private int hp = getMaxHealth();

	@Override
	public void doTurn(IGameView game) {
		boolean isHungry = getMaxHealth()-getCurrentHealth()>2;
		if(isHungry) {
			boolean gotFood = eatIfPossible(game);
			if(gotFood) {
				//Rabbit is full and prefers to rest
				return;
			}
		}
		
		List<IItem> carrots = game.getNearbyItems(2); //henter nearbyitems inn i en liste carrots. nearbyitems er 2, visionfactor er 4.
		
		GridDirection dir = selectMove(game); //variable dir brukes for å select move
		for (IItem item : carrots) //for loop i carrots
			if(item instanceof Carrot) //hvis item er instance of Carrot
				dir = game.getDirectionTo(item); //then add direction of item to dir var
				
		performMove(game,dir); //then move there.
	}

	/**
	 * This method selects which move the Rabbit want to make.
	 */
	
	
	//Oppg. 2.4
	private GridDirection selectMove(IGameView game) {		
		for(GridDirection dir : GridDirection.EIGHT_DIRECTIONS) { //For loop i de åtte retningene som er lov i gå i.
			if(game.containsItem(dir, Carrot.class)) { //Hvis det er en carrot der, så går den dit.
				return dir;
			}
			if(game.containsItem(dir, Spider.class)) { //Hvis det er en edderkopp der, går den dit og
				game.attack(dir); //Angriper edderkoppen (instakill)
				
			}
		}
		List <GridDirection> PossibleMoves = game.getPossibleMoves(); //Hvis ingen av delene, så velger et tilfeldig lovlig move.
		Collections.shuffle(PossibleMoves); 
		return PossibleMoves.get(0);
	}
	
	
	
	/**
	 * Burns one round of energy
	 * Rabbits only burn energy if they move, not when laying still.
	 */
	private void burnEnergy() {
		hp--;
	}

	/**
	 * Performs a move
	 * Every time a Rabbit moves it burns energy
	 * GridDirection.CENTER means the Rabbit is resting and not burning energy
	 * 
	 * @param game
	 */
	private void performMove(IGameView game, GridDirection dir) {
		if (!dir.equals(GridDirection.CENTER)) {
			burnEnergy();
			boolean moved = game.move(dir);
			if(!moved) {
				game.displayMessage("Rabbit wasted energy on move");
			}
		}
	}

	/**
	 * Eats carrot if any exist at current location
	 * 
	 * @param game
	 *            The game the object exists in
	 * @return true if it spend the turn eating
	 */
	private boolean eatIfPossible(IGameView game) {
		for (IItem item : game.getLocalNonActorItems()) {
			if (item instanceof Carrot) {
				System.out.println("found carrot!");
				int eaten = item.handleDamage(Math.min(5, getMaxHealth()-getCurrentHealth()));
				if (eaten > 0) {
					System.out.println("ate carrot worth " + eaten + "!");
					hp += eaten;
					game.displayMessage("You hear a faint crunching (" + getLongName() + " eats " + item.getArticle()
							+ " " + item.getLongName() + ")");
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int getAttack() {
		return 50;
	}

	@Override
	public int getCurrentHealth() {
		return hp;
	}

	@Override
	public int getDamage() {
		return 50;
	}

	@Override
	public int getDefence() {
		return 50;
	}

	@Override
	public int getMaxHealth() {
		return 50;
	}

	@Override
	public String getShortName() {
		return getLongName();
	}

	public String getLongName() {
		return "rabbit";
	}

	@Override
	public int getSize() {
		return 4;
	}

	@Override
	public String getGraphicTextSymbol() {
		return hp > 0 ? "" + SYMBOL : "¤";
	}
	
	@Override
	public String getEmoji() {
		return hp > 0 ? Printer.coloured("🐇", Color.MAGENTA) : "💀"; // 🐇 MAGENTA
	}

	@Override
	public int handleDamage(int amount) {
		amount -= Math.min(amount, getDefence());
		int damage = Math.min(amount, hp);
		hp -= damage;
		return damage;
	}
	
	@Override
	public char getSymbol() {
		return SYMBOL;
	}
}

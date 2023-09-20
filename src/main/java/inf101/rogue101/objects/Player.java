package inf101.rogue101.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import inf101.gfx.textmode.Printer;
import inf101.grid.GridDirection;
import inf101.rogue101.game.IGameView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
/**
 * En spiller i Rogue 101 
 * 
 * Spilleren navigerer labyrinten og slåss med monster. For å komme seg ut 
 * og vinne spille må spilleren gå gjennom portalen; for å åpne portalen 
 * må den finne amuletten og bære den med seg. 
 * 
 * På veien kan den plukke opp gull og slåss med monster
 * 
 * @author Anna Eilertsen - anna.eilertsen@uib.no
 *
 */
public class Player implements IPlayer {
	/**
	 * char representation of this type 
	 */
	public static final char SYMBOL = '@';
	private static final int MAXHEALTH = 100;
	private int attack;
	private int defence;
	private int damage;
	private int hp;
	private String name;
	private List<IItem> Inventory; //Player actor har et inventory.

	public Player() {
		attack = 10;
		defence = 2;
		damage = 3;
		hp = Player.MAXHEALTH;
		name = System.getProperty("user.name");
		Inventory = new ArrayList<>(); //Inventory er en ny ArrayList som skal brukes for å oppbevare items (inventory)
	}

	@Override
	public int getAttack() {
		return attack;
	}

	@Override
	public int getDamage() {
		return damage;
	}

	@Override
	public int getCurrentHealth() {
		return hp;
	}

	@Override
	public int getDefence() {
		return defence;
	}

	@Override
	public int getMaxHealth() {
		return Player.MAXHEALTH;
	}

	@Override
	public String getShortName() {
		return getLongName();
	}
	
	@Override
	public String getLongName() {
		return name;
	}

	@Override
	public int getSize() {
		return 6;
	}

	@Override
	public String getGraphicTextSymbol() {
			return "" + SYMBOL;
	}
	
	@Override
	public String getEmoji() {
		return hp > 0 ? Printer.coloured("👀", Color.RED) : "⚰️"; //RED
	}

	@Override
	public int handleDamage(int amount) {
		amount = Math.max(0, amount - defence);
		amount = Math.min(hp + 1, amount);
		hp -= amount;
		return amount;
	}

	@Override
	public void keyPressed(IGameView game, KeyCode key) {
		System.err.println("Player moves");
		switch (key) {
		case LEFT:
			tryToMove(game, GridDirection.WEST);
			break;
		case RIGHT:
			tryToMove(game, GridDirection.EAST);
			break;
		case UP:
			tryToMove(game, GridDirection.NORTH);
			break;
		case DOWN:
			tryToMove(game, GridDirection.SOUTH);
			break;
			
		case A:
			tryToMove(game, GridDirection.WEST);
			break;
		case D:
			tryToMove(game, GridDirection.EAST);
			break;
		case W:
			tryToMove(game, GridDirection.NORTH);
			break;
		case S:
			tryToMove(game, GridDirection.SOUTH);
			break;
		case PLUS:
			pickUp(game);
			break;
		case MINUS:
			drop(game);
			break;
		default:
			System.err.printf("Illegal key pressed. Key: %s", key);
		}
		showStatus(game);
	}

	private void tryToMove(IGameView game, GridDirection dir) {
		if (game.canGo(dir)) {
			game.displayDebug("Moving.");
			game.move(dir);
		} 
		else {
			if(game.attack(dir))
				game.displayDebug("Victory!");
			else
				game.displayDebug("Ouch! Can't go there.");
		}
	}

	//Oppg. 6.3
	private void showStatus(IGameView game) {

		for(int i = 0; i < Inventory.size(); i++) { //loop over the entire inventory
			IItem item = Inventory.get(i);
			game.displayMessage("Player is carrying " + item.getShortName()); //Then display current held items to player.
		}
		game.displayMessage("Player has " + this.hp + " hp left");
	}
	
	//Oppg. 6.1
	private void pickUp(IGameView game) {  
		List<IItem> items = game.getLocalNonActorItems(); //Henter items fra posisjonen.
		if(items.size() == 0) { //Hvis det ikke er noen items here så får spilleren
			game.displayMessage("No item here"); //Denne meldingen
			return;
		}
            Collections.sort(items,new IItemComparator()); //Sorterer items som i tidligere oppgaven.
            Optional<IItem> found = game.pickUp(items.get(items.size()-1)); //Spilleren plukker opp item
            if(found.isPresent()) //Hvis det er et item der
            	Inventory.add(found.get()); //Item legges til i Inventory ArrayListen
                game.displayMessage("Picked up "+found.get().getLongName()); //Spilleren får melding om det den har plukket opp.
	}
	
	//Oppg. 6.2
	private void drop(IGameView game) {	
		IItem FItem = Inventory.get(0); //Definerer FItem som det første item i ArrayList Inventory
		Inventory.remove(0); //Deretter fjernes det definerte item
		game.drop(FItem); //Metoden game.drop dropper dette item der spilleren står.
		
		game.displayMessage("Player has dropped " + FItem.getLongName()); //Spilleren får melding om at item er droppet og hvilket item det er.
	}

	@Override
	public void doTurn(IGameView game) {
	}
	
	@Override 
	public boolean isDestroyed() {
		return false; //Even when dead, the player should remain on the map
	}

    @Override
    public boolean hasItem(IItem item) {
        if(Inventory.contains(item)) {
            return true;
        } else {
            return false;
        }
    }
	
	@Override
	public char getSymbol() {
		return SYMBOL;
	}
}

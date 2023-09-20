package inf101.rogue101.objects;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import inf101.grid.GridDirection;
import inf101.rogue101.game.IGameView;

public class Bomb implements IActor {
	/**
	 * char representation of this type 
	 */
	public static final char SYMBOL = 'B';
	public static Bomb first = null;
	final static int MAXHEALTH = 10;
	private int hp;
	private int defence;
	private int attack;
	private int damage;
	private GridDirection lastDir;

	public Bomb() {
		hp = Bomb.MAXHEALTH;
		defence = 1; 
		damage = 25;
		attack = 25; 
		lastDir = GridDirection.NORTHEAST;
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
		return Bomb.MAXHEALTH;
	}

	@Override
	public String getShortName() {
		return "Bomb";
	}

	@Override
	public String getLongName() {
		return "Bomb";
	}

	@Override
	public int getSize() {
		return 2;
	}
	
	@Override
	public String getEmoji() {
		return "💣";
	}

	@Override
	public int handleDamage(int amount) {
		return 0;
	}


	@Override
	public void doTurn(IGameView game) {

		GridDirection dir = selectMove(game);
		performMove(game,dir);
	}

	
	private void performMove(IGameView game, GridDirection dir) {
		if (!dir.equals(GridDirection.CENTER)) {
			game.move(dir);
		}
	}
	
	
	private GridDirection selectMove(IGameView game) {		
		for(GridDirection dir : GridDirection.EIGHT_DIRECTIONS) {
			if(game.containsItem(dir, Player.class)) { 
			game.attack(dir);
			}
		}
		
		List <GridDirection> dir = game.getPossibleMoves(); 
		Collections.shuffle(dir); 
		return dir.get(0);
	}
		

	@Override
	public int getAttack() {
		return this.attack;
	}

	@Override
	public int getDamage() {
		return this.damage;
	}
	
	@Override
	public char getSymbol() {
		return SYMBOL;
	}
}

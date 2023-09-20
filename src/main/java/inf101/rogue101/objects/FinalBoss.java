package inf101.rogue101.objects;

import java.util.Collections;
import java.util.List;
import inf101.grid.GridDirection;
import inf101.rogue101.game.IGameView;

public class FinalBoss implements IActor {
	/**
	 * char representation of this type 
	 */
	public static final char SYMBOL = 'M';
	public static FinalBoss first = null;
	final static int MAXHEALTH = 10;
	private int hp;
	private int defence;
	private int attack;
	private int damage;

	public FinalBoss() {
		hp = FinalBoss.MAXHEALTH;
		defence = 100; //Impossible to kill
		damage = 10000;
		attack = 10000; //You are better off dodging the monster in order to get to the portal.
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
	public int getCurrentHealth() {
		return hp;
	}

	@Override
	public int getDefence() {
		return defence;
	}

	@Override
	public int getMaxHealth() {
		return FinalBoss.MAXHEALTH;
	}

	@Override
	public String getShortName() {
		return "Boss";
	}

	@Override
	public String getLongName() {
		return "FinalBoss";
	}

	@Override
	public int getSize() {
		return 10;
	}
	
	@Override
	public String getEmoji() {
		return "👾";
	}

	@Override
	public int handleDamage(int amount) {
		amount -= Math.min(amount, getDefence());
		int damage = Math.min(amount, hp);
		hp -= damage;
		return damage;
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

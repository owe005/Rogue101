package inf101.rogue101.objects;

import inf101.gfx.textmode.Printer;
import javafx.scene.paint.Color;

public class Pistol implements IItem {
	
	
	public static final char SYMBOL = 'Z';
	private int hp = getMaxHealth();
	
	
	@Override
	public int getCurrentHealth() {
		// TODO Auto-generated method stub
		return hp;
	}

	@Override
	public int getDefence() {
		return 10000;
	}
	
	@Override
	public int getMaxHealth() {
		return 10000;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 2;
	}
	
	@Override
	public String getEmoji() {
		return Printer.coloured("🔫", Color.BLACK);
	}

	@Override
	public int handleDamage(int amount) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char getSymbol() {
		// TODO Auto-generated method stub
		return SYMBOL;
	}


	@Override
	public String getShortName() {
		return "Pistol";
	}

	@Override
	public String getLongName() {
		return "Exotic Pistol";
	}
}
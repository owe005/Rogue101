//Oppg. 1.5 Opprettet en class for gull. Symbolet blir G, og jeg har kalt getShortName for "Gold", og veldig kreativt men getLongName for "Shiny Gold Coins"
package inf101.rogue101.objects;

import inf101.gfx.textmode.Printer;
import javafx.scene.paint.Color;

public class Gold implements IItem {

	public static final char SYMBOL = 'G';
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
	public String getLongName() {
		// TODO Auto-generated method stub
		return "Bitcoin";
	}

	@Override
	public String getShortName() {
		// TODO Auto-generated method stub
		return "BTC";
	}

	@Override
	public String getEmoji() {
		return Printer.coloured("₿", Color.GOLD);
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 2;
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
}

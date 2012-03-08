package pokemon.pokedex;

import java.util.ArrayList;
import java.util.List;

public abstract class Pokemon {

	protected String name;
	protected int level;
	protected int maxHP;
	protected int currentHP;
	protected List<Attacke> attackList = new ArrayList<Attacke>();
	
	public Pokemon(String pName, int pLevel, int pMaxHP) {
		this.name = pName;
		this.level = pLevel;
		this.maxHP = pMaxHP;
		this.currentHP = pMaxHP;
	}
	
	public void learnAttacke(Attacke pAttacke) {
		this.attackList.add(pAttacke);
	}
	
	public void heal(int pHP) {
		this.currentHP += pHP;
		if (this.currentHP>this.maxHP)
			this.currentHP = this.maxHP;
	}
	
	public void hurt(int pHP) {
		this.currentHP -= pHP;
		if (this.currentHP<0)
			this.currentHP = 0;
	}
	
	public void levelUp() {
		this.level += 1;
	}
	
	public String toString() {
		
		String str = this.name +":\n" +
				"lvl " + this.level + "  -  " +
				this.currentHP + "/" + this.maxHP + "\n";
		
		for (Attacke attacke : this.attackList)
			str += attacke + "\n";
		
		return str;
	}
	
	public abstract void attack(int pNr,Pokemon pPokemon);
	
	
}

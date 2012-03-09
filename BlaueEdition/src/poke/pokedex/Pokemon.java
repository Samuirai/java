package poke.pokedex;

import java.util.ArrayList;
import java.util.List;

import poke.tm.Attacke;

public abstract class Pokemon {

	protected int level;
	protected int maxHP;
	protected int currentHP;
	protected String name;
	protected List<Attacke> angriffsListe = new ArrayList<Attacke>();

	public Pokemon(String pName, int pHP) {
		this.name = pName;
		this.maxHP = pHP;
		this.currentHP = pHP;
		this.level = 1;
	}
	
	public void learn(Attacke pAtt) {
		angriffsListe.add(pAtt);
	}

	public int getLevel() {
		return level;
	}

	public int getMaxHP() {
		return maxHP;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public void levelUp() {
		this.level++;
	}

	public abstract void angriff(int pNr,Pokemon pZiel);

	public void damage(int pDmg) {
		this.currentHP -= pDmg;
		if (this.currentHP < 0)
			this.currentHP = 0;
	}

	public void heal(int pHeal) {
		this.currentHP += pHeal;
		if (this.currentHP > this.maxHP)
			this.currentHP = this.maxHP;
	}

	public void giveNickname(String pName) {
		this.name = pName;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		String info = this.name + " (" + this.level + ") " + this.currentHP + "/"
				+ this.maxHP;
		info += "\n----------------\n";
		for(Attacke a : angriffsListe) {
			info += a + "\n";
		}
		return info;
	}

}

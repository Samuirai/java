package pokemon.pokedex;

public class Attacke {
	String name;
	int dmg;
	
	public Attacke(String pName, int pDmg) {
		this.name = pName;
		this.dmg = pDmg;
	}
	
	public String toString() {
		return this.name + " (" + this.dmg + ")";
	}
	
	public int getDmg() {
		return this.dmg;
	}
}

package poke.tm;

public class Attacke {

	private int dmg;
	private String name;
	
	public Attacke(String pName, int pDmg) {
		this.dmg = pDmg;
		this.name = pName;
	}
	
	public int getDmg() {
		return this.dmg;
	}
	
	public String toString() {
		return this.dmg + " | " + this.name;
	}
	
}

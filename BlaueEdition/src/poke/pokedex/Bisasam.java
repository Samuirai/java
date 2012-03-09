package poke.pokedex;

public class Bisasam extends Pokemon {

	public Bisasam(int pHP) {
		super("Bisasam", pHP);
	}

	public void levelUp() {
		this.maxHP += 20;
		this.currentHP += 20;
		super.levelUp();
	}
	
	
	@Override
	public void angriff(int pNr,Pokemon pZiel) {
		pZiel.damage(this.angriffsListe.get(pNr).getDmg()+10);
		this.heal(10);
	}

}

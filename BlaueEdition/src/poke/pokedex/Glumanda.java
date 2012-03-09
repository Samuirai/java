package poke.pokedex;

public class Glumanda extends Pokemon {

	public Glumanda(int pHP) {
		super("Glumanda", pHP);
	}
	
	public void levelUp() {
		this.maxHP += 10;
		this.currentHP += 10;
		super.levelUp();
	}
	
	@Override
	public void angriff(int pNr,Pokemon pZiel) {
		pZiel.damage(this.angriffsListe.get(pNr).getDmg());
	}

}

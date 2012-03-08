package pokemon.pokedex.pokemon;

import pokemon.pokedex.Pokemon;

public class Glumanda extends Pokemon {
	
	public Glumanda(int pLevel, int pMaxHP) {
		super("Glumanda", pLevel, pMaxHP);
	}

	@Override
	public void attack(int pNr, Pokemon pPokemon) {
		pPokemon.hurt(this.attackList.get(pNr).getDmg()+2);
	}

	public void levelUp() {
		this.maxHP += 5;
		this.currentHP += 5;
		super.levelUp();
	}

}

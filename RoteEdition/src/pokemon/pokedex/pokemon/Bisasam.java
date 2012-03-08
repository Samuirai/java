package pokemon.pokedex.pokemon;

import pokemon.pokedex.Pokemon;

public class Bisasam extends Pokemon {

	public Bisasam(int pLevel, int pMaxHP) {
		super("Bisasam", pLevel, pMaxHP);
	}

	@Override
	public void attack(int pNr, Pokemon pPokemon) {
		pPokemon.hurt(this.attackList.get(pNr).getDmg());
	}

	public void levelUp() {
		this.maxHP += 10;
		this.currentHP += 10;
		super.levelUp();
	}

}

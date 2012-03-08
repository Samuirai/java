package pokemon.pokedex.pokemon;

import pokemon.pokedex.*;

public class Mew extends Pokemon {

	public Mew(int pLevel, int pMaxHP) {
		super("Mew", pLevel, pMaxHP);
	}

	@Override
	public void attack(int pNr, Pokemon pPokemon) {
		pPokemon.hurt(this.attackList.get(pNr).getDmg()+5);
	}

	public void levelUp() {
		this.maxHP += 15;
		this.currentHP += 15;
		super.levelUp();
	}

	
}

package pokemon.spiel;

import pokemon.pokedex.Attacke;
import pokemon.pokedex.Pokemon;
import pokemon.pokedex.pokemon.Bisasam;
import pokemon.pokedex.pokemon.Glumanda;
import pokemon.pokedex.pokemon.Mew;

public class RoteEdition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Team teamAsh = new Team();
		
		Pokemon bisasam = new Bisasam(5, 50);
		teamAsh.addPokemon(bisasam);
		Pokemon mew = new Mew(7, 75);
		teamAsh.addPokemon(mew);
		
		Team teamGary = new Team();
		
		Pokemon glumanda = new Glumanda(6, 45);
		teamGary.addPokemon(glumanda);
		
		Attacke tackle = new Attacke("Tackle", 7);
		Attacke psy_strahl = new Attacke("Psy Strahl", 23);
		
		bisasam.learnAttacke(tackle);
		glumanda.learnAttacke(tackle);
		mew.learnAttacke(tackle);
		mew.learnAttacke(psy_strahl);
		

		System.out.println("Ash:\n--------------\n" + teamAsh);
		System.out.println("Gary:\n--------------\n" + teamGary);
		
		teamAsh.getPokemon(0).attack(0, teamGary.getPokemon(0));
		
		System.out.println("Ash:\n--------------\n" + teamAsh);
		System.out.println("Gary:\n--------------\n" + teamGary);

		teamAsh.getPokemon(1).levelUp();
		System.out.println("Ash:\n--------------\n" + teamAsh);
		teamAsh.getPokemon(1).levelUp();
		System.out.println("Ash:\n--------------\n" + teamAsh);
		teamAsh.getPokemon(1).levelUp();
		System.out.println("Ash:\n--------------\n" + teamAsh);
		teamAsh.getPokemon(1).levelUp();
		System.out.println("Ash:\n--------------\n" + teamAsh);
		
	}

}

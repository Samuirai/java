package pokemon.spiel;
import java.util.ArrayList;
import java.util.List;

import pokemon.pokedex.*;

public class Team {

	private List<Pokemon> pokemonTeam = new ArrayList<Pokemon>();
	
	Team() {
		
	}
	
	Team(List<Pokemon> pPokemonTeam) {
		this.pokemonTeam = pPokemonTeam;
	}
	
	public int getTeamSize() {
		return pokemonTeam.size();
	}
	
	public Pokemon getPokemon(int Nr) {
		return pokemonTeam.get(Nr);
	}
	
	public void addPokemon(Pokemon pPokemon){
		pokemonTeam.add(pPokemon);
	}
	
	public void removePokemon(Pokemon pPokemon) {
		pokemonTeam.remove(pPokemon);
	}
	
	public void removePokemon(int Nr) {
		pokemonTeam.remove(Nr);
	}
	
	public String toString() {
		String str = "";
		for (Pokemon pokemon : this.pokemonTeam)
	        str += pokemon + "\n";
		return str;
	}
}

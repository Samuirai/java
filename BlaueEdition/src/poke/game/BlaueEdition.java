package poke.game;

import poke.pokedex.Bisasam;
import poke.pokedex.Glumanda;
import poke.pokedex.Pokemon;
import poke.tm.Attacke;

public class BlaueEdition {

	public static void main(String[] args) {
		
		Pokemon asd = new Glumanda(50);
		Pokemon lol = new Bisasam(45);
		Attacke tackle = new Attacke("Tackle",7);
		Attacke heuler = new Attacke("Heuler",0);
		Attacke solarstrahl = new Attacke("Solarstrahl",9001);
		
		System.out.println(asd);
		System.out.println(lol);
		
		asd.learn(tackle);
		asd.learn(heuler);
		asd.levelUp();
		asd.giveNickname("LoL");
		lol.learn(solarstrahl);
		
		System.out.println(asd);
		System.out.println(lol);
		
		asd.angriff(1, lol);
		
		System.out.println(asd);
		System.out.println(lol);
		
		lol.angriff(0, asd);
		
		System.out.println(asd);
		System.out.println(lol);
		
	}

}

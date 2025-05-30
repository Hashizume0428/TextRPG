package rpg;

import rpg.area.Town;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.hero.job.Priest;
import rpg.character.hero.job.Sorcerer;
import rpg.character.hero.job.Warrior;

public class Main extends Object {
	public Main() {}
	
	public static void main(String[] args) {
		Hero[] heros = {
				new Warrior("a1"),
				new Sorcerer("a2"),
				new Priest("a3")	
		};
		HeroParty hpty = new HeroParty(heros);
		
		Town town = new Town();
		town.access(hpty);
		
	}
}

package rpg;

import rpg.character.AbstractCharacter;
import rpg.character.hero.HeroParty;
import rpg.character.monster.MonsterParty;

public class BattleField extends Object {
	public BattleField() {
		
	}
	public static String battle(HeroParty heros, MonsterParty monsters) {
		heros.init();
		for (AbstractCharacter c : monsters.getMembers()) {
			System.out.print(c.getName());
		}
		System.out.println("があらわれた");
		System.out.println();
		while (true) {
			System.out.println("勇者のターン");
			heros.printPartyStatus();
			System.out.println();
			String flg = heros.turn(monsters);
			if(flg.equals("BEAT")){
				return "WIN";
			}else if(flg.equals("ESCAPE")){
				return "ESCAPE";
			}
			System.out.println("モンスターのターン");
			flg = monsters.turn(heros);
			System.out.println();
			if(flg.equals("BEAT")){
				return "LOSE";
			}
		}
	}

}

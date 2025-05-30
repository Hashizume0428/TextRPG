package rpg.character.monster.monster;

import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;

public class DemonParty{

	public DemonParty() {}
	public MonsterParty makeParty() {
		Monster ms[] = {
				new Demon(0),
				new Demon(1),
				new Demon(2)
		};
		MonsterParty m = new MonsterParty(ms);
		
		return m;
	}

}

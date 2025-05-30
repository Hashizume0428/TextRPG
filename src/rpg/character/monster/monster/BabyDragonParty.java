package rpg.character.monster.monster;

import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;

public class BabyDragonParty{

	public BabyDragonParty() {}
	public MonsterParty makeParty() {
		Monster ms[] = {
				new BabyDragon(0),
				new BabyDragon(1),
				new BabyDragon(2)
		};
		MonsterParty m = new MonsterParty(ms);
		
		return m;
	}

}

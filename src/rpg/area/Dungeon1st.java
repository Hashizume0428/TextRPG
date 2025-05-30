package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;
import rpg.character.monster.monster.BabyDragonParty;
import rpg.character.monster.monster.Dragon;

public class Dungeon1st extends Dungeon {
	//コンストラクタ
	public Dungeon1st() {
		super.setName("ドラゴンの巣窟");
		super.floorNum = 1;
		super.encountCounter = 0;
	}
	
	protected Monster nextBoss() {
		return new Dragon();
	}
	
	protected Area nextArea() {
		return new Dungeon2nd();
	}
	protected  MonsterParty nextMonsterParty() {
		BabyDragonParty p = new BabyDragonParty();
		return p.makeParty();
	}
	
}

package rpg.area;

import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;
import rpg.character.monster.monster.DemonParty;
import rpg.character.monster.monster.KingDemon;

public class Dungeon2nd extends Dungeon {
	//コンストラクタ
	public Dungeon2nd() {
		super.setName("デーモンの間");
		super.floorNum = 1;
		super.encountCounter = 0;
	}
	
	protected Monster nextBoss() {
		return new KingDemon();
	}
	
	protected Area nextArea() {
		return new DungeonCLEAR();//ダンジョンは二階層までなので、クリアに移動
	}
	protected  MonsterParty nextMonsterParty() {
		DemonParty p = new DemonParty();
		return p.makeParty();
	}
}

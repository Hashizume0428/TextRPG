package rpg.area;

import rpg.ScanCommand;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;
import rpg.character.monster.monster.Dragon;

public class DungeonGAMEOVER extends Dungeon {
	//コンストラクタ
	public DungeonGAMEOVER() {
		System.out.println("GameOver");
	}
	
	public Area access(HeroParty party) {
		System.out.println("はじまりの町へ戻る");
		System.out.println("1:再び探索する　2：はじまりの町へ戻る");
		int nextMove = ScanCommand.scan();
		if (nextMove == 1) {
			Area nextdungeon = nextArea();
			nextdungeon.access(party);
			return nextdungeon;
		} else if (nextMove == 2) {
			Town town = new Town();
			town.access(party);
			return town;
			}
		return null;
	}
	protected Monster nextBoss() {
		return new Dragon();
	}
	protected Area nextArea() {
		return new Dungeon1st();
	}
	protected  MonsterParty nextMonsterParty() {
		return null;
	}
}

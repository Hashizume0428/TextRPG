package rpg.area;

import java.util.Random;

import rpg.BattleField;
import rpg.ScanCommand;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;

public abstract class Dungeon extends Area {
	//フィールド
	protected int floorNum;
	protected int encountCounter;
	
	//コンストラクタ
	public Dungeon() {}
	
	protected abstract Monster nextBoss();
	protected abstract Area nextArea();
	protected abstract MonsterParty nextMonsterParty();
	public Area access(HeroParty party) {
		this.printArea();
		party.printPartyStatus();
		while (true) {
			System.out.println("どうしますか");
			System.out.println("1:探索する　2：はじまりの町へ戻る");
			int nextMove = ScanCommand.scan();
			if (nextMove == 1) {
				String result = this.explore(party);
				if (result.equals("WIN")) {
					Area nextdungeon = nextArea();
					nextdungeon.access(party);
					return nextdungeon;
				} else if (result.equals("LOSE")) {
					DungeonGAMEOVER GAMEOVER =  new DungeonGAMEOVER();
					GAMEOVER.access(party);
					return GAMEOVER;
					}
			} else if (nextMove == 2) {
				Town town = new Town();
				town.access(party);
				return town;
				}
		}
	}
	public String explore(HeroParty party) {
		String result;
		while (true) {
			Random random = new Random();
			int randomNum = random.nextInt(5);
			if ((randomNum == 0 && this.encountCounter > 1) || this.encountCounter > 3) {
				result = this.encountBoss(party);
				if(result.equals("ESCAPE")){
					continue;
				}
				return result;
			} else if (1 <= randomNum && randomNum <= 3) {
				result = this.encountMob(party);
				if(result.equals("LOSE")){
					return result;
				}else if(result.equals("ESCAPE")){
					continue;				}
				this.encountCounter += 1;
			} 
		}
	}
	public void printArea() {
		System.out.println("現在の場所は" + getName() + "です．");
	}
	private String encountMob(HeroParty party) {
		System.out.println("モンスターと遭遇した");
		String result = BattleField.battle(party, nextMonsterParty());
		this.printBattleResult(result,"戦い");
		return result;
	}
	private String encountBoss(HeroParty party) {
		System.out.println("ボスモンスターと遭遇した");
		Monster boss_ms[] = {this.nextBoss()};
		MonsterParty boss_mpty = new MonsterParty(boss_ms);
		String result = BattleField.battle(party, boss_mpty);
		for (Monster c : boss_ms) {
			this.printBattleResult(result, c.getName());
		}
		return result;
	}
	protected void printBattleResult(String result, String string) {
		if (result.equals("WIN")) {
			System.out.println("勇者たちは"+string+"に勝利した");
		} else if(result.equals("LOSE")){
			System.out.println("勇者たちは"+string+"に敗北した");
		} else if(result.equals("ESCAPE")){
			System.out.println("勇者たちは"+string+"から逃げ出した");
		}
	}
}

package rpg.area;

import rpg.character.AbstractCharacter;
import rpg.character.hero.Hero;
import rpg.character.hero.HeroParty;
import rpg.character.monster.Monster;
import rpg.character.monster.MonsterParty;

public class DungeonCLEAR extends Dungeon {
	public DungeonCLEAR() {}
	
	public Area access(HeroParty party) {
		System.out.println("ゲームクリア！！");
		System.out.println();
		try {
			Thread.sleep(1000);

			System.out.println("Cast");
			int i = 0;
			for (AbstractCharacter c : party.getMembers()) {
				Thread.sleep(1000);
				Hero hero = (Hero) c;
				System.out.println("ヒーロー"+i+"：" + c.getName() + "(" + hero.getJob() + ")");
				i++;
			}
			System.out.println();
			System.out.print("お  ");
			Thread.sleep(1000);
			System.out.print("わ  ");
			Thread.sleep(1000);
			System.out.println("り  ");
			System.exit(0);
			return null;

		} catch (InterruptedException e) {
			throw new Error();
		}
	}
	protected Monster nextBoss() {
		return null;
	}
	protected Area nextArea() {
		return null;
	}
	protected  MonsterParty nextMonsterParty() {
		return null;
	}
}

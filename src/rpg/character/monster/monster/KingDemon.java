package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class KingDemon extends BossMonster {
	//コンストラクタ
	public KingDemon() {
		super("デモンズゲイト", 100, 5);
	}
	public boolean special(AbstractParty enemies) {
		Random random = new Random();
		AbstractCharacter[] members = enemies.getMembers();
		System.out.println(this.getName()+"のデモンズゲイト，勇者全員に激しい嵐が襲いかかる");
		for (AbstractCharacter c : members) {
			if (!c.isDead() && !c.isEscaped()) {
				int randomAttack = random.nextInt(attack) + attack;
				int damage = c.gotDamage(randomAttack);
				
				System.out.println(c.getName() + "に" + damage + "のダメージ");
				System.out.println(c.getName() + "に" + this.gotHeal(damage) + "の回復");
				c.actionStatus();
			}
		}
		return true;
	}
}

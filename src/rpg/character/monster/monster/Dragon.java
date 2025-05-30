package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Dragon extends BossMonster {
	//コンストラクタ
	public Dragon() {
		super("RedDragon", 200, 30);
	}
	public boolean special(AbstractParty enemies) {
		Random random = new Random();
		AbstractCharacter[] members = enemies.getMembers();
		System.out.println(this.getName()+"の竜のいぶき，勇者全員に激しい嵐が襲いかかる");
		for (AbstractCharacter c : members) {
			if (!c.isDead() && !c.isEscaped()) {
				int randomAttack = random.nextInt(attack) + attack;
				int damage = c.gotDamage(randomAttack);
				System.out.println(c.getName() + "に" + damage + "のダメージ");
				c.actionStatus();
			}
		}
		return true;
	}
}

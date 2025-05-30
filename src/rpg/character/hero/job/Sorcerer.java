package rpg.character.hero.job;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Sorcerer extends AbstractSuperHero {
	
	//コンストラクタ
	public Sorcerer(String name) {
		super(name, 100, 15);
		super.job = "魔法使い";
	}
	
	public boolean special(AbstractParty targets) {
		Random random = new Random();
		AbstractCharacter[] members = targets.getMembers();
		System.out.println(getName() + "のファイア，敵全員が炎の渦に巻き込まれた");
		System.out.println();
		for (AbstractCharacter c : members) {
			if (!c.isDead() && !c.isEscaped()) {
				int randomAttack = random.nextInt(attack) + attack;
				int damage = c.gotDamage(randomAttack);
				c.actionStatus();
			}
		}
		System.out.println();
		return true;
	}
}

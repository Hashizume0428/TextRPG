package rpg.character.hero.job;

import java.util.Random;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Warrior extends AbstractSuperHero {
	
	//コンストラクタ
	public Warrior(String name) {
		super(name, 100, 30);
		super.job = "戦士";
	}
	
	public boolean special(AbstractParty targets) {
		AbstractCharacter targetCharacter = selectTarget(targets);
		if (targetCharacter.isDead()) {
			return false;
		}
		Random random = new Random();
		int randomAttack = 0;
		int damage;
		System.out.print(getName() + "のドラゴンキック，");
		if(targetCharacter.getName().equals("ドラゴン")){
			randomAttack = random.nextInt(attack) +attack + 30;
			damage = targetCharacter.gotDamage(randomAttack);
		} else {
			randomAttack = random.nextInt(attack) + attack;
			damage = targetCharacter.gotDamage(randomAttack);
		}
		System.out.println();
		return true;
	}
}

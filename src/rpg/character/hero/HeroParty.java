package rpg.character.hero;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class HeroParty extends AbstractParty{
	public HeroParty(AbstractCharacter[] heros) { super(heros);}
	
	public void rest() {
		for (AbstractCharacter m : this.getMembers()) {
			m.gotHeal(m.getMaxHp());
		}
	}
	public void printPartyStatus() {
		 for (AbstractCharacter c : this.getMembers()) {

			 Hero hero = (Hero) c;

			 this.printHeroStatus(hero);

			 }

			 System.out.println();
	}
	private void printHeroStatus(Hero hero) {

		 if (hero.getHp() > 0 && hero.isEscaped() == false) {

		 System.out.print(hero.getName() + "(" + hero.getJob() + "):" + hero.getHp() + " ");

		 } else if (hero.getHp() <= 0){

		 System.out.println(hero.getName() + "(" + hero.getJob() + "):死亡　");

		 }else if (hero.isEscaped()){

		 System.out.println(hero.getName() + "(" + hero.getJob() + "):逃亡　"); 

		 }

	}
	public boolean isEscapeAll() {
		int count = 0;
		for (AbstractCharacter m : this.getMembers()) {
			if (m.isEscaped() == false) { count++;}
		}
		if (count == 0) { return true;}
		else { return false;}
	}
	public void init() {
		for (AbstractCharacter m : this.getMembers()) {
			m.escaped = false;
		}
	}
}
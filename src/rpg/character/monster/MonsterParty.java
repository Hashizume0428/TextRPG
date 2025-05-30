package rpg.character.monster;

import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class MonsterParty extends AbstractParty{
	//コンストラクタ
	public MonsterParty(AbstractCharacter[] monsters) {
		super(monsters);
	}
	protected boolean isEscapeAll() {
		int count = 0;
		for (AbstractCharacter m : this.getMembers()) {
			if (m.isEscaped() == false) { count++;}
		}
		if (count == 0) { return true;}
		else { return false;}
	}

}
 
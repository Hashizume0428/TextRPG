package rpg.character;

public abstract class AbstractParty {
	private AbstractCharacter[] members;
	
	//コンストラクタ
	public AbstractParty(AbstractCharacter[] members) {
		this.members = members;
	}
	
	protected abstract boolean isEscapeAll();
	public boolean isAllDead() {
		int count = 0;
		for (AbstractCharacter m : this.members) {
			if (m.isDead() == false) { count++;}
		}
		if (count == 0) { return true;}
		else { return false;}
	}
	public String turn(AbstractParty enemies) {
		for (AbstractCharacter c : this.members) {
			if (!c.isDead() && !c.isEscaped()) {
				c.command(this, enemies);
				if (enemies.isAllDead()) {
					//System.out.println("BEAT");
					return "BEAT";
				}
				if (this.isEscapeAll()) {
					//System.out.println("ESCAPE");
					return "ESCAPE";
				}
			}
		}
		return "CONTINUE";
	}
	public AbstractCharacter[] getMembers() { return this.members;}
	
}
 
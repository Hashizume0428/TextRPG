package rpg.character.hero;

import rpg.ScanCommand;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Hero extends AbstractCharacter{
	protected String job;
	
	public Hero(String name, int hp, int attack) {
		super(name,  hp, attack);
		job = "勇者";
	}
	public void run() {
		super.escaped = true;
		System.out.print(getName());
		System.out.println("は逃げ出した");
	}
	public void rest() {
		gotHeal(30);
	}
	protected void command(AbstractParty allies, AbstractParty enemies) {
		;
	}
	public String getJob() { return this.job; }
	protected AbstractCharacter selectTarget(AbstractParty targets) {
		int length = targets.getMembers().length;
		int index = 1;
		for (AbstractCharacter c : targets.getMembers()) {
			if (c.isDead() == false) {
				System.out.print(index + ":" + c.getName() + " ");
			}
			index += 1;
		}
		System.out.println();
		int command = ScanCommand.scan();
		if (command < 1 || command > length) {
			System.out.println("もう一度選択してください。");
			selectTarget(targets);
		}
		return targets.getMembers()[command - 1];
	}

}
 
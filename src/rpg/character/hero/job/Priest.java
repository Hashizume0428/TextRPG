package rpg.character.hero.job;

import java.util.Random;

import rpg.ScanCommand;
import rpg.character.AbstractCharacter;
import rpg.character.AbstractParty;

public class Priest extends AbstractSuperHero {
	//コンストラクタ
	public Priest(String name) {
		super(name, 100, 4);
		super.job = "僧侶";
	}
	//オーバーライド
	protected void command(AbstractParty allies, AbstractParty enemies) {
		System.out.print(this.getName() + "(" + this.getJob() + ")の行動:");
        System.out.println("1:戦う　2：逃げる　3：必殺技");
        int command = ScanCommand.scan();
        if (command == 1) {// 戦う
            while (true) {
                if (this.attack(enemies)) {
                    break;
                }
            }
        } else if (command == 2) {// 逃げる
            this.run();
        } else if (command == 3) {// 必殺技
            while (true) {
                if (this.special(allies)) {//ここの引数をオーバーライドで変更
                    break;
                }
            }
        } else {
            this.command(allies, enemies);
        }
	}
	//オーバーライド
	public boolean special(AbstractParty targets) {
		Random random = new Random();
		AbstractCharacter[] members = targets.getMembers();
		System.out.println(getName() + "のヒール，味方全員が優しい光に包まれた");
		System.out.println();
		for (AbstractCharacter c : members) {
			if(!c.isDead()&&!c.isEscaped()){
				int randomHeal = random.nextInt(10) + 11;
				int heal= c.gotHeal(randomHeal);
				System.out.println(c.getName()+ "が" + randomHeal + "の回復");
			}
		}
		System.out.println();

		return true;
	}
}

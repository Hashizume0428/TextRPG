package rpg.character.hero.job;

import rpg.ScanCommand;
import rpg.character.AbstractParty;
import rpg.character.Specialist;
import rpg.character.hero.Hero;

public abstract class AbstractSuperHero extends Hero implements Specialist{
	//コンストラクタ
	AbstractSuperHero(String name, int hp, int attack) {
		super(name, hp, attack);
	}
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
            // 必殺技はこの階層以下で宣言しているので、ここでは通常攻撃する
        	//これ以下の階層で必殺技にオーバーライドする
            while (true) {
                if (this.special(enemies)) {
                    break;
                }
            }
        } else {
            this.command(allies, enemies);
        }
	}
	public boolean special(AbstractParty targets) {
		return true;
	}
}

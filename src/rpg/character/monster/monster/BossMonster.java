package rpg.character.monster.monster;

import java.util.Random;

import rpg.character.AbstractParty;
import rpg.character.Specialist;
import rpg.character.monster.Monster;

public abstract class BossMonster extends Monster implements Specialist {
	//コンストラクタ
	BossMonster(String name, int hp, int attack) {
		super(name, hp, attack);
	}
	//オーバーライド
	protected void command(AbstractParty ally, AbstractParty enemies) {
		System.out.print(this.getName() + "の行動:");
        Random random = new Random();
		int command = random.nextInt(30);
        if (command > 20) {// 戦う
            while (true) {
                if (this.attack(enemies)) {
                    break;
                }
            }
        } else if ((20 <= command) && (command < 25)) {// ぼーっとする
            System.out.println(this.getName() + "はボーッとしている");
        } else if ((command <= 25) && (command <= 30)) {// 必殺技
        	// 必殺技はこの階層以下で宣言しているので、ここでは通常攻撃する
        	//これ以下の階層で必殺技にオーバーライドする
            while (true) {
                if (this.attack(enemies)) {
                    break;
                }
            }
        } else {
            this.command(ally, enemies);
        }
	}
}

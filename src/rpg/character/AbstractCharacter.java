package rpg.character;

import java.util.Random;

public abstract  class AbstractCharacter {
	protected int attack;
	public boolean escaped;
	private int hp;
	private int maxHp;
	private String name;
	
	protected AbstractCharacter(String name, int hp, int attack) {
		this.name = name;
		this.hp = hp;
		this.maxHp = hp;
		this.attack  = attack;
	}
	protected abstract void command(AbstractParty allies, AbstractParty enemies);
	protected abstract AbstractCharacter selectTarget(AbstractParty targets);
	public String getName() { return this.name; };
	private void setName(String name) { this.name = name; };
	public int getHp() { return this.hp; };
	private void setHp(int hp) { this.hp = hp;};
	public int getAttack() { return this.attack; };
	private void setAttack(int i) { this.attack = attack;};
	public int getMaxHp() { return this.hp;};
	private void setMaxHp(int maxHp) { this.maxHp = maxHp; };
	public boolean isDead() { return this.hp==0 ? true : false; };
	public boolean attack(AbstractParty enemies) { 
		AbstractCharacter enemy = selectTarget(enemies);
		if (!enemy.isDead() && !enemy.isEscaped()) {
			Random random = new Random();
			int damage = random.nextInt(30) + 10;
			enemy.gotDamage(damage);
			return true;
		}
		else {
			return false;
		}
	}
	public int gotDamage(int damage) { 
		int result = (this.hp - damage) < 0 ? 0 : this.hp - damage ;
		if (result == 0) {
			System.out.println( this.name + "に" + this.hp + "のダメージ!");
			System.out.println(this.name + "は倒れた");
			}
		else {
			System.out.println( this.name + "に" + damage + "のダメージ!");}
		setHp(result);
		return damage;
	}
	public int gotHeal(int heal) { 
		int result = (this.hp + heal) > maxHp ? maxHp : this.hp + heal ;
		setHp(result);
		return result;
	}
	public boolean isEscaped() { return this.escaped; };
	public void init() {
		this.escaped = false;
	};
	public void actionStatus() {};
	

}
 
package rpg.area;

import rpg.character.hero.HeroParty;

public abstract class Area extends Object {
	//フィールド
	protected String name;

	//コンストラクタ
	public Area() {}
	
	public abstract Area access(HeroParty party);
	public abstract void printArea();
	public String getName() { return this.name; }
	public void setName(String name) { this.name = name; }
}
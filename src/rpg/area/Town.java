package rpg.area;

import rpg.ScanCommand;
import rpg.character.hero.HeroParty;

public class Town extends Area {
	public Town() {
		super.setName("はじまりの町");
	}
	
	public void printArea() {
		System.out.println("現在の場所は" + getName() + "です．");
	}
	public Area access(HeroParty party) {
		this.printArea();
		party.printPartyStatus();
		while (true) {
			System.out.println("どこへ移動しますか");
			System.out.println("1:宿屋　2：ダンジョン");
			int nextMove = ScanCommand.scan();
			if (nextMove == 1) {
				Hotel hotel = new Hotel();
				hotel.access(party);
				return hotel;
			} else if (nextMove == 2) {
				Dungeon1st dungeon1st = new Dungeon1st();
				dungeon1st.access(party);
				return dungeon1st;
			}
		}
	}
}

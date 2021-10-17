package rpg;

public class Sorcier extends Character {

	public Sorcier(String name) {
		super(name, 230, 150, 150, "S");
	}

	@Override
	public String toString() {
		return "Sorcier : " + this.name + " - " + this.life + "hp - " + this.money + "€ - " + this.xp + "xp";
	}
}

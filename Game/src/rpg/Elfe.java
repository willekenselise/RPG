package rpg;

public class Elfe extends Character {

	public Elfe(String name) {
		super(name, 200, 200, 100, "E");
	}

	@Override
	public String toString() {
		return "Elfe : " + this.name + " - " + this.life + "hp - " + this.money + "€ - " + this.xp + "xp";
	}
}

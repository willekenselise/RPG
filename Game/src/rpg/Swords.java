package rpg;

public class Swords extends Weapon {

	public Swords(float p, int d) {
		super("Swords", p, d);
	}

	public String ascii_art() {
		return 
				"          ./~\r\n"
				+ "(=@@@@@@@=[}=================--\r\n"
				+ "          `\\_";
	}
}
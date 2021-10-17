package rpg;

public class Wand extends Weapon {

	public Wand(float p, int d) {
		super("Wand", p, d);
	}
	
	
	public String ascii_art() {
		return 
				"              _,-'|\r\n"
				+ "           ,-'._  |\r\n"
				+ " .||,      |####\\ |\r\n"
				+ "\\.`',/     \\####| |\r\n"
				+ "= ,. =      |###| |\r\n"
				+ "/ || \\    ,-'\\#/,'`.\r\n"
				+ "  ||     ,'   `,,. `.\r\n"
				+ "  ,|____,' , ,;' \\| |\r\n"
				+ " (3|\\    _/|/'   _| |\r\n"
				+ "  ||/,-''  | >-'' _,\\\\\r\n"
				+ "  ||'      ==\\ ,-'  ,'\r\n"
				+ "  ||       |  V \\ ,|\r\n"
				+ "  ||       |    |` |\r\n"
				+ "  ||       |    |   \\\r\n"
				+ "  ||       |    \\    \\\r\n"
				+ "  ||       |     |    \\\r\n"
				+ "  ||       |      \\_,-'\r\n"
				+ "  ||       |___,,--\")_\\\r\n"
				+ "  ||         |_|   ccc/\r\n"
				+ "  ||        ccc/\r\n"
				+ "  || ";
	}
}
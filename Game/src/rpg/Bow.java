package rpg;

public class Bow extends Weapon {

	public Bow(float p, int d) {
		super("Bow", p, d);
	}

	@Override
	public String ascii_art() {
		return "            /`.                    \n"
				+ "           /   :.               \n"
				+ "          /     \\\\             \n"
				+ "       ,;/,      ::              \n"
				+ "   ___:c/.(      ||              \n"
				+ " ,'  _|:)>>>--,-'B)>             \n"
				+ "(  '---'\\--'` _,'||             \n"
				+ " `--.    \\ ,-'   ;;              \n"
				+ "     |    \\|    //               \n"
				+ "     |     \\   ;'                \n"
				+ "     |_____|\\,'                  \n"
				+ "     :     :                      \n"
				+ "     |  ,  |                      \n"
				+ "     | : \\ :                     \n"
				+ "     | | : :                      \n"
				+ "     | | | |                      \n"
				+ "     | | |_`.                     \n"
				+ "     '--`                         \n"
				+ "                                  ";
	}
	
}

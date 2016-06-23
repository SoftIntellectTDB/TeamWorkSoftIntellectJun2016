import eu.veldsoft.complica4.model.ia.ArtificialIntelligence;
import eu.veldsoft.complica4.model.ia.SimpleRulesArtificialIntelligence;
import eu.veldsoft.complica4.model.ia.Util;

public class Main {
	public static void main(String[] args) {
		ArtificialIntelligence bot = new SimpleRulesArtificialIntelligence();

		int state[][] = new int[ArtificialIntelligence.STATE_COLS][ArtificialIntelligence.STATE_ROWS];
		for (int i = 0; i < ArtificialIntelligence.STATE_ROWS; i++) {
			for (int j = 0; j < ArtificialIntelligence.STATE_COLS; j++) {
				state[i][j] = ((Integer[]) ArtificialIntelligence.STATE_VALUES
						.toArray())[Util.PRNG
						.nextInt(ArtificialIntelligence.STATE_VALUES.size())];
			}
		}
		
		int result = bot.move(state, ((Integer[]) ArtificialIntelligence.STATE_VALUES
				.toArray())[Util.PRNG
				.nextInt(ArtificialIntelligence.STATE_VALUES.size())]);
		
		System.out.println(result);
	}

}

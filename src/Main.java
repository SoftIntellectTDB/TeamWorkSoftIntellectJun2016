import java.util.Arrays;

import eu.veldsoft.complica4.model.ia.ArtificialIntelligence;
import eu.veldsoft.complica4.model.ia.SimpleRulesArtificialIntelligence;
import eu.veldsoft.complica4.model.ia.Util;

public class Main {
	public static void main(String[] args) {
		ArtificialIntelligence bot = new SimpleRulesArtificialIntelligence();

		int state[][] = new int[ArtificialIntelligence.STATE_COLS][ArtificialIntelligence.STATE_ROWS];

		/*
		 * Fill state array with random numbers.
		 */
		for (int i = 0; i < ArtificialIntelligence.STATE_COLS; i++) {
			for (int j = 0; j < ArtificialIntelligence.STATE_ROWS; j++) {
				if (Util.PRNG.nextBoolean() == true) {
					state[i][j] = 0;
				} else {
					state[i][j] = ((Integer[]) ArtificialIntelligence.STATE_VALUES
							.toArray(new Integer[ArtificialIntelligence.STATE_VALUES
									.size()]))[Util.PRNG
							.nextInt(ArtificialIntelligence.STATE_VALUES.size())];
				}
			}
		}

		/*
		 * Pack state array in order all zeros to be at the top of the columns.
		 */
		for (int i = 0; i < ArtificialIntelligence.STATE_COLS; i++) {
			boolean done = false;
			while (done == false) {
				done = true;
				for (int j = ArtificialIntelligence.STATE_ROWS - 1; j > 0; j--) {
					if (state[i][j] == 0 && state[i][j - 1] != 0) {
						state[i][j] = state[i][j - 1];
						state[i][j - 1] = 0;

						done = false;
					}
				}
			}
		}

		/*
		 * Print state array used for testing.
		 */
		for (int j = 0; j < ArtificialIntelligence.STATE_ROWS; j++) {
			for (int i = 0; i < ArtificialIntelligence.STATE_COLS; i++) {
				System.out.print(state[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		/*
		 * Run the tests.
		 */
		int result = bot
				.move(state,
						((Integer[]) ArtificialIntelligence.STATE_VALUES
								.toArray(new Integer[ArtificialIntelligence.STATE_VALUES
										.size()]))[Util.PRNG
								.nextInt(ArtificialIntelligence.STATE_VALUES
										.size())]);

		/*
		 * Print test result.
		 */
		System.out.println(result);
	}

}

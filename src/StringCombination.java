
// Similar to Array subset problem
public class StringCombination {

	public static void combine(char[] chars, boolean[] b, int start, int remaining) {
		// No more elements remained to add to array, so print 
		if (remaining == 0) {
			System.out.print("{");
			for (int i = 0; i < b.length; i++) {
				if (b[i]) {
					System.out.print(chars[i]);
				}
			}
			System.out.println("}");
		} else {

			for (int i = start; i< chars.length; i++) {
				if (!b[i]) {
					b[i] = true;
					combine(chars, b, i + 1, remaining-1);
					b[i] = false;
				}
			}
		}
	}

	public static void printCombinations(char[] chars) {
		// Note i <= nums.length
		for (int i = 0; i <= chars.length; i++) {
			combine(chars, new boolean[chars.length], 0, i);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printCombinations("abcd".toCharArray());
	}

}

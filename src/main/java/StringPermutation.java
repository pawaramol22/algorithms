
public class StringPermutation {
	
	public static void permutations(char[] chars, boolean[] used, StringBuilder str, int pos) {
		if(pos == chars.length) {
			System.out.println(str.toString());
			return;
		}
		
		for(int i = 0; i < chars.length; i++) {
			if(!used[i]) {
				
				str.append(chars[i]);
				used[i] = true;
				permutations(chars, used, str, pos+1);
				used[i] = false;
				str.deleteCharAt(str.length()-1);
			}
		}
	}
	
	public static void main(String[] args) {
		String str = "123";
		permutations(str.toCharArray(), new boolean[str.length()], new StringBuilder(), 0);
	}

}

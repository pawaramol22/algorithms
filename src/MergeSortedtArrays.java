
public class MergeSortedtArrays {

	public static void merge(int[] longarray, int[] shortarray, int longarraytail, int shortarraytail) {

		while(longarraytail >=0 && shortarraytail >= 0) {
			if (longarray[longarraytail] > shortarray[shortarraytail]) {
				longarray[longarraytail+shortarraytail+1] = longarray[longarraytail];
				longarraytail--;
			} else {
				longarray[longarraytail+shortarraytail+1] = shortarray[shortarraytail];
				shortarraytail--;
			}
		}
		
		while(shortarraytail >= 0) {
			longarray[longarraytail+shortarraytail+1] = shortarray[shortarraytail];
			shortarraytail--;
		}
	}
	
	public static void main(String[] args) {
		// -1 indicates unfilled positions
		// Assumption: longer array can accommodate smaller array too
		int[] longarray = new int[]{10,20,300,400,-1,-1,-1};
		int longarraytail = 3;
		int[] shortarray = new int[]{1,2,3};
		int shortarraytail = 2;
		
		merge(longarray, shortarray, longarraytail, shortarraytail);
		for(int i = 0; i < longarray.length; i++) {
			System.out.print(longarray[i] + " ");
		}
	}

}

public class ArrayUtils {

	// return occurrences of number in sorted array allowing duplicates
	// Use modified binary search
	public static int getOccurancesOfNumber(int num, int[] nums, int start, int end) {
		if(start > end) return 0;
		if(nums[start] > num) return 0;
		if(nums[end] < num) return 0;
		
		int mid = (start+end)/2;
		if(nums[mid] == num) {
			return 1 + getOccurancesOfNumber(num, nums, start, mid-1) + getOccurancesOfNumber(num, nums, mid+1, end); 
		} else if (num > nums[mid]){
			return getOccurancesOfNumber(num, nums, mid+1, end);
		} else {
			return getOccurancesOfNumber(num, nums, start, mid-1);
		}
		
	}
	
	public static void subsets(int[] nums, boolean[] b, int start, int remaining) {
		// No more elements remained to add to array, so print 
		if (remaining == 0) {
			System.out.print("{");
			for (int i = 0; i < b.length; i++) {
				if (b[i]) {
					System.out.print(nums[i]);
				}
			}
			System.out.println("}");
		} else {

			for (int i = start; i< nums.length; i++) {
				if (!b[i]) {
					b[i] = true;
					subsets(nums, b, i + 1, remaining-1);
					b[i] = false;
				}
			}
		}
	}

	public static void printSubsets(int[] nums) {
		// Note i <= nums.length
		for (int i = 0; i <= nums.length; i++) {
			subsets(nums, new boolean[3], 0, i);
		}
	}

	public static void subsetsum(int[] a, int k) {

		int start = 0;
		int end = 0;
		int sum = a[0];
		for (int i = 1; i <= a.length; i++) {
			while (sum > k && start < (i - 1)) {
				sum = sum - a[start++];
			}

			if (k == sum) {
				end = i - 1;
				System.out.println(start + " " + end);
				break;
			}

			if (i < a.length) {
				sum += a[i];
			}
		}

	}

	public static int findSecondMax(int[] data) {
		if(null == data) return Integer.MIN_VALUE;
		if(1 == data.length) return data[0];
		int max = data[0];
		int secondMax = Integer.MIN_VALUE;
		for(int i = 1; i < data.length; i++) {
			if(data[i] > max) {
				secondMax = max;
				max = data[i];
			} else if(data[i] != max){
				secondMax = data[i];
			}
		}
		
		return secondMax;
	}


	public static int[] rotate(int[] array, int rotateBy){
		if (array.length == 0) {
			return array;
		}

		for(int i = 0; i < rotateBy; i++){
			rotate(array);
		}
		return array;
	}

	private static void rotate(int[] array){

		int temp = array[0];
		for(int i = 1; i < array.length; i++){
			array[i-1] = array[i];
		}
		array[array.length - 1] = temp;
	}

	public static int[] mergeSortedArrays(int[] arr1, int[] arr2){
		if(null == arr1 || 0 == arr1.length){
			return arr2;
		}

		if(null == arr2 || 0 == arr2.length) {
			return arr1;
		}

		int length1 = arr1.length;
		int length2 = arr2.length;

		int[] result = new int[length1 + length2];
		int i = 0, j = 0, k =0;
		for(; i < length1 && j < length2; ){
			if(arr1[i] <= arr2[j]){
				result[k] = arr1[i];
				i++;
			} else {
				result[k] = arr2[j];
				j++;
			}
			k++;
		}

		while(i < length1){
			result[k] = arr1[i];
			k++;
			i++;
		}

		while(j < length2){
			result[k] = arr2[j];
			k++;
			j++;
		}

		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		subsetsum(new int[] { 1, 4, 20, 3, 10, 5 }, 33);
		subsetsum(new int[] { 4, 6, 3, -9, -5, 1, 3, 0, 2 }, 0);
		
		// Print all subsets of an array
		printSubsets(new int[] { 1, 2, 3 });
		
		int[] nums = new int[]{1,1,2,3,3,3,3,3,4,5,6,6};
		System.out.println("total occurrences of 3 are, " + getOccurancesOfNumber(3, nums, 0, 11));
		System.out.println("total occurrences of 6 are, " + getOccurancesOfNumber(6, nums, 0, 11));
		System.out.println("total occurrences of 4 are, " + getOccurancesOfNumber(4, nums, 0, 11));
		System.out.println("Second max element is " + findSecondMax(nums));
	}

}

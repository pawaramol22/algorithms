
public class LongestIncreasingSubsequence {

	public static void longestsubsequence(int[] nums) {
	
		int[] subseqenceSize = new int[nums.length];
		String[] subseqence = new String[nums.length];
		int maxSubseuenceSize = 1;
		for(int i = 0; i < nums.length; i++) {
			subseqenceSize[i] = 1;
			subseqence[i] = nums[i] + " ";
		}
		
		for(int i = 1; i < nums.length; i++) {
			for(int j = 0; j < i; j++) {
				if(nums[j] < nums[i] && subseqenceSize[i] < subseqenceSize[j] + 1) {
					subseqenceSize[i] = subseqenceSize[j] + 1;
					subseqence[i] = subseqence[j] + nums[i] + " ";
					
					if(maxSubseuenceSize < subseqenceSize[i]) {
						maxSubseuenceSize = subseqenceSize[i];
					}
				}
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(maxSubseuenceSize == subseqenceSize[i]) {
				System.out.println(subseqence[i]);
			}
		}
		
	}
	
	public static void main(String[] args) {
		longestsubsequence(new int[]{2,6,7,4,5,1,3});
	}

}

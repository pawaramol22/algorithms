
public class MaxSubsequentProduct {

	public static double maxProduct(double[] nums) {
		double currentPositive = 1;
		double currentNegative = 1;
		double globalPositive = 0;
		double gobalNegative = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] > 0) {
				currentPositive *= nums[i];
				if(currentNegative != 1) {
					currentNegative *= nums[i]; 
				}
			} else if(nums[i] < 0) {
				if(currentNegative == 1) {
					currentNegative = currentPositive * nums[i];
					currentPositive = 1;
				} else {
					// important part of method
					double tempNegative = currentNegative;
					currentNegative = currentPositive * nums[i];
					currentPositive = tempNegative * nums[i];
				}
			} else {
				currentPositive = 1;
				currentNegative = 1;
			}
			
			if(currentPositive > globalPositive) {
				globalPositive = currentPositive;
			}
			
			if(currentNegative > gobalNegative) {
				gobalNegative = currentNegative;
			}
		}
		return globalPositive;
	}
	
	public static void main(String[] args) {
		System.out.println("Max subsequence product is " + maxProduct(new double[]{1, 2, -4, 5, 3, -1}));
		System.out.println("Max subsequence product is " + maxProduct(new double[]{1.63, 0.68, -3.00, -2.21, -0.72}));
	}

}

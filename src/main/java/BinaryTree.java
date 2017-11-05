
public class BinaryTree {

	
	public static TreeNode constructBinaryTree(int[] nums, int start, int end) {
		
		if(null == nums || start > end) return null;
		if(start == end) {
			return new TreeNode(nums[start]);
		}
		
		TreeNode root = new TreeNode(nums[start]);
		root.left = constructBinaryTree(nums, start + 1, (start+end)/2);
		root.right = constructBinaryTree(nums, (start+end)/2 + 1, end);
		
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode root = constructBinaryTree(new int[] {1,2,3}, 0 , 2);
		BinarySearchTree.inOrder(root);
	}

}

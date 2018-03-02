import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree {

	public static void inOrder(TreeNode root) {
		if (null == root)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	public static void postOrder(TreeNode root) {
		if (null == root)
			return;		
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static void preOrder(TreeNode root) {
		if (null == root)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	/**
	 * 1. Push the root node to the stack. 2. while stack is not empty Pop a
	 * node from the stack, and enqueue it in the queue (or just print it, skip
	 * last step if you are just printing it). 3. Push its right child followed
	 * by its left child to the child stack. 4. while Now the Queue would have
	 * all the nodes ready to be traversed in pre-order. 5. Dequeue the nodes
	 * from the Queue one by one and you will have the pre-order traversal of
	 * the tree.
	 * 
	 * @param root
	 */
	public static void preOrderNonRecursive(TreeNode root) {
		if (null == root)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			q.add(node);
			if (null != node.right)
				s.push(node.right);
			if (null != node.left)
				s.push(node.left);
		}

		while (!q.isEmpty()) {
			TreeNode node = q.poll();
			System.out.print(node.data + " ");
		}
	}
	
	// http://www.geeksforgeeks.org/archives/26086
	public static void preOrderNonRecursiveEnhanced(TreeNode root) {
		if (null == root)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			System.out.print(node.data + " ");
			if (null != node.right)
				s.push(node.right);
			if (null != node.left)
				s.push(node.left);
		}
	}
	
	public static void postOrderNonRecursive(TreeNode root) {
		if (null == root)
			return;
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> q = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode node = s.pop();
			q.push(node);
			if (null != node.left)
				s.push(node.left);			
			if (null != node.right)
				s.push(node.right);
		}

		while (!q.isEmpty()) {
			TreeNode node = q.pop();
			System.out.print(node.data + " ");
		}
	}
	
	public static List<Integer> inOrderNonRecursive(TreeNode root) {
		if (null == root)
			return new ArrayList<Integer>(0);
		Stack<TreeNode> s = new Stack<TreeNode>();
		List<Integer> result = new ArrayList<Integer>();
		while(true) {
			if(null != root) {
				s.push(root);
				root = root.left;
			} else {
				if(!s.isEmpty()) {
					root = s.pop();
					System.out.print(root.data + " ");
                    result.add(root.data);
					root = root.right;
				} else {
					break;
				}
			}
		}

		return result;
	}

	public static TreeNode delete(TreeNode p, int toDelete) {
		if (p == null)
			throw new RuntimeException("cannot delete.");
		else if (toDelete < p.data)
			p.left = delete(p.left, toDelete);
		else if (toDelete > p.data)
			p.right = delete(p.right, toDelete);
		else {
			if (p.left == null) // left child is null
				return p.right;
			else if (p.right == null) // right child is null
				return p.left;
			else {
				// get data from the rightmost node in the left subtree
				p.data = findMin(p.right);
				// delete the rightmost node in the left subtree
				p.right = delete(p.right, p.data);
			}
		}
		return p;
	}

	
	public static void mirror(TreeNode root) {
		if(null == root) return;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		mirror(root.left);
		mirror(root.right);
	}

	public static int countLeaves(TreeNode root) {
		if (null == root)
			return 0;
		if (null == root.left && null == root.right) {
			return 1;
		} else {
			return countLeaves(root.left) + countLeaves(root.right);
		}
	}

	public static int size(TreeNode root) {
		if(null == root) {
			return 0;
		}
		return 1 + size(root.left) + size(root.right);
	}
	
	public static boolean hasSum(TreeNode root, int sum) {
		if(null == root) {
			return sum == 0;
		}
		return hasSum(root.left, sum - root.data) || hasSum(root.right, sum - root.data);
	}
	
	public static TreeNode clone(TreeNode root) {
		if (null == root)
			return null;
		TreeNode duplicate = new TreeNode(root.data);
		duplicate.left = clone(root.left);
		duplicate.right = clone(root.right);

		return duplicate;
	}
	
	public static boolean areSame(TreeNode t1, TreeNode t2) {
		if(null == t1 && null == t2) {
			return true;
		} else if(null != t1 && null != t2) {
			return (t1.data == t2.data && areSame(t1.left, t2.left) && areSame(t1.right, t2.right));
		}
		
		return false;
		
	}
	
	public static boolean isSubtree(TreeNode t1, TreeNode t2) {
		if(null == t1 && null == t2) return true;
		if(null != t1 && null == t2) return true;
		if(null == t1 && null != t2) return false;
		
		if(null != t1 && null != t2) {
			if(t1.data == t2.data) 
				return areSame(t1.left, t2.left) && areSame(t1.right, t2.right);
			else 
				return areSame(t1.left, t2) || areSame(t1.right, t2);
		}
		
		return false;
	}
	
	public static void printPaths(TreeNode root, int[] path, int index) {
		
		// base case if tree is null
		if(null == root) {
			return;
		} 
		
		// We found first node. add it to path array
		path[index++] = root.data;
		
		// if this is leaf print path so far
		if(null == root.left && null == root.right){
			for(int i = 0; i < index; i++){
				System.out.print(path[i] + " ");
			}
			System.out.println();
		} else {
			
			// if not leaf then traverse left path
			printPaths(root.left, path, index);
			
			// traverse right path
			printPaths(root.right, path, index);
		}
	}
	
	public static int findMin(TreeNode root) {
		if(null == root) return -1;
		if(null == root.left) return root.data;
		return findMin(root.left);
	}
	
	public static int findMax(TreeNode root) {
		if(null == root) return -1;
		if(null == root.right) return root.data;
		return findMax(root.right);
	}

	public static TreeNode insert(TreeNode root, int value){
		if (null == root) {
			return new TreeNode(value);
		}

		if (value <= root.data){
			root.left = insert(root.left, value);
		}
		if (value > root.data){
			root.right = insert(root.right, value);
		}

		return root;
	}

    private static boolean isSubtreeGreater(TreeNode root, int value){
        if (null == root) {
            return true;
        }

        if(root.data > value && isSubtreeGreater(root.left, value) && isSubtreeGreater(root.right, value)) {
            return true;
        }

        return false;
    }
	private static boolean isSubtreeLesser(TreeNode root, int value){
	    if (null == root) {
	        return true;
        }

        if(root.data <= value && isSubtreeLesser(root.left, value) && isSubtreeLesser(root.right, value)) {
	        return true;
        }

        return false;
    }

	public static boolean isBST(TreeNode root) {
        if (null == root) {
            return true;
        }

        if (isSubtreeLesser(root.left, root.data) && isSubtreeGreater(root.right, root.data) && isBST(root.left) && isBST(root.right)) {
            return true;
        }

        return false;
    }

    public static List<Integer> bfs(TreeNode root){
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);

	    List<Integer> result = new ArrayList<Integer>();

	    while(!queue.isEmpty()){
            TreeNode node = queue.poll();
	        System.out.print(node.data + " ");
	        result.add(node.data);
	        if (null != node.left)
	            queue.add(node.left);
	        if (null != node.right)
	            queue.add(node.right);
        }

        return result;
    }

    public static int maxDepth(TreeNode root){
    	if (null == root) {
    		return 0;
		}

		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}

	public static void main(String[] args) {

		TreeNode root = insert(null, 5);
		root = insert(root, 3);
		root = insert(root, 7);
		root = insert(root, 2);
		root = insert(root, 4);
		root = insert(root, 6);
		root = insert(root, 9);
		root = insert(root, 8);
		root = insert(root, 10);

		System.out.println("Max depth is " + maxDepth(root));

        System.out.println("*********** BFS traversal *********** ");
        bfs(root);
        System.out.println();

		System.out.println("*********** Pre-order traversal *********** ");
		preOrder(root);
		System.out.println();
		preOrderNonRecursiveEnhanced(root);
		System.out.println();

		System.out.println("*********** Post-order traversal *********** ");
		postOrder(root);
		System.out.println();
		postOrderNonRecursive(root);
		System.out.println();

		System.out.println("*********** In-order traversal *********** ");
		inOrder(root);
		System.out.println();
		inOrderNonRecursive(root);
		System.out.println();
		
		System.out.println("Min is " + findMin(root));
		System.out.println("Max is " + findMax(root));
		
		printPaths(root, new int[4], 0);
		
		System.out.println("Total leaves are " + countLeaves(root));
		System.out.println("Size " + size(root));
		System.out.println("sum 10 present? " + hasSum(root, 10));

		TreeNode clone = clone(root);
		preOrder(clone);
		System.out.println();
		System.out.println("Are same : " + areSame(root, clone));
		mirror(clone);
		System.out.println("Are same : " + areSame(root, clone));
		preOrder(clone);
		System.out.println();

        System.out.println("Before deleting 5");
		preOrder(root);
		System.out.println();
		delete(root, 5);
        System.out.println("Aftere deleting 5");
        preOrder(root);
		System.out.println();
	}

}

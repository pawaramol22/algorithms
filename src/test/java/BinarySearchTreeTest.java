import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class BinarySearchTreeTest {

    private TreeNode root;

    @Before
    public void setup(){
        root = BinarySearchTree.insert(null, 5);
        root = BinarySearchTree.insert(root, 3);
        root = BinarySearchTree.insert(root, 7);
        root = BinarySearchTree.insert(root, 2);
        root = BinarySearchTree.insert(root, 4);
        root = BinarySearchTree.insert(root, 6);
        root = BinarySearchTree.insert(root, 9);
        root = BinarySearchTree.insert(root, 8);
        root = BinarySearchTree.insert(root, 10);
    }

    @After
    public void destroy(){
        root = null;
    }

    @Test
    public void test_bfs(){

        List<Integer> result = BinarySearchTree.bfs(root);

        List<Integer> expected = new ArrayList<Integer>();
        expected.add(5);
        expected.add(3);
        expected.add(7);
        expected.add(2);
        expected.add(4);
        expected.add(6);
        expected.add(9);
        expected.add(8);
        expected.add(10);

        for(int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_inOrderNonRecursive(){

        List<Integer> result = BinarySearchTree.inOrderNonRecursive(root);

        // 2 3 4 5 6 7 8 9 10
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        expected.add(8);
        expected.add(9);
        expected.add(10);

        for(int i = 0; i < result.size(); i++) {
            Assert.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_isBST(){
        Assert.assertEquals(true, BinarySearchTree.isBST(root));
    }

    @Test
    public void test_isSubtree(){

        TreeNode subtree = BinarySearchTree.clone(root);
        subtree.right.right = new TreeNode(9);
        subtree.right.right.left = new TreeNode(8);
        subtree.right.right.right = new TreeNode(10);

        Assert.assertEquals(true, BinarySearchTree.isSubtree(root, subtree));

        TreeNode notsubtree = BinarySearchTree.clone(root);
        notsubtree.right.right = new TreeNode(9);
        notsubtree.right.right.right = new TreeNode(10);

        Assert.assertEquals(false, BinarySearchTree.isSubtree(root, notsubtree));

        Assert.assertEquals(true, BinarySearchTree.isSubtree(root, null));

        Assert.assertEquals(false, BinarySearchTree.isSubtree(null, subtree));
    }
}

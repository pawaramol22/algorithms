import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListUtilsTest {

    @Before
    public void setUp() {
    }

    @After
    public void destroy() {
    }

    @Test
    public void test_reverseRecursive() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node n = LinkedListUtils.reverseRecursive(n1);

        Assert.assertNotNull(n);
        Assert.assertEquals(4, n.data);
        Assert.assertEquals(3, n.next.data);
        Assert.assertEquals(2, n.next.next.data);
        Assert.assertEquals(1, n.next.next.next.data);
        Assert.assertEquals(null, n.next.next.next.next);
    }

    @Test
    public void test_reverseNonResursive() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node n = LinkedListUtils.reverseNonRecursive(n1);

        Assert.assertNotNull(n);
        Assert.assertEquals(4, n.data);
        Assert.assertEquals(3, n.next.data);
        Assert.assertEquals(2, n.next.next.data);
        Assert.assertEquals(1, n.next.next.next.data);
        Assert.assertEquals(null, n.next.next.next.next);
    }

    @Test
    public void test_findIntersection(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node n11 = new Node(5);
        Node n12 = new Node(6);
        Node n13 = new Node(3);
        Node n14 = new Node(4);
        n11.next = n12;
        n12.next = n13;
        n13.next = n14;

        Node n = LinkedListUtils.findIntersection(n1, n11);

        Assert.assertNotNull(n);
        Assert.assertEquals(3, n.data);

    }

    @Test
    public void test_findIntersection_No_intersection(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node n11 = new Node(5);

        Node result1 = LinkedListUtils.findIntersection(n1, n11);
        Assert.assertNull(result1);

        Node result2 = LinkedListUtils.findIntersection(n1, null);
        Assert.assertNull(result2);

    }

    @Test
    public void test_findReferenceIntersection(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node n11 = new Node(5);
        Node n12 = new Node(6);
        Node n13 = new Node(7);
        n11.next = n12;
        n12.next = n13;
        n13.next = n3;

        Node n = LinkedListUtils.findReferenceIntersection(n1, n11);

        Assert.assertNotNull(n);
        Assert.assertEquals(n3, n);
    }

    @Test
    public void test_findReferenceIntersection_No_intersection(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node n11 = new Node(5);

        Node result1 = LinkedListUtils.findReferenceIntersection(n1, n11);
        Assert.assertNull(result1);

        Node result2 = LinkedListUtils.findReferenceIntersection(n1, null);
        Assert.assertNull(result2);

    }

    @Test
    public void test_checkCircularLinkedList(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;

        Node actual = LinkedListUtils.checkCircularLinkedList(n1);
        Assert.assertEquals(actual, n3);

        Assert.assertNull(LinkedListUtils.checkCircularLinkedList(null));

        n6.next = null;
        Assert.assertNull(LinkedListUtils.checkCircularLinkedList(n1));

    }
}

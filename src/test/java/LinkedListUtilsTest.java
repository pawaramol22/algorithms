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
    public void test_reverseResursive() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Node n = LinkedListUtils.reverseResursive(n1);

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

        Node n = LinkedListUtils.reverseNonResursive(n1);

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
}

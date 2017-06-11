
public class LinkedListTest {

	public static Node reverse(Node node) {
		if(null == node || null == node.next) {
			return node;
		}
		
		Node reversedNode = reverse(node.next);
		node.next.next = node;
		node.next= null;
		
		return reversedNode;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
//		Node n3 = new Node(3);
//		Node n4 = new Node(4);
		n1.next = n2;
//		n2.next = n3;
//		n3.next = n4;
		
		Node n = reverse(n1);
		while(null != n) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

}

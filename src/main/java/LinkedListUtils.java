public class LinkedListUtils {

    /***
     * Reverse linked list recursively
     *
     * @param node
     * @return reversed linked list head node
     */
    public static Node reverseResursive(Node node) {
        if (null == node || null == node.next) {
            return node;
        }

        Node reversedNode = reverseResursive(node.next);
        node.next.next = node;
        node.next = null;

        return reversedNode;
    }

    /***
     * Reverse linked list non-recusrsively
     *
     * @param node
     * @return reversed linked list head node
     */
    public static Node reverseNonResursive(Node node) {
        if (null == node || null == node.next) {
            return node;
        }

        Node previous = null;
        Node current = node;
        while (current.next != null){
            Node temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        current.next = previous;

        return current;
    }

    /**
     *
     Write a program to find the node at which the intersection of two singly linked lists begins.

     For example, the following two linked lists:
     A:          a1 → a2
                        ↘
                        c1 → c2 → c3
                        ↗
     B:     b1 → b2 → b3

     begin to intersect at node c1.

     * @param node1
     * @param node2
     * @return intersecting node
     */
    public static Node findIntersection(Node node1, Node node2) {
        if (null == node1 || null == node2) {
            return null;
        }

        Node _node1 = node1;
        Node _node2 = node2;

        // iterate over lists until smaller list reach the end
        while (_node1 != null && _node2 != null) {
            _node1 = _node1.next;
            _node2 = _node2.next;
        }

        // Switch the smaller list pointer to point to bigger list head
        if (null == _node1) {
            _node1 = node2;
        } else {
            _node2 = node1;
        }

        // iterate until bigger list reach the end
        while (_node1 != null && _node2 != null) {
            _node1 = _node1.next;
            _node2 = _node2.next;
        }

        // Switch the bigger list pointer to point to smaller list head
        if (null == _node1) {
            _node1 = node2;
        } else {
            _node2 = node1;
        }

        // iterate until matching element is found, which is beginning of the intersection
        while (_node1 != null && _node2 != null) {
            if (_node1.data == _node2.data) {
                break;
            }
            _node1 = _node1.next;
            _node2 = _node2.next;
        }

        return _node1;
    }

}

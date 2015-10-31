/* NetId(s): cxa2, nnnn. Time spent: 5 hours, 10 minutes.

 * Name(s): Cristian Alonso
 * What I thought about this assignment:
 * Good assignment to start learning about data structures. Sufficiently
 * challenging but not excessively.
 */

/** An instance is a doubly linked list. */
public class DLinkedList<E> {
    private int size;  // Number of nodes in the linked list.
    private Node head; // first node of linked list (null if none)
    private Node tail; // last node of linked list (null if none)

    /** Constructor: an empty linked list. */
    public DLinkedList() {
    }

    /** Return the number of values in this list. */
    public int size() {
        return size;
    }

    /** Return the first node of the list (null if the list is empty). */
    public Node getHead() {
        return head;
    }

    /** Return the last node of the list (null if the list is empty). */
    public Node getTail() {
        return tail;
    }

    /** Return the data in node n of this list.
     * Precondition: n is a node of this list; it may not be null. */
    public E getData(Node n) {
        assert n != null;
        return n.data;
    }

    /** Return a representation of this list: its data, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * 
     * E.g. for the list containing 6 3 8 in that order, the result it "[6, 3, 8]". */
    public String toString() {
        //TODO: Write this method first. Do NOT use field size
        String listString = "[";
        Node currentNode = head;
        if (currentNode == null) {
        	return listString + "]";
        }
        boolean notEnd = true;
        while (notEnd) {
        	listString = listString + currentNode.getData();
        	if (currentNode.succ == null) {
        		notEnd = false;
        	}
        	else {
        		listString = listString + ", ";
        	}
        	currentNode = currentNode.succ;
        }
        listString = listString + "]";
        return listString;
    }

    /** Return a representation of this list: its values in reverse, with adjacent
     * ones separated by ", ", "[" at the beginning, and "]" at the end. <br>
     * 
     * E.g. for the list containing 6 3 8 in that order, the result it "[8, 3, 6]".*/
    public String toStringRev() {
        //TODO: Write this method second. Do NOT use field size
    	String listString = "[";
        Node currentNode = tail;
        if (currentNode == null) {
        	return listString + "]";
        }
        boolean notEnd = true;
        while (notEnd) {
        	listString = listString + currentNode.getData();
        	if (currentNode.pred == null) {
        		notEnd = false;
        	}
        	else {
        		listString = listString + ", ";
        	}
        	currentNode = currentNode.pred;
        }
        listString = listString + "]";
        return listString;
    }

    /** Place data v in a new node at the beginning of the list and
     * return the new node */
    public Node prepend(E v) {
        //TODO: This is the third method to write. Then you can begin testing
    	DLinkedList<E>.Node newHead = new Node(null, v, head);
    	if (head == null) {
    	   head = newHead;
    	   tail = newHead;
    	   size++;
       }
    	else {
    		head.pred = newHead;
    		head = newHead;
    		size++;
    	}
    	return head;
    }

    /** Place data v in a new node at the end of the list and
     * return the new node. */
    public Node append(E v) {
        //TODO:This is the fourth method to write.
    	DLinkedList<E>.Node newTail = new Node(tail, v, null);
    	if (tail == null) {
     	   tail = newTail;
     	   head = newTail;
     	   size++;
        }
     	else {
     		tail.succ = newTail;
     		tail = newTail;
     		size++;
     	}
     	return tail;
    }

    /** Place data v in a new node after node n and
     * return the new node.
     * Precondition: n must be a node of this list; it may not be null. */
    public Node insertAfter(E v, Node n) {
        //TODO: This is the fifth method to write and test
    	DLinkedList<E>.Node newNode = new Node(n, v, n.succ);
    	if (n.succ != null) {
    		Node successor = n.succ;
        	successor.pred = newNode;
    	}
    	n.succ = newNode;
        if (newNode.succ == null) {
        	tail = newNode;
        }
        size++;
        return newNode;
    }

    /** Place data v in a new node before node n and
     * return the new node.
     * Precondition: n must be a node of this list; it may not be null. */
    public Node insertBefore(E v, Node n) {
        //TODO: This is the sixth method to write and test
    	DLinkedList<E>.Node newNode = new Node(n.pred, v, n);
    	if (n.pred != null) {
    		Node predecessor = n.pred;
        	predecessor.succ = newNode;
    	}
    	n.pred = newNode;
    	if (newNode.pred == null) {
        	head = newNode;
        }
        size++;
        return newNode;
    }

    /** Remove node n from this list.
     * Precondition: n must be a node of this list; it may not be null. */
    public void remove(Node n) {
        //TODO: This is the seventh method to write and test
    	if (size==1) {
    		head = null;
    		tail = null;
    	}
    	else{
    		if (n.pred == null) {
    			head = n.succ;
    			head.pred = null;
    		}
    		else if (n.succ == null) {
    			tail = n.pred;
    			tail.succ = null;
    		}
    		else {
    			Node priorNode = n.pred;
    			Node postNode = n.succ;
    			priorNode.succ = postNode;
    			postNode.pred = priorNode;
    		}
    	}
    	size--;
    } 


    /*********************/

    /** An instance is a node of this list. */
    public class Node {
        /** Predecessor of this node on list (null if this is the first node). */
        private Node pred;

        /** The data in this element. */
        private E data; 

        /** Successor of this node on list. (null if is the last node). */
        private Node succ; 

        /** Constructor: an instance with predecessor node p (can be null),
         * successor node s (can be null), and data v. */
        private Node(Node p, E v, Node s) {
            pred= p;
            succ= s;
            data= v;
        }

        /** Return the data in this node. */
        public E getData() {
            return data;
        }

        /** Return the predecessor of this node (null if this is the
         * first node of the list). */
        public Node pred() {
            return pred;
        }

        /** Return the successor of this node (null if this is the
         * last node of this list). */
        public Node succ() {
            return succ;
        }
    }

}

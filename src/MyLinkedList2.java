import java.util.*;

public class MyLinkedList2<T> implements List<T> {
    private Node head;
    private Node tail;
    private int linkCounter;
    private ArrayList<Node> nodeList;  // Holds all nodes in order

    public MyLinkedList2() {
        this.nodeList = new ArrayList<>();
    }

    // Node class
    private class Node {
        T e;
        Node linkForwards;
        Node linkBackwards;

        public Node(T e) {
            this.e = e;
        }
    }
    @Override
    public MyLinkedList2<T> clone() {
        MyLinkedList2<T> cloneList = new MyLinkedList2<>();  // New list for the clone
        Node current = head;

        // Traverse through the original list and copy each node
        while (current != null) {
            cloneList.add(current.e);  // Add a new node with the same element to the clone
            current = current.linkForwards;
        }

        return cloneList;
    }

    @Override
    public String toString() {
        int counter = 0;
        String str = "[";
        MyLinkedList2.Node position = head;
        while (position != null) {
            if(counter==size()-1) {
                str = str + position.e;
                break;
            }
            str = str + position.e + ", ";
            position = position.linkForwards;
            counter++;
        }
        str = str + "]";
        return str;
    }

    // Add a new node to the list
    @Override
    public boolean add(T element) {
        Node newNode = new Node(element);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.linkForwards = newNode;
            newNode.linkBackwards = tail;
            tail = newNode;
        }
        nodeList.add(newNode);  // Track this node in nodeList
        linkCounter++;
        return true;
    }

    public T someUnneededMethod() {
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object refE) {
        if (refE == null) {
            return false; // Handle null case explicitly
        }

        // Search for the node corresponding to the element
        Node nodeToRemove = null;
        for (Node node : nodeList) {
            if (node.e.equals(refE)) {
                nodeToRemove = node;
                break;
            }
        }

        if (nodeToRemove == null) {
            return false; // Element not found
        }

        // Case 1: Node is head
        if (nodeToRemove == head) {
            head = head.linkForwards;
            if (head != null) head.linkBackwards = null;
            else tail = null;
        }
        // Case 2: Node is tail
        else if (nodeToRemove == tail) {
            tail = tail.linkBackwards;
            if (tail != null) tail.linkForwards = null;
        }
        // Case 3: Node is somewhere in the middle
        else {
            nodeToRemove.linkBackwards.linkForwards = nodeToRemove.linkForwards;
            nodeToRemove.linkForwards.linkBackwards = nodeToRemove.linkBackwards;
        }

        // Remove the node from the nodeList (ArrayList)
        nodeList.remove(nodeToRemove);
        linkCounter--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        someUnneededMethod();
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        someUnneededMethod();
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        someUnneededMethod();
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        someUnneededMethod();
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        someUnneededMethod();
        return false;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        linkCounter = 0;
    }

    @Override
    public T get(int index) {
        someUnneededMethod();
        return null;
    }

    @Override
    public T set(int index, T element) {
        someUnneededMethod();
        return null;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > linkCounter) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node newNode = new Node(element);

        // Case 1: Adding at the head (index 0)
        if (index == 0) {
            if (head == null) {
                head = tail = newNode;  // If the list is empty, head and tail are the same
            } else {
                newNode.linkForwards = head;
                head.linkBackwards = newNode;
                head = newNode;
            }
        }
        // Case 2: Adding at the tail (index == size)
        else if (index == linkCounter) {
            if (tail == null) {
                head = tail = newNode;  // If the list is empty, head and tail are the same
            } else {
                tail.linkForwards = newNode;
                newNode.linkBackwards = tail;
                tail = newNode;
            }
        }
        // Case 3: Adding in the middle
        else {
            Node position = nodeList.get(index);  // Find the node at the given index
            newNode.linkForwards = position;
            newNode.linkBackwards = position.linkBackwards;

            // Adjust the neighboring nodes
            if (position.linkBackwards != null) {
                position.linkBackwards.linkForwards = newNode;
            }
            position.linkBackwards = newNode;
        }

        nodeList.add(index, newNode);  // Track the new node in nodeList
        linkCounter++;
    }

    // Remove a node using the nodelist and index (O(1) removal)
    public T remove(int index) {
        if (index < 0 || index >= linkCounter) {
            System.out.println("Index out of bounds.");
            return null;
        }

        Node nodeToRemove = nodeList.get(index);  // Access the node in O(1)

        // Remove the node from the doubly linked list
        if (nodeToRemove == head) {
            head = head.linkForwards;
            if (head != null) head.linkBackwards = null;
            else tail = null;
        } else if (nodeToRemove == tail) {
            tail = tail.linkBackwards;
            if (tail != null) tail.linkForwards = null;
        } else {
            nodeToRemove.linkBackwards.linkForwards = nodeToRemove.linkForwards;
            nodeToRemove.linkForwards.linkBackwards = nodeToRemove.linkBackwards;
        }

        // Remove the node from the nodeList (ArrayList)
        nodeList.remove(index);
        linkCounter--;
        return nodeToRemove.e;
    }

    @Override
    public int indexOf(Object o) {
        someUnneededMethod();
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        someUnneededMethod();
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        someUnneededMethod();
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        someUnneededMethod();
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        someUnneededMethod();
        return List.of();
    }

    // Optional: Get size
    public int size() {
        return linkCounter;
    }

    @Override
    public boolean isEmpty() {
        someUnneededMethod();
        return false;
    }

    @Override
    public boolean contains(Object o) {
        someUnneededMethod();
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        someUnneededMethod();
        return null;
    }

    @Override
    public Object[] toArray() {
        someUnneededMethod();
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        someUnneededMethod();
        return null;
    }
}

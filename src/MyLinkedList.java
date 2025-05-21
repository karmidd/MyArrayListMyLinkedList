import java.util.*;

public class MyLinkedList<T> implements List<T> {

    private Node head;
    private Node tail;
    private int linkCounter;

    public MyLinkedList() {
        head = null;
        tail = null;
        linkCounter = 0;
    }

    public boolean indexOutOfBounds(int index){
        return index < 0 || index > linkCounter;
    }
    private void addAtHead(T e) {
        Node temp = head;
        head = new Node(e, null, head);
        if (temp != null)
            temp.linkBackwards = head;
        if (tail == null)
            tail = head;
        linkCounter++;
    }
    @Override
    public boolean add(T e) {
        if (head == null) {
            addAtHead(e);
            return true;
        }
        tail.linkForwards = new Node(e, tail, null);
        tail = tail.linkForwards;
        linkCounter++;
        return true;
    }

    @Override
    public void add(int index, T newE) {
        if(indexOutOfBounds(index)) {
            return;
        }
        if(index == 0) {
            addAtHead(newE);
            return;
        }
        if (head == null) {
            System.out.println("List of Es is empty.");
            return;
        }
        int count = 1;
        Node position = head;
        while (position != null && count < index) {
            count++;
            position = position.linkForwards;
        }
        if (position == null) {
            return;
        }
        if (position.linkForwards == null) {
            add(newE);
        } else {
            Node temp = position.linkForwards;
            position.linkForwards = new Node(newE, position, position.linkForwards);
            temp.linkBackwards = position.linkForwards;
            linkCounter++;
        }
    }

    @Override
    public boolean remove(Object refE) {
        if (head == null) {
            System.out.println("List of elements is empty.");
            return false;
        }
        Node position = head;
        if (position.e.equals(refE)) {
            Node temp = head;
            head = head.linkForwards;
            linkCounter--;
            if (head == null) {
                tail = null;
            }
            temp.linkForwards = null;
            return true;
        }
        while (position.linkForwards != null && !position.linkForwards.e.equals(refE)) {
            position = position.linkForwards;
        }
        if (position.linkForwards == null && !position.e.equals(refE)) {
            return false;
        } else if (position.linkForwards == null && position.e.equals(refE)) {
            head = null;
            tail = null;
            linkCounter--;
            return true;
        } else {
            Node temp = position.linkForwards;
            position.linkForwards = position.linkForwards.linkForwards;
            temp.linkForwards = null;
            temp.linkBackwards = null;
            if (position.linkForwards == null)
                tail = position;
            linkCounter--;
            return true;
        }
    }
    @Override
    public T remove(int index){
        if(indexOutOfBounds(index)) {
            return null;
        }
        if (head == null) {
            System.out.println("List of elements is empty.");
            return null;
        }
        if(index==0){
            Node temp = head;
            if(linkCounter==1){
                head = null;
                tail = null;
            }
            else{
                head = head.linkForwards;
                head.linkBackwards = null;
            }
            temp.linkForwards = null;
            temp.linkBackwards = null;
            linkCounter--;
            return temp.e;
        }
        int count = 0;
        Node position = head;
        while (position != null && count < index) {
            count++;
            position = position.linkForwards;
        }
        Node temp = position;
        if(temp.linkForwards == null){
            temp.linkBackwards.linkForwards = null;
            tail = temp.linkBackwards;
            temp.linkBackwards = null;
            linkCounter--;
            return temp.e;
        }
        temp.linkBackwards.linkForwards = temp.linkForwards;
        temp.linkForwards.linkBackwards = temp.linkBackwards;
        temp.linkForwards = null;
        temp.linkBackwards = null;
        linkCounter--;
        return temp.e;
    }

    @Override
    public String toString() {
        int counter = 0;
        String str = "[";
        Node position = head;
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
    @Override
    public MyLinkedList<T> clone() {
        MyLinkedList<T> clonedList = new MyLinkedList<>();
        Node position = head;
        while (position != null) {
            clonedList.add(position.e);
            position = position.linkForwards;
        }
        return clonedList;
    }
    public T someUnneededMethod() {
        throw new UnsupportedOperationException();
    }

    @Override
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

    public T getE(int index) {
        Node position = head;
        int counter = 1;
        if (position == null)
            return null;
        else {
            while (position.linkForwards != null && counter != index) {
                position = position.linkForwards;
                counter++;
            }
            return position.e;
        }
    }

    private class Node {
        private T e;
        private Node linkForwards;
        private Node linkBackwards;

        private Node(T e, Node back, Node forw) {
            this.e = e;
            this.linkForwards = forw;
            this.linkBackwards = back;
        }
    }
}

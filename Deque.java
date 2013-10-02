import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private class Node {
        private Node prev;
        private Item data;
        private Node next;

        public Node(Item data) {
            prev = null;
            this.data = data;
            next = null;
        }
    }
    //Add n before m and return n
    private Node joinBefore(Node n, Node m) {
        m.prev = n;
        n.next = m;
        return n;
    }
    //Add n after m and return n
    private Node joinAfter(Node n, Node m) {
        m.next = n;
        n.prev = m;
        return n;
    }
    private Node head, tail;
    private int size;
    // construct an empty deque
    public Deque() {
        head = tail = null;
        size = 0;
    }   
    // is the deque empty?
    public boolean isEmpty() {
        return size==0 ;
    }
    // return the number of items on the deque
    public int size() {
        return size;
    }
    // insert the item at the front              
    public void addFirst(Item item) {
        if (item == null) throw new java.lang.NullPointerException();
        if (isEmpty()) {
            head = tail = new Node(item);
            size++ ;
            return ;
        }
        head = joinBefore(new Node(item), head);
        size ++;
    }
    // insert the item at the end
    public void addLast(Item item) {
        if (item == null) throw new java.lang.NullPointerException();
        if (isEmpty()) {
            head = tail = new Node(item);
            size++ ;
            return ;
        }
        tail = joinAfter(new Node(item), tail);
        size++ ;
    } 
    // delete and return the item at the front
    public Item removeFirst() {
        if(isEmpty()) throw new java.util.NoSuchElementException();
        Item item = head.data;
        head = head.next;
        size-- ;
        if(!isEmpty()) head.prev = null;
        else head = tail = null;
        return item;
    }
    // delete and return the item at the end       
    public Item removeLast() {
        if(isEmpty()) throw new java.util.NoSuchElementException();
        Item item = tail.data;
        tail = tail.prev;
        size-- ;
        if(!isEmpty()) tail.next = null;
        else tail = head = null ;
        return item;
    }
    // return an iterator over items in order from front to end 
    public Iterator<Item> iterator() {
        return new DequeIterator();
    } 
    private class DequeIterator implements Iterator<Item> {
        private Node current = head;
        int index = size;
        public boolean hasNext() {
            return index != 0 && current != null;
        }

        public Item next() {
            if(index == 0 || current == null) throw new java.util.NoSuchElementException();
            Item item = current.data;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}

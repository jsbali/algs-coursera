import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    // construct an empty randomized queue
    private Item[] rQ;
    private int N;//size
    
    public RandomizedQueue() {
        rQ = (Item[] ) new Object[2];
    }

    private void resize(int capacity) {
        assert capacity >= N ;
        Item[] temp = (Item[] ) new Object[capacity];
        for (int i = 0; i < N; i++) {
                temp[i] = rQ[i];
        }
        rQ = temp;
    }

    // is the queue empty?
    public boolean isEmpty()  {
        return N == 0;
    }

    // return the number of items on the queue
    public int size() {
        return N ;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) throw new java.lang.NullPointerException();
        if (N == rQ.length) resize(2*rQ.length);    // double size of array if necessary
        rQ[N++] = item;                            // add item
    }

    // delete and return a random item
    public Item dequeue() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        int idx = StdRandom.uniform(N);
        Item item = rQ[idx];
        rQ[idx] = rQ[N-1];
        rQ[N-1] = null;
        N-- ;
        
        if (N > 0 && N == (rQ.length/4) ) resize(rQ.length/2);  
        return item;
    }

    // return (but do not delete) a random item
    public Item sample() {
        if (isEmpty()) throw new java.util.NoSuchElementException();
        return rQ[StdRandom.uniform(N)];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomisedQueueIterator();
    }

    private class RandomisedQueueIterator implements Iterator<Item> {
        private int[] arr ;
        private int idx;
        public RandomisedQueueIterator() {
            arr = new int[N] ;
            for(int i=0;i<N;i++)
                arr[i] = i;
            StdRandom.shuffle(arr);
        }

        public boolean hasNext() {
            return idx < N;
        }

        public Item next() {
            if(idx == N) throw new java.util.NoSuchElementException();
            return rQ[arr[idx++]];
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
}
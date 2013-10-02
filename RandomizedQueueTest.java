import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class RandomizedQueueTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testInsert() {
        int[] arr = {1,2,3,4,5};
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        for (int i:arr) {
            rq.enqueue(i);
            assertEquals(i, rq.size());
        }
        assertEquals(5, rq.size());
    }

    @Test
    public void oneElementInsertDelete() {
        String value = "Hi";
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        rq.enqueue(value);
        assertEquals(value,rq.dequeue());
    }

    @Test
    public void oneElementInsertSample() {
        String value = "Hi";
        RandomizedQueue<String> rq = new RandomizedQueue<String>();
        rq.enqueue(value);
        assertEquals(value,rq.sample());
    }

    @Test
    public void testInsertDelete() {
        int[] arr = {1,2,3,4,5,6};
        int[] brr = new int[6];
        RandomizedQueue<Integer> rQ = new RandomizedQueue<Integer>();
        for (int i:arr)
            rQ.enqueue(i);
        assertEquals(6, rQ.size());
        for (int i = 0; i<6; i++)
            brr[i] = rQ.dequeue();
        assertEquals(0, rQ.size());
        for (int i:arr)
            rQ.enqueue(i);
        assertEquals(6, rQ.size());
        for (int i = 0; i<6; i++)
            brr[i] = rQ.dequeue();
        Arrays.sort(brr);
        assertArrayEquals(brr, arr);    
        assertEquals(0, rQ.size());
    }

    @Test
    public void testIterator() {
        int[] arr = {1,2,3,4,5,6};
        int[] brr = new int[6];
        RandomizedQueue<Integer> rQ = new RandomizedQueue<Integer>();
        for (int i:arr)
            rQ.enqueue(i);
        int idx = 0;
        for (int i: rQ)
            brr[idx++] = i;
        Arrays.sort(brr);
        assertArrayEquals(brr, arr);
    }

    @Test 
    public void testInsertDel() {
        RandomizedQueue<Integer> rQ = new RandomizedQueue<Integer>();
        rQ.enqueue(1);
        rQ.enqueue(2);
        rQ.dequeue();
        rQ.dequeue();
        rQ.enqueue(1);
        assertEquals(1,rQ.size());
    }
    @Test(expected=java.util.NoSuchElementException.class)
    public void emptyDelete() {
        RandomizedQueue<Integer> rq = new RandomizedQueue<Integer>();
        rq.dequeue();
    }
}

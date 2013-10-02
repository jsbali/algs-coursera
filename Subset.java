public class Subset {
    public static void main(String[] args) {
        int K = Integer.parseInt(args[0]);
        int N=0;
        RandomizedQueue<String> rQ = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            rQ.enqueue(StdIn.readString());
            N++;
        }
        while (N>K) { 
            rQ.dequeue();
            N--;
        }
        for (String s: rQ)
            StdOut.println(s);
    }
}
import java.util.Arrays;


public class Fast {
    public static void main(String[] args) {
        In inp = new In("http://coursera.cs.princeton.edu/algs4/testing/collinear/input10000.txt");
        int N = inp.readInt();
        Point[] pa = new Point[N];
        Point[] aux = new Point[N];



        for (int i = 0, x , y; i < N; i++) {
            x = inp.readInt();
            y = inp.readInt();
            pa[i] = new Point(x, y);
            aux[i] = new Point(x, y);
        }

        for(int i = 0; i < N; i++) {
            Arrays.sort(aux,pa[i].SLOPE_ORDER);
            Double slope = Double.NEGATIVE_INFINITY;
            for(int j = 1, count = 1; j<N; j++) {
                Double newSlope = pa[i].slopeTo(aux[j]);
                if(Double.compare(slope,newSlope) != 0)
                {
                    slope = newSlope;

                    if(count >= 3) {
                        StdOut.print(pa[i]);
                        for(; count != 0; count--) {
                            
                        }
                        StdOut.println();
                    }
                    count = 1;
                }
                else 
                    count++;
            }
        }
    }
}

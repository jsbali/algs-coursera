import java.util.Arrays;


public class Fast {
    private static void mydraw(int j,int count,Point p,Point[] aux) {
        if(count >= 3) {
            int idx;
            for(idx = count ;idx != 0 && p.compareTo(aux[j-idx]) < 0; idx--);
            Arrays.sort(aux, j-count, j);

            if(idx==0) {
                StdOut.print(p);
                for( ;count != 0; count--)
                    StdOut.print(" -> " + aux[j-count]);
                StdOut.println();
                p.drawTo(aux[j-1]);
            }
        }
    }
    public static void main(String[] args) {
        In inp = new In(args[0]);
        int N = inp.readInt();
        Point[] pa = new Point[N];
        Point[] aux = new Point[N];

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        for (int i = 0, x , y; i < N; i++) {
            x = inp.readInt();
            y = inp.readInt();
            pa[i] = new Point(x, y);
            pa[i].draw();
            aux[i] = new Point(x, y);
        }

        for(int i = 0; i < N; i++) {
            Arrays.sort(aux,pa[i].SLOPE_ORDER);
            Double slope = Double.NEGATIVE_INFINITY;
            int count = 1;
            for(int j = 1; j<N; j++) {
                Double newSlope = pa[i].slopeTo(aux[j]);
                if(Double.compare(slope,newSlope) != 0)
                {
                    slope = newSlope;                    
                    mydraw(j, count, pa[i], aux);
                    count = 1;
                }
                else 
                    count++;
            }
            mydraw(N, count, pa[i], aux);
        }
    }
}

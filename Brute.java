import java.util.Arrays;


public class Brute {
    public static void main(String[] args) {

        In inp = new In(args[0]);
        int N = inp.readInt();

        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);

        Point[] pa = new Point[N];
        for (int i = 0; i < N; i++) {
            int x = inp.readInt();
            int y = inp.readInt();
            pa[i] = new Point(x, y);
            pa[i].draw();
        }
        Arrays.sort(pa);
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {

                    double ij = pa[i].slopeTo(pa[j]);
                    double ik = pa[i].slopeTo(pa[k]);

                    if(Double.compare(ij, ik) == 0) {

                        for (int l = k+1; l < N; l++) {
                            double il = pa[i].slopeTo(pa[l]);

                            if (Double.compare(ij, il) == 0) 
                            {
                                StdOut.println(pa[i]+" -> "+pa[j]+" -> "+pa[k]+" -> "+pa[l]);
                                pa[i].drawTo(pa[l]);
                            }
                        }
                    }
                }
            }
        }
    }
}

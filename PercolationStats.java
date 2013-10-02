
public class PercolationStats {
	private double mean,stddev,confidenceHi,confidenceLo;
	// perform T independent computational experiments on an N-by-N grid
	public PercolationStats(int N, int T) {
		if(N<=0 || T<=0) throw new java.lang.IllegalArgumentException("Index out of bound");
		double[] percolationBound=new double[T];
		for(int t=0;t<T;t++) {
			Percolation p = new Percolation(N);
			int count = 0;
			while(!p.percolates()) {
				int x = StdRandom.uniform(N)+1;
				int y = StdRandom.uniform(N)+1;
				if(!p.isOpen(x, y)) {
					count++;
					p.open(x, y);
				}
			}
			percolationBound[t] = ((double)count)/(N*N);
		}
		mean=StdStats.mean(percolationBound);
		stddev=StdStats.stddev(percolationBound);
		
		confidenceLo = mean - ((1.96*stddev)/Math.sqrt(T));
		confidenceHi = mean + ((1.96*stddev)/Math.sqrt(T));
	}
	// sample mean of percolation threshold
	public double mean() {
		return this.mean;
	}
	// sample standard deviation of percolation threshold
	public double stddev() {
		return this.stddev;
	} 
	// returns lower bound of the 95% confidence interva
	public double confidenceLo() {
		return this.confidenceLo;
	} 
	// returns upper bound of the 95% confidence intervall
	public double confidenceHi() {
		return this.confidenceHi;
	} 
	// test client, described below
	public static void main(String[] args) {
		PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		StdOut.println(stats.mean());
		StdOut.println(stats.stddev());
		StdOut.println(stats.confidenceLo()+","+stats.confidenceHi());
	}   
}
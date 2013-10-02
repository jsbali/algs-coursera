
public class Percolation {
    private int N;
	private boolean[][] grid;
	private int topVirtual, bottomVirtual;
	private WeightedQuickUnionUF unionFindPercolates;
	private WeightedQuickUnionUF unionFindFull;
	// create N-by-N grid, with all sites blocked
	
	public Percolation(int N) {
		this.N = N; 
		unionFindPercolates = new WeightedQuickUnionUF(N*N + 2);
		unionFindFull = new WeightedQuickUnionUF(N*N + 1);
		topVirtual = 0;
		bottomVirtual = N*N + 1; 
 		grid = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			unionFindPercolates.union(i+1, topVirtual);
			unionFindFull.union(i+1, topVirtual);
			unionFindPercolates.union(N*(N-1)+i+1, bottomVirtual);
		}
	} 
	// open site (row i, column j) if it is not already
	public void open(int i, int j) {
		i-- ; 
		j-- ;
		if(grid[i][j]) return;
		grid[i][j] = true;

		if ( i>0 && grid[i-1][j] ) 
		{
			unionFindPercolates.union((i-1)*N+j+1, i*N+j+1);
			unionFindFull.union((i-1)*N+j+1, i*N+j+1);
		}
		if ( j>0 && grid[i][j-1] ) 
		{
			unionFindPercolates.union(i*N+(j-1)+1,i*N+j+1);
			unionFindFull.union(i*N+(j-1)+1,i*N+j+1);
		}
		if( j<N-1 && grid[i][j+1] ) {
			unionFindPercolates.union(i*N+(j+1)+1,i*N+j+1);
			unionFindFull.union(i*N+(j+1)+1,i*N+j+1);
		}
		if( i<N-1 && grid[i+1][j] ) {
			unionFindPercolates.union((i+1)*N+j+1,i*N+j+1);
			unionFindFull.union((i+1)*N+j+1,i*N+j+1);
		}

	}         
	// is site (row i, column j) open?  
	public boolean isOpen(int i, int j) {
		i--;j--;
		return grid[i][j];
	}    
	// is site (row i, column j) full?
	public boolean isFull(int i, int j) {
		if(i<1||i>N||j<1||j>N)throw new java.lang.IndexOutOfBoundsException();
		i--;j--;
		return grid[i][j] && unionFindFull.connected(topVirtual,i*N+j+1) ;
	}    
	// does the system percolate?
	public boolean percolates() {
		if(N==1)return grid[0][0];
		return unionFindPercolates.connected(topVirtual,bottomVirtual);
	}
}
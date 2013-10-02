import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class PointTest {

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void CheckCOmparator() {
        Point[] arr = new Point[5];
        arr[0] = new Point(0,0);
        arr[1] = new Point(1,1);
        arr[2] = new Point(0,2);
        arr[3] = new Point(-3,3);
        arr[4] = new Point(-4,0);
        Arrays.sort(arr,arr[0].SLOPE_ORDER);
    } 
    @Test
    public void test() {
        Double[] arr = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, -2.0 , 2.0};
        Double[] arrSort = { Double.NEGATIVE_INFINITY, -2.0, 2.0, Double.POSITIVE_INFINITY};
        Arrays.sort(arr);
        assertArrayEquals(arrSort,arr);
    }

    @Test
    public void removeDups() {
        int[] pa = {1,2,3,4,5,6};
        Arrays.sort(pa);
        
        int idx = 0; 
        
        for(int i=1 ;i<6 ;i++)
            if(pa[i] != pa[idx]) 
                pa[++idx] = pa[i];
        
        System.out.println(idx);
    }
}

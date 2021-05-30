package hw2;
import org.junit.Test;


public class PercolationStatsTest {
    @Test
    //N 200 T 30 time : 59s 691ms
    //N 300 T 30 time :6min 59sec   mean:0.5924     stddev:0.0080144
    public void testConstructor() throws IndexOutOfBoundsException{
        PercolationStats pS = new PercolationStats(300,30,new PercolationFactory());
        for(double d: pS.openThresh)
            System.out.println(d);
        System.out.println(pS.mean());
        System.out.println(pS.stddev());

    }
}

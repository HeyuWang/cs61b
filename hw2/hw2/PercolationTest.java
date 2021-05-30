package hw2;
import org.junit.Test;
import static org.junit.Assert.*;

public class PercolationTest {

    @Test
    public void testBooleanDefaultValue(){
        boolean[] b = new boolean[20];
        for(boolean bool:b){
            System.out.println(bool);
        }
    }

    @Test
    public void test2DTo1D(){
        Percolation p = new Percolation(5);
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                int oneD = p.xyTo1d(i,j);
                System.out.println(oneD);
            }
        }
    }

    @Test
    public void testOpenIsOpen(){

            int N = 4;
            Percolation p = new Percolation(N);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (p.isOpen(i, j)) {
                        System.out.println("found open " + i + " " + j);
                    }
                }
            }
        try {
            p.open(1, 3);
        }catch (IndexOutOfBoundsException idxEx){
            ;
        }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (p.isOpen(i, j)) {
                        System.out.println("found open " + i + " " + j);
                    }
                }
            }

    }

    @Test
    public void testIsFull(){
        int  N = 5;
        Percolation p = new Percolation(N);
        for(int i = 0; i < N; i++){
            try {
                p.open(0, i);
            }catch (IndexOutOfBoundsException indexE){
                ;
            }
        }
        boolean res = p.isFull(0,N-1);
        assertTrue(res);
    }

    @Test
    public void doubleDefaultTest(){
        double[] d = new double[2];
        System.out.println(d[0]+"\n"+d[1]);
    }
}

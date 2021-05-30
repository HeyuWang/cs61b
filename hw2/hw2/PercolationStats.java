package hw2;
import edu.princeton.cs.introcs.StdStats;
import edu.princeton.cs.introcs.StdRandom;

public class PercolationStats {
    public PercolationStats(int N, int T, PercolationFactory pf) throws IndexOutOfBoundsException{
        if(N <=0 || T <= 0)
            throw new IndexOutOfBoundsException();

        this.T = T;
        openThresh = new double[T];/*set to 0.0 by default initialization*/

        for(int i = 0; i < T; i++){
            int openCount = 0;
            Percolation p = pf.make(N);
            while(!p.percolates()){
                /*1. random choose to open*/
                int row = (int)(N * StdRandom.uniform());
                int col = (int)(N * StdRandom.uniform());
                if(!p.isOpen(row,col)){
                    openCount++;
                    p.open(row, col);
                }
            }
            openThresh[i] = (double)(openCount)/ (double)(N*N);
        }
    }

    public double[] openThresh;

    public double mean(){
        return StdStats.mean(openThresh);
    }

    public double stddev(){
        return StdStats.stddev(openThresh);
    }

    public double confidenceLow(){
        double res = mean() - 1.96 * stddev() / (double) (Math.sqrt(T));
        return res;
    }

    public double confidenceHigh(){
        double res = mean() + 1.96 * stddev() / (double) (Math.sqrt(T));
        return res;
    }

    private int T;
}

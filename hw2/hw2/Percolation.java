package hw2;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    public Percolation(int N){
        if(N <= 0) {
            throw new IndexOutOfBoundsException("Constructor initialization error");
        }
        grid = new boolean[N*N];
        len = N;
        uf = new WeightedQuickUnionUF(N*N);
        /*test show default value for grid is false*/
    }

    public void open(int row, int col) throws IndexOutOfBoundsException{
        if (row < 0 || row > len - 1 || col < 0 || col > len - 1) {
            throw new IndexOutOfBoundsException("Open error");
        }
        int oneD = xyTo1d(row, col);
        grid[oneD] = true;

        int upper = xyTo1d(row - 1, col);
        if (0 <= row - 1 && row - 1 < len && 0 <= col && col < len && grid[upper] == true ) {
            uf.union(oneD, upper);
        }

        int below = xyTo1d(row + 1, col);
        if (0 <= row + 1 && row + 1 < len && 0 <= col && col  < len && grid[below] == true ) {
            uf.union(oneD, below);
        }

        int left = xyTo1d(row, col - 1);
        if (0 <= row && row  < len && 0 <= col-1 && col - 1 < len && grid[left] == true) {
            uf.union(oneD, left);
        }

        int right = xyTo1d(row, col + 1);
        if (0 <= row && row < len && 0 <= col + 1 && col + 1 < len && grid[right] == true) {
            uf.union(oneD, right);
        }


    }

    public boolean isOpen(int row, int col){
        if (row < 0 || row > len - 1 || col < 0 || col > len - 1) {
            throw new IndexOutOfBoundsException("Open error");
        }
        int oneD = xyTo1d(row, col);
        return (grid[oneD] == true);
    }

    public boolean isFull(int row, int col){
        boolean res = false;
        for(int i = 0; i < len; i++){
            int top = xyTo1d(0,i);
            int cur = xyTo1d(row, col);
            if (isOpen(0, i) && isOpen(row, col) && uf.connected(top, cur)) {
                res = true;
                break;
            }
        }
        return res;
    }

    public int numberOfOpenSites(){
        int count  = 0;
        for(int i = 0; i < len; i++){
            if(isFull(len-1,i)){
                count++;
            }
        }
        return count;
    }

    public boolean percolates(){
        boolean res = false;
        for(int i = 0; i < len; i++){
            if(isFull(len-1,i)){
                res = true;
                break;
            }
        }
        return res;
    }


    private boolean[] grid;
    private int len;
    private WeightedQuickUnionUF uf;

    public int xyTo1d(int row, int col){
        int ret = len * row + col;
        return ret;
    }
}
